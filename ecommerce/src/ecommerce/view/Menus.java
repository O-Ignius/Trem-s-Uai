package ecommerce.view;

//controller
import ecommerce.controller.EcommerceController;

//views
import ecommerce.view.Autenticacao;
import ecommerce.view.Formulario;

//entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

//scanner
import java.util.Scanner;

public class Menus{
    EcommerceController ecommerceController = new EcommerceController();
    
    public void cadastroLogin() {
        int op = -1;
        
        while (op != 0) {
            System.out.println("****************************");
            System.out.println("******   Trem's Uai   ******");
            System.out.println("****************************");

            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("0 - Sair");

            try (Scanner input = new Scanner(System.in)) {
                op = input.nextInt();
                
                switch (op) {
                    case 1:
                        login();
                        return; //retorna para menu principal
                    case 2:
                        cadastro();
                        break;
                    case 0:
                        break;
                    default:
                        System.err.println("Opção inválida!");
                }
            }
        }
    }
    
    public void cadastro() {
        int op = -1;
        
        while (op != 0) {
            System.out.println("***************************************");
            System.out.println("******   Trem's Uai - Cadastro   ******");
            System.out.println("***************************************");

            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastrar como Cliente");
            System.out.println("2 - Cadastrar como Vendedor");
            System.out.println("0 - Sair");

            try (Scanner input = new Scanner(System.in)) {
                op = input.nextInt();
                
                switch (op) {
                    case 1:
                        ecommerceController.cadastroClienteAutenticacao();
                        return; //retorna para menu principal
                    case 2:
                        ecommerceController.cadastroVendedorAutenticacao();
                        return; //retorna para menu principal
                    case 0:
                        break;
                    default:
                        System.err.println("Opção inválida!");
                }
            }
        }
    }
    
    public void login() {
        String email = new String();
        String senha = new String();
        int tentarNovamente;
        
        do {
            tentarNovamente = 0;
            
            System.out.println("************************************");
            System.out.println("******   Trem's Uai - Login   ******");
            System.out.println("************************************");


            try (Scanner input = new Scanner(System.in)) {


                    System.out.print("Digite seu email: \t");
                    email = input.nextLine();
                    System.out.print("\nDigite sua senha: \t");
                    senha = input.nextLine();
                    System.out.println("");

                    if (ecommerceController.loginAutenticacao(email, senha) == -1) {
                        System.out.println("Deseja tentar novamente? (1: Sim    0: Não)");
                        tentarNovamente = input.nextInt();
                    }
                } 
        } while (tentarNovamente != 0);
    }
    
    public void cliente(int id) {
        EcommerceController ecommerceController = new EcommerceController();
        int opcao = - 99;
        Scanner scan = new Scanner(System.in);
        Cliente cliente = new Cliente();
        
        while(opcao != 0){
            System.out.println("**************************************");
            System.out.println("******   Trem's Uai - Cliente   ******");
            System.out.println("**************************************");
            System.out.println("1 - Buscar Produtos");
            System.out.println("2 - Ver Carrinho");
            System.out.println("3 - Ver Pedidos");
            System.out.println("4 - Editar Perfil");
            System.out.println("5 - Excluir Perfil");
            System.out.println("\n0 - Sair");
            
            System.out.println("Digite a opção desejada: ");
            opcao = scan.nextInt();
            scan.nextLine();
            
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    System.out.print("Digite o nome do produto que deseja buscar: ");
                    ecommerceController.buscarPornome(scan.nextLine());
                    break;
                case 2:
                    cliente.setCarrinho(ecommerceController.buscaCarrinhoAtual(id));
                    ecommerceController.buscaItemPorIdCarrinho(cliente.getCarrinho());
                    break;
                case 3:
                    ecommerceController.buscaPedidosPorIdCliente(id);
                    break;
                case 4:
                    ecommerceController.editarCliente(cliente);
                    break;
                case 5:
                    ecommerceController.excluirCliente(id);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public void vendedor(int id) {
        EcommerceController ecommerceController = new EcommerceController();
        int opcao = - 99;
        Scanner scan = new Scanner(System.in);
        
        Produto produto = new Produto();
        Vendedor vendedor;
        
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
                    break;
                case 1:
                    ecommerceController.salvarProduto(ecommerceController.lerProduto(id));
                    break;
                case 2:
                    System.out.print("Digite o ID do produto que deseja editar: ");
                    produto.setId(scan.nextInt());
                    ecommerceController.editarProduto(produto);
                    break;
                case 3:
                    System.out.print("Digite o ID do produto que deseja excluir: ");
                    ecommerceController.excluirProduto(scan.nextInt());
                    break;
                case 4:
                    ecommerceController.buscaProdutosPorIdVendedor(id);
                    break;
                case 5:
                    vendedor = ecommerceController.lerVendedor();
                    vendedor.setId(id);
                    ecommerceController.editarVendedor(vendedor);
                    break;
                case 6:
                    ecommerceController.excluirVendedor(id);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
