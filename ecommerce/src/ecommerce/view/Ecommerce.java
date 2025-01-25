/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ecommerce.view;

//cotroller
import ecommerce.controller.EcommerceController;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Pedido;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

import java.util.Scanner;

/**
 *
 * @author alunos
 */
public class Ecommerce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EcommerceController bibliotecaController = new EcommerceController();
        int opcao = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (opcao != 3) {
                System.out.println("*************************************************");
                System.out.println(" ****** Sistema de Gerenciaento Biblioteca ******");
                System.out.println("*************************************************");
                System.out.println("Digite a opção desejada: ");
                System.out.println("1 - Cadastro de Livro");
                System.out.println("3 - Edição de Editora");
                System.out.println("5 - Excluir Editoras");
                System.out.println("7 - Selecionar Editora");
                System.out.println("9 - Mostrar Editoras");
                System.out.println("0 - Sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao == 1) {
                    /*
                    Livro livro = new Livro();
                    Editora editora = new Editora();
                    System.out.print("Digite o nome: ");
                    livro.setNome(scanner.nextLine());
                    System.out.print("Digite o id da editora do livro: ");
                    editora.setId(scanner.nextLong());
                    scanner.nextLine();
                    livro.setEditora(editora);
                    bibliotecaController.cadastrarLivro(livro);
                    */
                } else if (opcao == 3) {
                    /*
                    Editora editora = new Editora();
                    System.out.print("Digite o ID: ");
                    editora.setId(scanner.nextLong());
                    System.out.print("Digite o nome: ");
                    editora.setNome(scanner.nextLine());
                    System.out.print("Digite o email: ");
                    editora.setEmail(scanner.nextLine());
                    bibliotecaController.editarEditora(editora);
                    */
                } else if (opcao == 5) {
                    /*
                    Long id;
                    System.out.print("Digite o ID: ");
                    id = scanner.nextLong();
                    bibliotecaController.excluirEditora(id);
                    */
                } else if (opcao == 7) {
                    /*
                    Long id;
                    System.out.print("Digite o ID: ");
                    id = scanner.nextLong();
                    bibliotecaController.getEditora(id);
                    */
                } else if (opcao == 9) {
                    //bibliotecaController.allEditora();
                } else if (opcao == 0) {
                       break;
                }
            }
        }
    }
    
}
