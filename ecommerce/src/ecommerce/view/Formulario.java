/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.view;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import java.util.Scanner;

import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Carrinho;
import java.text.SimpleDateFormat;

//controller
import ecommerce.controller.EcommerceController;
/**
 *
 * @author Andre
 */
public class Formulario {
    
    private EcommerceController ecommerceController = new EcommerceController(); 
    
    public Produto lerProduto(int id, Scanner scan){
        Produto produto = new Produto();
        Vendedor vendedor = new Vendedor();
        
        System.out.print("Digite o nome do produto: ");
        produto.setNome(scan.nextLine());
        System.out.print("Digite a descrição do produto: ");
        produto.setDescricao(scan.nextLine());
        System.out.print("Digite o valor do produto: ");
        produto.setValor(scan.nextDouble());
        scan.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()
        System.out.print("Digite a quantidade em estoque: ");
        produto.setEstoque(scan.nextInt());
        scan.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()
        
        vendedor.setId(id);
        produto.setVendedor(vendedor);
        return produto;
    }
    
    public Endereco lerEndereco(Scanner input) {
        Endereco endereco = null;
        
        System.out.println("**************************");
        System.out.println("** Cadastro de Endereço **");
        System.out.println("**************************");
        
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
        input.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()
        
        return endereco;
    }
    
    public Vendedor lerVendedor(Scanner input){
        Vendedor vendedor = new Vendedor();
        
        System.out.println("**************************");
        System.out.println("** Cadastro de Vendedor **");
        System.out.println("**************************");
        
        System.out.print("Digite o nome: \t");
        vendedor.setNome(input.nextLine());

        System.out.print("\nDigite o CPF: \t");
        vendedor.setCpf(input.nextLine());

        System.out.print("\nDigite o CNPJ: \t");
        vendedor.setCnpj(input.nextLine());

        System.out.print("\nDigite o e-mail: \t");
        vendedor.setEmail(input.nextLine());

        System.out.print("\nDigite a senha: \t");
        vendedor.setSenha(input.nextLine());

        System.out.print("\nDigite o telefone: \t");
        vendedor.setTelefone(input.nextLine());

        // Coleta de data de nascimento (Como Date, é necessário um formato específico)
        System.out.print("\nDigite a data de nascimento (dd/MM/yyyy): \t");
        String dataNascimentoStr = input.nextLine();
        vendedor.setDataNascimento(parseToSqlDate(dataNascimentoStr));

        System.out.print("\nDigite a nacionalidade: \t");
        vendedor.setNacionalidade(input.nextLine());

        System.out.print("\nDigite o gênero: \t");
        vendedor.setGenero(input.nextLine());
        
        return vendedor;
    }
    
    public Cliente lerCliente(Scanner input){
        Cliente cliente = new Cliente();
        
        System.out.println("**************************");
        System.out.println("** Cadastro de Cliente **");
        System.out.println("**************************");
        
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
        return cliente;
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
    
    public Item lerItem(Scanner input, int idCliente){
        Item item = new Item();
        Produto produto;
        Cliente cliente = new Cliente();
        Carrinho carrinho;
        
        cliente.setId(idCliente);
        carrinho = ecommerceController.buscaCarrinhoAtual(idCliente);
        item.setCarrinho(carrinho);
        System.out.println("\nDigite o id do produto que deseja adicionar: ");
        produto = ecommerceController.getProduto(input.nextInt());
        item.setProduto(produto);
        
        System.out.println("\nDigite a quantidade que deseja(Estoque: " + produto.getEstoque() + "):");
        item.setQuantidadeItem(input.nextInt());
            
        while(produto.getEstoque() < item.getQuantidadeItem()){
            System.err.println("Estoque excedido!");
            System.out.println("\nDigite a quantidade que deseja(Estoque: " + produto.getEstoque() + "):");
            item.setQuantidadeItem(input.nextInt());
        }
        return item;
    } 
    
    public Carrinho lerCarrinho(Scanner input, Carrinho carrinho){
        System.out.println("Qual o tipo de pagamento? (1 - Dinheiro 2 - Cartão 3 - PIX)");
        carrinho.setTipoPagamento(input.nextInt());
        return carrinho;
    }
}
