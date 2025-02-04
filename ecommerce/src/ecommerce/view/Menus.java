package ecommerce.view;

//controller
import ecommerce.controller.EcommerceController;
import ecommerce.model.dao.Conexao;
import ecommerce.model.entity.Avaliacao;

//connection
import java.sql.Connection;

//entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Endereco;
import java.util.List;

//scanner
import java.util.Scanner;

public class Menus{
    EcommerceController ecommerceController = new EcommerceController();
    
    public void cadastroLogin() {
        Scanner input = new Scanner(System.in);
        //para se conectar uma unica vez ao BD
        Connection connection = new Conexao().getConnection();
        
        int op = -1;
        
        while (op != 0) {
            System.out.println("****************************");
            System.out.println("******   Trem's Uai   ******");
            System.out.println("****************************");

            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("3 - Consultas especificas |BD ONLY|");
            System.out.println("0 - Sair");

            op = input.nextInt();
            input.nextLine(); //retirar \n
                
            switch (op) {
                case 1:
                    login(input, connection);
                    break; //retorna para menu principal
                case 2:
                    cadastro(input, connection);
                    break;
                case 3:
                    consultasEspecificas(input, connection);
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        }
        
        //encerra o input ao final
        input.close();
    }
    
    public void cadastro(Scanner input, Connection connection) {
        int op = -1;
        
        while (op != 0) {
            System.out.println("***************************************");
            System.out.println("******   Trem's Uai - Cadastro   ******");
            System.out.println("***************************************");

            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastrar como Cliente");
            System.out.println("2 - Cadastrar como Vendedor");
            System.out.println("0 - Sair");

            op = input.nextInt();
            input.nextLine(); //retirar \n

            switch (op) {
                case 1:
                    ecommerceController.cadastroClienteAutenticacao(input, connection);
                    return; //retorna para menu principal
                case 2:
                    ecommerceController.cadastroVendedorAutenticacao(input, connection);
                    return; //retorna para menu principal
                case 0:
                    return;
                default:
                    System.err.println("Opção inválida!");
            }
        }
    }
    
    public void login(Scanner input, Connection connection) {
        String email = new String();
        String senha = new String();
        int tentarNovamente;
        
        do {
            tentarNovamente = 0;
            
            System.out.println("************************************");
            System.out.println("******   Trem's Uai - Login   ******");
            System.out.println("************************************");

            System.out.print("Digite seu email: \t");
            email = input.nextLine();
            System.out.print("\nDigite sua senha: \t");
            senha = input.nextLine();
            System.out.println("");

            if (ecommerceController.loginAutenticacao(email, senha, input, connection) == -1) {
                System.out.println("Deseja tentar novamente? (1: Sim    0: Não)");
                tentarNovamente = input.nextInt();
            } 
        } while (tentarNovamente != 0);
    }
    
    public void cliente(int id, Scanner scan, Connection connection) {
        EcommerceController ecommerceController = new EcommerceController();
        int opcao = - 99;
        Cliente cliente = new Cliente();
        Carrinho carrinho;
        cliente.setId(id);
        
        while(opcao != 0){
            System.out.println("**************************************");
            System.out.println("******   Trem's Uai - Cliente   ******");
            System.out.println("**************************************");
            System.out.println("1 - Buscar Produtos");
            System.out.println("2 - Ver Carrinho");
            System.out.println("3 - Ver Pedidos finalizados");
            System.out.println("4 - Editar Perfil");
            System.out.println("5 - Excluir Perfil");
            System.out.println("\n0 - Sair");
            
            System.out.println("Digite a opção desejada: ");
            opcao = scan.nextInt();
            scan.nextLine();
            
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    System.out.print("Digite o nome do produto que deseja buscar: ");
                    if(ecommerceController.buscarPornome(scan.nextLine(), connection) > 0){
                        System.out.println("Deseja adcionar ao carrinho? (Sim - 1/Não- 2)");
                        opcao = scan.nextInt();
                        if(opcao == 1){
                            ecommerceController.salvarItem(ecommerceController.lerItem(scan, id, connection), connection);
                        }
                        opcao = 1;
                    }
                    break;
                case 2:

                    if(ecommerceController.buscaItemPorIdCarrinho(ecommerceController.buscaCarrinhoAtual(id, connection), connection) > 0){

                        System.out.println("Deseja finalizar o carrinho? (Sim - 1/Não- 2)");
                        opcao = scan.nextInt();
                        if(opcao == 1){
                            carrinho = ecommerceController.lerCarrinho(scan, ecommerceController.buscaCarrinhoAtual(id, connection));
                            ecommerceController.finalizarCarrinho(carrinho, connection);
                        }
                        opcao = 2;
                    }
                    break;
                case 3:
                    ecommerceController.buscaPedidosFinalizados(id, connection);
                    break;
                case 4:
                    cliente = ecommerceController.lerCliente(scan);
                    //lendo endereco
                    cliente.setEndereco(ecommerceController.lerEndereco(scan));
                    cliente.setId(id);
                    ecommerceController.editarCliente(cliente, id, connection);
                    break;
                case 5:
                    ecommerceController.excluirCliente(id, connection);
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public void vendedor(int id, Scanner scan, Connection connection) {
        EcommerceController ecommerceController = new EcommerceController();
        int opcao = - 99;
        
        Produto produto = new Produto();
        Vendedor vendedor = new Vendedor();
        
        while(opcao != 0){
            System.out.println("***************************************");
            System.out.println("******   Trem's Uai - Vendedor   ******");
            System.out.println("***************************************");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Editar Produto");
            System.out.println("3 - Excluir Produto");
            System.out.println("4 - Listar todos os seus produtos");
            System.out.println("5 - Editar Perfil");
            System.out.println("6 - Excluir Perfil");
            System.out.println("\n0 - Sair");
            
            System.out.println("Digite a opção desejada: ");
            opcao = scan.nextInt();
            scan.nextLine();
            
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    ecommerceController.salvarProduto(ecommerceController.lerProduto(id, scan), connection);
                    break;
                case 2:
                    System.out.print("Digite o ID do produto que deseja editar: ");
                    int idP = scan.nextInt();
                    scan.nextLine();
                    produto = ecommerceController.lerProduto(id, scan);
                    produto.setId(idP);
                    ecommerceController.editarProduto(produto, connection);
                    break;
                case 3:
                    System.out.print("Digite o ID do produto que deseja excluir: ");
                    ecommerceController.excluirProduto(scan.nextInt(), connection);
                    break;
                case 4:
                    ecommerceController.buscaProdutosPorIdVendedor(id, connection);
                    break;
                case 5:
                    vendedor = ecommerceController.lerVendedor(scan);
                    //lendo endereco
                    vendedor.setEndereco(ecommerceController.lerEndereco(scan));
                    vendedor.setId(id);
                    ecommerceController.editarVendedor(vendedor, id, connection);
                    break;
                case 6:
                    ecommerceController.excluirVendedor(id, connection);
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    //MENU CONSULTAS BD:
    public void consultasEspecificas(Scanner scan, Connection connection) {
        int consultaOpcao;
        EcommerceController ecommerceController = new EcommerceController();

        do {
            System.out.println("********* CONSULTAS ESPECIFICAS *********");
            System.out.println("1 - Listar Clientes com Endereco");
            System.out.println("2 - Listar Avaliacoes com Produto");
            System.out.println("3 - Listar Carrinhos com Itens e Cliente");
            System.out.println("4 - Quantidade de Pedidos por Cliente");
            System.out.println("5 - Media de Preco por Tipo de Pagamento");
            System.out.println("6 - Produtos Mais Vendidos");
            System.out.println("7 - Total de Pedidos no Ultimo Mes");
            System.out.println("8 - Media de Vendas da Ultima Semana");
            System.out.println("9 - Clientes Ativos no Ultimo Mes");
            System.out.println("10 - Cliente com Mais Pedidos");
            System.out.println("11 - Clientes com Pedidos Acima da Media");
            System.out.println("12 - Vendedores com Produtos Bem Avaliados");
            System.out.println("\n0 - Voltar ao menu principal");

            System.out.print("Escolha uma opcao: ");
            consultaOpcao = scan.nextInt();
            scan.nextLine();

            switch (consultaOpcao) {
                case 1:
                System.out.println("\n*** Listar Clientes com Endereço ***");
                System.out.println("--------------------------------------------------");
                List<Cliente> clientes = ecommerceController.listarClientesComEndereco(connection);
                for (Cliente cliente : clientes) {
                    System.out.println("Cliente ID: " + cliente.getId());
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Telefone: " + cliente.getTelefone());
                    System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
                    System.out.println("Nacionalidade: " + cliente.getNacionalidade());
                    System.out.println("Gênero: " + cliente.getGenero());

                    Endereco endereco = cliente.getEndereco();
                    System.out.println("\nEndereço:");
                    System.out.println("Endereço ID: " + endereco.getId());
                    System.out.println("CEP: " + endereco.getCep());
                    System.out.println("Rua: " + endereco.getRua());
                    System.out.println("Complemento: " + endereco.getComplemento());
                    System.out.println("Logradouro: " + endereco.getLogradouro());
                    System.out.println("Bairro: " + endereco.getBairro());
                    System.out.println("Cidade: " + endereco.getCidade());
                    System.out.println("Estado: " + endereco.getEstado());
                    System.out.println("Número: " + endereco.getNumero());
                    System.out.println("--------------------------------------------------");
                }
                break;  
                case 2:
                    System.out.println("\n*** Listar Produtos com suas Avaliações ***");
                    System.out.println("--------------------------------------------------");

                    List<Avaliacao> avaliacoes = ecommerceController.listarAvaliacoesComProduto(connection);
                    for (Avaliacao avaliacao : avaliacoes) {
                        Produto produto = avaliacao.getProduto();
                        if (produto != null) {
                            System.out.println("Produto ID: " + produto.getId());
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Descrição: " + produto.getDescricao());
                            System.out.println("Valor: R$ " + String.format("%.2f", produto.getValor()));
                            System.out.println("Estoque: " + produto.getEstoque());
                            System.out.println("\nAvaliação:");
                        }

                        // Exibe as informações da avaliação
                        System.out.println("Nota: " + avaliacao.getNota());
                        System.out.println("Comentário: " + avaliacao.getComentario());
                        System.out.println("Data: " + avaliacao.getData());

                        // Exibe o ID do cliente que fez a avaliação
                        Cliente cliente = avaliacao.getCliente();  // Obtém o cliente associado à avaliação
                        if (cliente != null) {
                            System.out.println("Cliente ID: " + cliente.getId());
                        }

                        System.out.println("--------------------------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("\n*** Listar Carrinhos com seus Itens e Cliente ***");
                    System.out.println("--------------------------------------------------");

                    List<Carrinho> carrinhos = ecommerceController.listarCarrinhosComItensECliente(connection);
                    for (Carrinho carrinho : carrinhos) {
                        Cliente cliente = carrinho.getCliente();
                        if (cliente != null) {
                            System.out.println("Cliente ID: " + cliente.getId());
                            System.out.println("Nome: " + cliente.getNome());
                            System.out.println("Email: " + cliente.getEmail());
                            System.out.println("Telefone: " + cliente.getTelefone());
                        }

                        System.out.println("\nCarrinho:");
                        System.out.println("Carrinho ID: " + carrinho.getId());
                        System.out.println("Preço Total: R$ " + String.format("%.2f", carrinho.getPrecoTotal()));
                        System.out.println("Data do Pedido: " + carrinho.getDataPedido());
                        System.out.println("Tipo de Pagamento: " + carrinho.getTipoPagamento());
                        String statusCarrinho = carrinho.isFechado() ? "Fechado" : "Aberto";
                        System.out.println("Status do Carrinho: " + statusCarrinho);
                        System.out.println("--------------------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("\n*** Quantidade de Pedidos por Cliente ***");
                    System.out.println("----------------------------------------");

                    List<String> resultados = ecommerceController.obterQuantidadePedidosPorCliente(connection);
                    if (resultados.isEmpty()) {
                        System.out.println("Nenhum pedido encontrado.");
                    } else {
                        for (String resultado : resultados) {
                            System.out.println(resultado);
                        }
                    }

                    System.out.println("----------------------------------------");
                    break;
                case 5:
                    System.out.println("\n*** Média de Preço por Tipo de Pagamento ***");
                    System.out.println("------------------------------------------");

                    // Usando um nome diferente para a variável
                    List<String> mediaPrecoResultados = ecommerceController.obterMediaPrecoPorTipoPagamento(connection);
                    if (mediaPrecoResultados.isEmpty()) {
                        System.out.println("Nenhuma média de preço encontrada.");
                    } else {
                        for (String resultado : mediaPrecoResultados) {
                            System.out.println(resultado);
                        }
                    }

                    System.out.println("------------------------------------------");
                    break;
                case 6:
                    System.out.println("\n*** Produtos Mais Vendidos ***");
                    System.out.println("-----------------------------");

                    // Usando um nome diferente para a variável
                    List<String> produtosMaisVendidosResultados = ecommerceController.obterProdutosMaisVendidos(connection);
                    if (produtosMaisVendidosResultados.isEmpty()) {
                        System.out.println("Nenhum produto encontrado.");
                    } else {
                        for (String resultado : produtosMaisVendidosResultados) {
                            System.out.println(resultado);
                        }
                    }

                    System.out.println("-----------------------------");
                    break;
                case 7:
                    System.out.println("\n*** Total de Pedidos no Último Mês ***");
                    System.out.println("--------------------------------------");

                    // Obtém o total de pedidos feitos no último mês
                    int totalPedidosUltimoMes = ecommerceController.obterTotalPedidosUltimoMes(connection);

                    System.out.println("Total de Pedidos Realizados no Último Mês: " + totalPedidosUltimoMes);

                    System.out.println("--------------------------------------");
                    break;
               case 8:
                    System.out.println("\n*** Média de Vendas por Dia na Última Semana ***");
                    System.out.println("---------------------------------------------");

                    // Obtém a média de vendas diárias dos últimos 7 dias
                    double mediaVendasUltimaSemana = ecommerceController.obterMediaVendasUltimaSemana(connection);

                    System.out.println("Média de Vendas por Dia na ultima semana: " + String.format("%.2f", mediaVendasUltimaSemana));

                    System.out.println("---------------------------------------------");
                    break;
                case 9:
                    System.out.println("\n*** Clientes Ativos no Último Mês ***");
                    System.out.println("------------------------------------");

                    // Obtém a lista de clientes que fizeram pelo menos um pedido no último mês
                    List<String> clientesAtivosUltimoMes = ecommerceController.obterClientesAtivosUltimoMes(connection);

                    if (clientesAtivosUltimoMes.isEmpty()) {
                        System.out.println("Nenhum cliente ativo no último mês.");
                    } else {
                        System.out.println("Clientes que realizaram pedidos no último mês:");
                        for (String cliente : clientesAtivosUltimoMes) {
                            System.out.println(cliente);
                        }
                    }

                    System.out.println("------------------------------------");
                    break;
               case 10:
                    System.out.println("\n*** Cliente com Mais Pedidos ***");
                    System.out.println("-------------------------------");

                    // Obtém o nome do cliente que realizou o maior número de pedidos
                    String clienteComMaisPedidos = ecommerceController.obterClienteComMaisPedidos(connection);

                    if (clienteComMaisPedidos != null) {
                        System.out.println("Cliente com o maior número de pedidos: " + clienteComMaisPedidos);
                    } else {
                        System.out.println("Nenhum cliente com pedidos registrados.");
                    }

                    System.out.println("-------------------------------");
                    break;
                case 11:
                    System.out.println("\n*** Clientes com Pedidos Acima da Média ***");
                    System.out.println("----------------------------------------");

                    // Obtém a lista de clientes com pedidos acima da média
                    List<String> clientesAcimaDaMedia = ecommerceController.obterClientesComPedidosAcimaDaMedia(connection);

                    if (!clientesAcimaDaMedia.isEmpty()) {
                        System.out.println("Clientes com pedidos acima da média:");
                        for (String cliente : clientesAcimaDaMedia) {
                            System.out.println("- " + cliente);
                        }
                    } else {
                        System.out.println("Nenhum cliente fez pedidos acima da média.");
                    }

                    System.out.println("----------------------------------------");
                    break;
                case 12:
                    System.out.println("\n*** Vendedores com Produtos Bem Avaliados ***");
                    System.out.println("------------------------------------------");
                    // Chama a função que obtém os vendedores com produtos bem avaliados
                    List<String> vendedores = ecommerceController.obterVendedoresComProdutosBemAvaliados(connection);

                    // Exibe os resultados para o usuário
                    if (vendedores.isEmpty()) {
                        System.out.println("Nenhum vendedor com produtos bem avaliados encontrados.");
                    } else {
                        for (String vendedor : vendedores) {
                            System.out.println(vendedor);
                        }
                    }

                    System.out.println("------------------------------------------");
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (consultaOpcao != 0);
    }
}
