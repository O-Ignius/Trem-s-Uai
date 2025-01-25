
package ecommerce.controller;

import biblioteca.model.entity.Editora;
import biblioteca.model.entity.Livro;
import biblioteca.model.service.BibliotecaService;

public class BibliotecaController implements IController{
    
    public void cadastrarEditora(Editora editora) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.salvarEditora(editora);
    }

    public void editarEditora(Editora editora) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.editarEditora(editora);
    }

    public void excluirEditora(long id) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.excluirEditora(id);
    }

    public void getEditora(long id) {
        Editora editora = null;

        BibliotecaService bibliotecaService = new BibliotecaService();
        editora = bibliotecaService.getEditora(id);
        editora.imprimir();
    }

    public void allEditora() {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allEditora();
    }
    
    //livros
    public void cadastrarLivro(Livro livro) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.salvarLivro(livro);        
    }

    public void editarLivro(Livro livro) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.editarLivro(livro);        
    } 

    public void excluirLivro(long id) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.excluirLivro(id);        
    } 

    public void getLivro(Long id) {
        Livro livro = null;

        BibliotecaService bibliotecaService = new BibliotecaService();
        livro = bibliotecaService.getLivro(id);
        livro.imprimir();
    }
    public void allLivro() {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allLivro();
    }  
}
