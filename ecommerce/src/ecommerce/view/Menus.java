package ecommerce.view;

//controller
import ecommerce.controller.EcommerceController;
import ecommerce.model.dao.Conexao;

//connection
import java.sql.Connection;

//entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;
import ecommerce.model.entity.Carrinho;

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
                    produto.setId(scan.nextInt());
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
}
