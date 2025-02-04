package ecommerce.model.dao;

// Entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Produto;

import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.ItensCarrinho;

// Imports obrigatórios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultasDAO {
    private Connection connection;

    public ConsultasDAO() {
    }

    // Consulta 1: Busca clientes com seus respectivos endereços
    public List<Cliente> listarClientesComEndereco(Connection connection) {
        String sql = "SELECT c.id AS cliente_id, c.nome AS cliente_nome, c.cpf, c.email, c.telefone, c.dataNascimento, c.nacionalidade, c.genero, " +
                     "e.id AS endereco_id, e.cep, e.rua, e.complemento, e.logradouro, e.bairro, e.cidade, e.estado, e.numero " +
                     "FROM cliente c " +
                     "JOIN endereco e ON c.endereco_id = e.id";
        List<Cliente> clientes = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setNome(rs.getString("cliente_nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                cliente.setNacionalidade(rs.getString("nacionalidade"));
                cliente.setGenero(rs.getString("genero"));

                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("endereco_id"));
                endereco.setCep(rs.getInt("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setNumero(rs.getInt("numero"));

                cliente.setEndereco(endereco);
                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientes;
    }

    // Consulta 2: Listar produtos com suas avaliações
    public List<Avaliacao> listarAvaliacoesComProduto(Connection connection) {
        String sql = "SELECT a.nota, a.comentario, a.data, a.cliente_id, " +
                     "p.id AS produto_id, p.nome AS produto_nome, p.descricao, p.valor_atual, p.custo_atual, p.estoque " +
                     "FROM avaliacao a " +
                     "JOIN produto p ON a.produto_id = p.id";
        List<Avaliacao> avaliacoes = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setNota(rs.getInt("nota"));
                avaliacao.setComentario(rs.getString("comentario"));
                avaliacao.setData(rs.getDate("data"));

                // Criando o cliente a partir do cliente_id
                int clienteId = rs.getInt("cliente_id");
                Cliente cliente = new Cliente();
                cliente.setId(clienteId);  // Setando o ID do cliente (você pode preencher os outros atributos do Cliente conforme necessário)

                avaliacao.setCliente(cliente); // Setando o cliente na avaliação

                Produto produto = new Produto();
                produto.setId(rs.getInt("produto_id"));
                produto.setNome(rs.getString("produto_nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValorAtual(rs.getDouble("valor_atual"));  
                produto.setCustoAtual(rs.getDouble("custo_atual"));  
                produto.setEstoque(rs.getInt("estoque"));

                avaliacao.setProduto(produto);
                avaliacoes.add(avaliacao);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return avaliacoes;
    }



    public List<Carrinho> listarCarrinhosComItensECliente(Connection connection) {
        // A consulta une o carrinho com o cliente, com os itens do carrinho e com o produto.
        String sql = "SELECT " +
                     "  ca.id AS carrinho_id, " +
                     "  ca.data_criacao, " +
                     "  cli.id AS cliente_id, " +
                     "  cli.nome AS cliente_nome, " +
                     "  cli.email, " +
                     "  cli.telefone, " +
                     "  ic.produto_id, " +
                     "  ic.quantidade, " +
                     "  ic.preco_unitario, " +
                     "  p.nome AS produto_nome, " +
                     "  p.descricao AS produto_descricao, " +
                     "  p.valor_atual AS produto_valorAtual " +
                     "FROM ecommerce.carrinho ca " +
                     "JOIN ecommerce.cliente cli ON ca.cliente_id = cli.id " +
                     "LEFT JOIN ecommerce.itensCarrinho ic ON ca.id = ic.carrinho_id " +
                     "LEFT JOIN ecommerce.produto p ON ic.produto_id = p.id " +
                     "ORDER BY ca.id";

        // Usamos um Map para evitar criar objetos Carrinho duplicados
        Map<Integer, Carrinho> carrinhosMap = new HashMap<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int carrinhoId = rs.getInt("carrinho_id");
                Carrinho carrinho = carrinhosMap.get(carrinhoId);

                // Se ainda não criamos o objeto Carrinho, cria-o e associa o Cliente
                if (carrinho == null) {
                    carrinho = new Carrinho();
                    carrinho.setId(carrinhoId);
                    carrinho.setDataCriacao(rs.getTimestamp("data_criacao"));

                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("cliente_id"));
                    cliente.setNome(rs.getString("cliente_nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));
                    carrinho.setCliente(cliente);

                    // Inicializa a lista de itens (assegure que sua classe Carrinho possua esse atributo)
                    carrinho.setItens(new ArrayList<>());

                    carrinhosMap.put(carrinhoId, carrinho);
                }

                // Se houver um item (produto_id pode ser nulo caso o carrinho não tenha itens ainda)
                int produtoId = rs.getInt("produto_id");
                if (!rs.wasNull()) {
                    ItensCarrinho item = new ItensCarrinho();
                    // Associa o carrinho ao item, se necessário
                    item.setCarrinho(carrinho);

                    // Cria um objeto Produto e popula seus atributos a partir do ResultSet
                    Produto produto = new Produto();
                    produto.setId(produtoId);
                    produto.setNome(rs.getString("produto_nome"));
                    produto.setDescricao(rs.getString("produto_descricao"));
                    produto.setValorAtual(rs.getDouble("produto_valorAtual"));
                    item.setProduto(produto);

                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setPrecoUnitario(rs.getDouble("preco_unitario"));

                    // Adiciona o item à lista do carrinho
                    carrinho.getItens().add(item);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Retorna os carrinhos agrupados
        return new ArrayList<>(carrinhosMap.values());
    }





    
    
    
    
   /**
    * Obtém a quantidade de pedidos por cliente. 
    * (Pedidos são as vendas registradas na tabela "venda", ou seja, compras realizadas.)
    * Retorna uma lista contendo o ID do cliente, nome e a quantidade total de pedidos realizados por ele.
    */
   public List<String> obterQuantidadePedidosPorCliente(Connection connection) {
       String sql = "SELECT c.id AS cliente_id, c.nome, COUNT(v.id) AS total_pedidos " +
                    "FROM ecommerce.cliente c " +
                    "JOIN ecommerce.venda v ON c.id = v.cliente_id " +
                    "GROUP BY c.id, c.nome " +
                    "ORDER BY total_pedidos DESC";

       List<String> resultados = new ArrayList<>();

       try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

           while (rs.next()) {
               resultados.add("Cliente: " + rs.getString("nome") +
                              " | Total de Pedidos: " + rs.getInt("total_pedidos"));
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return resultados;
   }

    
    
    /**
    * Obtém a média de preço total dos pedidos, agrupados pelo tipo de pagamento.
    * Retorna o tipo de pagamento e a média dos preços dos pedidos feitos com esse método.
    */
   public List<String> obterMediaPrecoPorTipoPagamento(Connection connection) {
       String sql = "SELECT v.tipoPagamento, AVG(v.total_pago) AS media_preco " +
                    "FROM ecommerce.venda v " +
                    "GROUP BY v.tipoPagamento " +
                    "HAVING AVG(v.total_pago) > 50 " +
                    "ORDER BY media_preco DESC";

       List<String> resultados = new ArrayList<>();

       try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

           while (rs.next()) {
               resultados.add("Tipo de Pagamento: " + rs.getString("tipoPagamento") +
                              " | Média do Preço Total: " + rs.getDouble("media_preco"));
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return resultados;
   }
    

    /**
    * Obtém os produtos mais vendidos com base na soma da quantidade de itens vendidos.
    * Retorna o ID do produto, nome e a quantidade total vendida, considerando apenas produtos com mais de 5 unidades vendidas.
    */
   public List<String> obterProdutosMaisVendidos(Connection connection) {
       String sql = "SELECT iv.produto_id, p.nome, SUM(iv.quantidade) AS total_vendido " +
                    "FROM ecommerce.itensvenda iv " +
                    "LEFT JOIN ecommerce.produto p ON iv.produto_id = p.id " +
                    "JOIN ecommerce.venda v ON iv.venda_id = v.id " +
                    "WHERE iv.produto_id IS NOT NULL " +
                    "GROUP BY iv.produto_id, p.nome " +
                    "HAVING SUM(iv.quantidade) > 5 " +
                    "ORDER BY total_vendido DESC";

       List<String> resultados = new ArrayList<>();

       try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                resultados.add("Produto: " + rs.getString("nome") +
                               " | Quantidade Total Vendida: " + rs.getInt("total_vendido"));
            }
       } catch (SQLException e) {
            throw new RuntimeException(e);
       }

       return resultados;
   }

    
    
    
    
    
    /**
    * Obtém o total de pedidos realizados no último mês.
    * Retorna a quantidade de pedidos feitos dentro do último mês a partir da data atual.
    */
   public int obterTotalPedidosUltimoMes(Connection connection) {
       String sql = "SELECT COUNT(*) AS total_pedidos " +
                    "FROM ecommerce.venda " +
                    "WHERE data_hora >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)";

       try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

           if (rs.next()) {
               return rs.getInt("total_pedidos");
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return 0;
   }

    

    /**
    * Obtém a média de vendas diárias nos últimos 7 dias.
    * Retorna a média do total de pedidos feitos por dia na última semana.
    */
   public double obterMediaVendasUltimaSemana(Connection connection) {
       String sql = "SELECT SUM(quantidade_pedidos) / 7.0 AS media_vendas_diarias FROM (" +
                    "    SELECT COUNT(*) AS quantidade_pedidos " +
                    "    FROM ecommerce.venda v " +
                    "    WHERE v.data_hora >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) " +
                    "    GROUP BY DATE(v.data_hora)" +
                    ") AS vendas_diarias";

       try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

           if (rs.next()) {
               return rs.getDouble("media_vendas_diarias");
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return 0.0;
   }

    



    /**
    * Obtém os clientes que fizeram pelo menos um pedido no último mês.
    * Retorna uma lista com os nomes dos clientes que realizaram pedidos no último mês.
    */
   public List<String> obterClientesAtivosUltimoMes(Connection connection) {
       String sql = "SELECT DISTINCT c.nome " +
                    "FROM ecommerce.cliente c " +
                    "JOIN ecommerce.venda v ON c.id = v.cliente_id " +
                    "WHERE v.data_hora >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)";

       List<String> clientes = new ArrayList<>();

       try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

           while (rs.next()) {
               clientes.add(rs.getString("nome"));
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return clientes;
   }

    
    

    /**
    * Obtém o cliente que realizou o maior número de pedidos.
    * Retorna o nome do cliente com o maior número de pedidos e o total de pedidos feitos.
    */
   public String obterClienteComMaisPedidos(Connection connection) {
       String sql = "SELECT c.nome, pv.total_pedidos " +
                    "FROM ecommerce.cliente c " +
                    "JOIN ( " +
                    "    SELECT cliente_id, COUNT(*) AS total_pedidos " +
                    "    FROM ecommerce.venda " +
                    "    GROUP BY cliente_id " +
                    "    ORDER BY total_pedidos DESC " +
                    "    LIMIT 1 " +
                    ") pv ON c.id = pv.cliente_id";

       try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

           if (rs.next()) {
               String nomeCliente = rs.getString("nome");
               int totalPedidos = rs.getInt("total_pedidos");
               return nomeCliente + " com um total de " + totalPedidos + " pedidos";
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return null;
   }



    

    /**
    * Obtém os clientes que fizeram pelo menos um pedido cujo valor total foi maior que a média geral de todos os pedidos.
    * Retorna uma lista com os nomes desses clientes.
    */
   public List<String> obterClientesComPedidosAcimaDaMedia(Connection connection) {
       String sql = "SELECT nome FROM ecommerce.cliente " +
                    "WHERE id IN ( " +
                    "   SELECT cliente_id FROM ecommerce.venda " +
                    "   WHERE total_pago > (SELECT AVG(total_pago) FROM ecommerce.venda) " +
                    ")";

       List<String> clientes = new ArrayList<>();

       try (PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

           while (rs.next()) {
               clientes.add(rs.getString("nome"));
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return clientes;
   }


    
    
    /**
     * Obtém os vendedores que possuem produtos com avaliação média superior a 4.
     * Retorna uma lista de strings contendo o nome do vendedor e a quantidade de produtos
     * com avaliação superior a 4.
     */
    public List<String> obterVendedoresComProdutosBemAvaliados(Connection connection) {
    String sql = "SELECT v.nome, COUNT(p.id) AS quantidade_produtos " +
                 "FROM vendedor v " +
                 "JOIN produto p ON v.id = p.vendedor_id " +
                 "WHERE p.id IN ( " +
                 "    SELECT produto_id " +
                 "    FROM avaliacao " +
                 "    GROUP BY produto_id " +
                 "    HAVING AVG(nota) > 4 " + // Aqui calculamos a média diretamente na cláusula HAVING
                 ") " +
                 "GROUP BY v.id";

    List<String> resultado = new ArrayList<>();

    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String nomeVendedor = rs.getString("nome");
            int quantidadeProdutos = rs.getInt("quantidade_produtos");
            resultado.add(nomeVendedor + " - " + quantidadeProdutos + " produto(s)");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return resultado;
}

    
}