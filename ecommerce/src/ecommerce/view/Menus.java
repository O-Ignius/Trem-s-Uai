package ecommerce.view;

//controller
import ecommerce.controller.EcommerceController;

//views
import ecommerce.view.Autenticacao;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Pedido;
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
        System.out.println("**************************************");
        System.out.println("******   Trem's Uai - Cliente   ******");
        System.out.println("**************************************");
    }
    
    public void vendedor(int id) {
        System.out.println("***************************************");
        System.out.println("******   Trem's Uai - Vendedor   ******");
        System.out.println("***************************************");
    }
}
