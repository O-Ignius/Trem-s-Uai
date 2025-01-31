package ecommerce.model.dao;

// Entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Produto;

import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;

// Imports obrigatórios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "SELECT a.nota, a.comentario, a.data, " +
                     "p.id AS produto_id, p.nome AS produto_nome, p.descricao, p.valor, p.estoque " +
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

                Produto produto = new Produto();
                produto.setId(rs.getInt("produto_id"));
                produto.setNome(rs.getString("produto_nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getDouble("valor"));
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

    // Consulta 3: Listar carrinhos com seus respectivos itens e cliente
    public List<Carrinho> listarCarrinhosComItensECliente(Connection connection) {
        String sql = "SELECT ca.id AS carrinho_id, ca.precoTotal, ca.dataPedido, ca.tipoPagamento, " +
                     "c.id AS cliente_id, c.nome AS cliente_nome, c.email, c.telefone " +
                     "FROM carrinho ca " +
                     "JOIN cliente c ON ca.cliente_id = c.id";
    
        List<Carrinho> carrinhos = new ArrayList<>();
    
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
    
            while (rs.next()) {
                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getInt("carrinho_id"));
                carrinho.setPrecoTotal(rs.getDouble("precoTotal"));
                carrinho.setDataPedido(rs.getDate("dataPedido"));
                carrinho.setTipoPagamento(rs.getInt("tipoPagamento"));
    
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setNome(rs.getString("cliente_nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
    
                carrinho.setCliente(cliente);
                carrinhos.add(carrinho);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
        return carrinhos;
    }
    
    
    
    
    /**
     * Obtém a quantidade de pedido por cliente.(Pedidos sao os carrinhos que foram fechados, ou seja compra realizad)
     * Retorna uma lista contendo o ID do cliente, nome e a quantidade total de pedidos realizados por ele.
     */
    public List<String> obterQuantidadePedidosPorCliente(Connection connection) {
        String sql = "SELECT c.id AS cliente_id, c.nome, COUNT(ca.id) AS total_pedidos " +
                     "FROM cliente c " +
                     "JOIN carrinho ca ON c.id = ca.cliente_id " +
                     "WHERE ca.fechado = true " +  // Filtra para considerar apenas carrinhos fechados
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
        String sql = "SELECT c.tipoPagamento, AVG(c.precoTotal) AS media_preco " +
                     "FROM carrinho c " +
                     "WHERE c.fechado = true " +  // Filtra para considerar apenas carrinhos fechados
                     "GROUP BY c.tipoPagamento " +
                     "HAVING AVG(c.precoTotal) > 50 " +  
                     "ORDER BY media_preco DESC";
        List<String> resultados = new ArrayList<>();
    
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            while (rs.next()) {
                resultados.add("Tipo de Pagamento: " + rs.getInt("tipoPagamento") +
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
        String sql = "SELECT i.produto_id, p.nome, SUM(i.quantidadeItem) AS total_vendido " +
                     "FROM item i " +
                     "LEFT JOIN produto p ON i.produto_id = p.id " +
                     "JOIN carrinho c ON i.carrinho_id = c.id " +  // Junta a tabela carrinho
                     "WHERE c.fechado = true " +  // Filtra apenas carrinhos fechados
                     "AND i.produto_id IS NOT NULL " +  // Evita produtos que foram deletados e ficaram NULL
                     "GROUP BY i.produto_id, p.nome " +
                     "HAVING SUM(i.quantidadeItem) > 5 " +  // Considera apenas produtos com mais de 5 unidades vendidas
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
                     "FROM carrinho " +
                     "WHERE dataPedido >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) " +
                     "AND fechado = true";  // Adiciona a verificação para carrinho fechado
    
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
        String sql = "SELECT AVG(quantidade_pedidos) AS media_vendas_diarias FROM " +
                     "(SELECT COUNT(*) AS quantidade_pedidos " +
                     " FROM carrinho ca " +
                     " WHERE ca.dataPedido >= DATE_SUB(CURDATE(), INTERVAL 7 DAY) " +
                     " AND ca.fechado = true " +  // Verifica se o carrinho foi fechado
                     " GROUP BY DATE(ca.dataPedido)) AS vendas_diarias";
    
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
                     "FROM cliente c " +
                     "JOIN carrinho ca ON c.id = ca.cliente_id " +
                     "WHERE ca.dataPedido >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) " +
                     "AND ca.fechado = true";  // Verifica se o carrinho foi fechado
    
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
     * Retorna o nome do cliente que fez mais compras.
     */
    public String obterClienteComMaisPedidos(Connection connection) {
        String sql = "SELECT nome FROM cliente " +
                     "WHERE id = (SELECT cliente_id FROM carrinho " +
                     "WHERE fechado = true " +
                     "GROUP BY cliente_id " +
                     "ORDER BY COUNT(*) DESC " +
                     "LIMIT 1)";
    
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
    
            if (rs.next()) {
                return rs.getString("nome");
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
        String sql = "SELECT nome FROM cliente " +
                     "WHERE id IN (SELECT cliente_id FROM carrinho " +
                     "WHERE fechado = true " +
                     "AND precoTotal > (SELECT AVG(precoTotal) FROM carrinho WHERE fechado = true))";
    
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
     * Obtém os clientes que gastaram acima da média de todos os clientes.
     * Retorna uma lista com os nomes dos clientes cujo total gasto supera a média geral de gastos.
     */
    public List<String> obterClientesQueGastaramAcimaDaMedia(Connection connection) {
        String sql = "SELECT nome FROM cliente " +
                     "WHERE id IN (SELECT cliente_id FROM carrinho " +
                     "WHERE fechado = true " +
                     "GROUP BY cliente_id " +
                     "HAVING SUM(precoTotal) > (SELECT AVG(total_gasto) FROM " +
                     "(SELECT SUM(precoTotal) AS total_gasto FROM carrinho WHERE fechado = true GROUP BY cliente_id) AS media_gastos))";
    
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
    
}