package biblioteca.model.service;

import biblioteca.model.dao.EditoraDAO;
import biblioteca.model.dao.LivroDAO;
import biblioteca.model.entity.Editora;
import biblioteca.model.entity.Livro;

public class BibliotecaService {
    private EditoraDAO editoraDAO;
    private LivroDAO livroDAO;
    
    public BibliotecaService(){
        this.editoraDAO = new EditoraDAO();
        this.livroDAO = new LivroDAO();
    } 
    
    // Editora
    public void salvarEditora(Editora editora){
        editoraDAO.salvar(editora);
    }
    
    public Editora getEditora(long id) {
        return editoraDAO.get(id);
    }
    
    public void editarEditora(Editora editora){
        editoraDAO.editar(editora);
    }

    public void allEditora(){
        editoraDAO.all();
    }

    public void excluirEditora(long id){
        editoraDAO.excluir(id);
    }
    
    //Livro
    public void salvarLivro(Livro livro){
        livroDAO.salvar(livro);
    }

    public Livro getLivro(long id) {
        return livroDAO.get(id);
    }
    
    public void editarLivro(Livro livro){
        livroDAO.editar(livro);
    }

    public void allLivro(){
        livroDAO.all();
    }

    public void excluirLivro(long id){
        livroDAO.excluir(id);
    }
}
