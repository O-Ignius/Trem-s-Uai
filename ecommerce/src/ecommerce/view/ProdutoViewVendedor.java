/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.view;
import ecommerce.controller.EcommerceController;
import java.util.Scanner;

import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

/**
 *
 * @author Andre
 */
public class ProdutoViewVendedor {
    public void menu(int id){
        EcommerceController ecommerceController = new EcommerceController();
        int opcao = - 99;
        Scanner scan = new Scanner(System.in);
        Produto produto = new Produto();
        
        while(opcao != 0){
            System.out.println("****************************************");
            System.out.println("****** Gerenciamento de Produtos *******");
            System.out.println("****************************************");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Editar Produto");
            System.out.println("3 - Excluir Produto");
            System.out.println("4 - Listar todos os seus produtos");
            System.out.println("\n0 - Sair");
            
            System.out.println("Digite a opção desejada: ");
            opcao = scan.nextInt();
            scan.nextLine();
            
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    ecommerceController.salvarProduto(lerDados(id));
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
            }
            
        }
    }
    
    public Produto lerDados(int id){
        Scanner scan = new Scanner(System.in);
        Produto produto = new Produto();
        Vendedor vendedor = new Vendedor();
        
        System.out.print("Digite o nome do produto: ");
        produto.setNome(scan.nextLine());
        System.out.print("Digite a descrição do produto: ");
        produto.setDescricao(scan.nextLine());
        System.out.print("Digite o valor do produto: ");
        produto.setValor(scan.nextDouble());
        System.out.print("Digite a quantidade em estoque: ");
        produto.setEstoque(scan.nextInt());
        
        vendedor.setId(id);
        produto.setVendedor(vendedor);
        return produto;
    }
}
