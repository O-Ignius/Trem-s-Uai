package ecommerce.view;

import java.sql.Date;
import java.text.SimpleDateFormat;

//Controller
import ecommerce.controller.EcommerceController;

//Scanner
import java.util.Scanner;

//Entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Vendedor;

public class autenticacao {
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
        Cliente cliente = new Cliente();
        
        System.out.println("**************************");
        System.out.println("** Cadastro de Cliente **");
        System.out.println("**************************");
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite o nome: \t");
        cliente.setNome(input.nextLine());

        System.out.print("\nDigite o CPF: \t");
        cliente.setCpf(input.nextLine());

        System.out.print("\nDigite o e-mail: \t");
        cliente.setEmail(input.nextLine());

        System.out.print("\nDigite a senha: \t");
        cliente.setSenha(input.nextLine());

        System.out.print("\nDigite o telefone: \t");
        cliente.setTelefone(input.nextLine());

        // Coleta de data de nascimento (Como Date, é necessário um formato específico)
        System.out.print("\nDigite a data de nascimento (dd/MM/yyyy): \t");
        String dataNascimentoStr = input.nextLine();
        cliente.setDataNascimento(parseToSqlDate(dataNascimentoStr));

        System.out.print("\nDigite a nacionalidade: \t");
        cliente.setNacionalidade(input.nextLine());

        System.out.print("\nDigite o gênero: \t");
        cliente.setGenero(input.nextLine());
        }
        
        //set endereco
        cliente.setEndereco(cadastroEndereco());
    }
    
    public void cadastroVendedor() {
        Cliente cliente = new Cliente();
        
        System.out.println("**************************");
        System.out.println("** Cadastro de Vendedor **");
        System.out.println("**************************");
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Digite o nome: \t");
            cliente.setNome(input.nextLine());

            System.out.print("\nDigite o CPF: \t");
            cliente.setCpf(input.nextLine());

            System.out.print("\nDigite o CNPJ: \t");
            cliente.setCpf(input.nextLine());

            System.out.print("\nDigite o e-mail: \t");
            cliente.setEmail(input.nextLine());

            System.out.print("\nDigite a senha: \t");
            cliente.setSenha(input.nextLine());

            System.out.print("\nDigite o telefone: \t");
            cliente.setTelefone(input.nextLine());

            // Coleta de data de nascimento (Como Date, é necessário um formato específico)
            System.out.print("\nDigite a data de nascimento (dd/MM/yyyy): \t");
            String dataNascimentoStr = input.nextLine();
            cliente.setDataNascimento(parseToSqlDate(dataNascimentoStr));

            System.out.print("\nDigite a nacionalidade: \t");
            cliente.setNacionalidade(input.nextLine());

            System.out.print("\nDigite o gênero: \t");
            cliente.setGenero(input.nextLine());
        }
        
        //set endereco
        cliente.setEndereco(cadastroEndereco());
    }
    
    public void login() {
        EcommerceController ecommerceController = new EcommerceController();
        int id;
        String email = new String();
        String senha = new String();
        String tableNome = new String();
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("\nDigite o email: \t");
            email = input.nextLine();
            System.out.print("\nDigite a senha: \t");
            senha = input.nextLine();
            
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
                }
                else {
                    //encontrado na tabela vendedor
                }
            }
            else {
                //encontrado na tabela cliente
            }
        }
    }
}
