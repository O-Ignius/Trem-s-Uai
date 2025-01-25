/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ecommerce.view;

import ecommerce.controller.BibliotecaController;
import biblioteca.model.entity.Editora;
import biblioteca.model.entity.Livro;
import java.util.Scanner;

/**
 *
 * @author alunos
 */
public class Biblioteca_POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BibliotecaController bibliotecaController = new BibliotecaController();
        int opcao = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (opcao != 3) {
                System.out.println("*************************************************");
                System.out.println(" ****** Sistema de Gerenciaento Biblioteca ******");
                System.out.println("*************************************************");
                System.out.println("Digite a opção desejada: ");
                System.out.println("1 - Cadastro de Livro");
                System.out.println("2 - Cadastro de Editora");
                System.out.println("3 - Edição de Editora");
                System.out.println("4 - Edição de Livro");
                System.out.println("5 - Excluir Editoras");
                System.out.println("6 - Excluir Livros");
                System.out.println("7 - Selecionar Editora");
                System.out.println("8 - Selecionar Livro");
                System.out.println("9 - Mostrar Editoras");
                System.out.println("10 - Mostrar Livros");
                System.out.println("0 - Sair");
                opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao == 1) {
                    Livro livro = new Livro();
                    Editora editora = new Editora();
                    System.out.print("Digite o nome: ");
                    livro.setNome(scanner.nextLine());
                    System.out.print("Digite o id da editora do livro: ");
                    editora.setId(scanner.nextLong());
                    scanner.nextLine();
                    livro.setEditora(editora);
                    bibliotecaController.cadastrarLivro(livro);
                } else if (opcao == 2) {
                    Editora editora = new Editora();
                    System.out.print("Digite o nome: ");
                    editora.setNome(scanner.nextLine());
                    System.out.print("Digite o email: ");
                    editora.setEmail(scanner.nextLine());
                    bibliotecaController.cadastrarEditora(editora);
                } else if (opcao == 3) {
                    Editora editora = new Editora();
                    System.out.print("Digite o ID: ");
                    editora.setId(scanner.nextLong());
                    System.out.print("Digite o nome: ");
                    editora.setNome(scanner.nextLine());
                    System.out.print("Digite o email: ");
                    editora.setEmail(scanner.nextLine());
                    bibliotecaController.editarEditora(editora);
                } else if (opcao == 4) {
                    Livro livro = new Livro();
                    Editora editora = new Editora();
                    System.out.print("Digite o ID: ");
                    livro.setId(scanner.nextLong());
                    System.out.print("Digite o nome: ");
                    livro.setNome(scanner.nextLine());
                    System.out.print("Digite o id da editora do livro: ");
                    editora.setId(scanner.nextLong());
                    scanner.nextLine();
                    livro.setEditora(editora);
                    bibliotecaController.editarLivro(livro);
                } else if (opcao == 5) {
                    Long id;
                    System.out.print("Digite o ID: ");
                    id = scanner.nextLong();
                    bibliotecaController.excluirEditora(id);
                } else if (opcao == 6) {
                    Long id;
                    System.out.print("Digite o ID: ");
                    id = scanner.nextLong();
                    bibliotecaController.excluirLivro(id);
                } else if (opcao == 7) {
                    Long id;
                    System.out.print("Digite o ID: ");
                    id = scanner.nextLong();
                    bibliotecaController.getEditora(id);
                } else if (opcao == 8) {
                    Long id;
                    System.out.print("Digite o ID: ");
                    id = scanner.nextLong();
                    bibliotecaController.getLivro(id);
                } else if (opcao == 9) {
                    bibliotecaController.allEditora();
                } else if (opcao == 10) {
                    bibliotecaController.allLivro();
                }
                else if (opcao == 0) {
                       break;
                }
            }
        }
    }
    
}
