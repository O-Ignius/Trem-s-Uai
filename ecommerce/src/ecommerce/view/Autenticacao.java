package ecommerce.view;

//Controller
import ecommerce.controller.EcommerceController;

//Entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Vendedor;
import ecommerce.model.entity.Endereco;

import java.util.Scanner;
import java.text.SimpleDateFormat;
                                                                    
public class Autenticacao{
    
    EcommerceController ecommerceController = new EcommerceController();
    Menus menu = new Menus();
    Formulario formulario = new Formulario();
    
    public Endereco cadastroEndereco() {
        Endereco endereco = null;
        
        System.out.println("**************************");
        System.out.println("** Cadastro de Endereço **");
        System.out.println("**************************");
        
        try (Scanner input = new Scanner(System.in)) {
            endereco = new Endereco();
            
            System.out.print("Cep: \t");
            endereco.setCep(input.nextInt());
            input.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

            System.out.print("\nRua: \t");
            endereco.setRua(input.nextLine());

            System.out.print("\nComplemento: \t");
            endereco.setComplemento(input.nextLine());

            System.out.print("\nLogradouro: \t");
            endereco.setLogradouro(input.nextLine());

            System.out.print("\nBairro: \t");
            endereco.setBairro(input.nextLine());

            System.out.print("\nCidade: \t");
            endereco.setCidade(input.nextLine());

            System.out.print("\nEstado: \t");
            endereco.setEstado(input.nextLine());

            System.out.print("\nNúmero: \t");
            endereco.setNumero(input.nextInt());
        }
        
        return endereco;
    }
    
    public static java.sql.Date parseToSqlDate(String dateStr) {
        try {
            // Usando SimpleDateFormat para converter a String em java.util.Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = sdf.parse(dateStr);

            // Convertendo para java.sql.Date
            return new java.sql.Date(utilDate.getTime());
        } catch (Exception e) {
            System.out.println("Erro ao converter a data: " + e.getMessage());
            return null; // Retorna null em caso de erro
        }
    }
    
    public void cadastroCliente() {
        Cliente cliente = formulario.lerCliente();
        
        //set endereco
        cliente.setEndereco(formulario.lerEndereco());
    }
    
    public void cadastroVendedor() {
        Vendedor vendedor = formulario.lerVendedor();

        //set endereco
        vendedor.setEndereco(formulario.lerEndereco());
    }
    
    public int login(String email, String senha) {
        EcommerceController ecommerceController = new EcommerceController();
        int id;
        String tableNome = new String();
        
        //procura na tabela cliente;
        tableNome = "cliente";
        //se nao encontrar
        id = ecommerceController.login(email, senha, tableNome);
        if (id < 0) {
            //procura na tabela vendedor
            tableNome = "vendedor";
            id = ecommerceController.login(email, senha, tableNome);
                
            if (id < 0) {
                System.err.println("Dados incorretos!");
                return -1;
            }
            else {
                //se achar na tabela vendedor, chama menu vendedor
                ecommerceController.vendedorMenu(id);
            }
        }
        else {
            //se achar na tabela cliente, chama menu cliente
            ecommerceController.clienteMenu(id);
        }
        
        return 0;
    }
}