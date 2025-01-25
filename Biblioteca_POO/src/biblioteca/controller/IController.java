package biblioteca.controller;

import biblioteca.model.entity.Editora;
import biblioteca.model.entity.Livro;

public interface IController {
    //editora
    public void cadastrarEditora(Editora editora);
    public void editarEditora(Editora editora);
    public void excluirEditora(long id);
    public void getEditora(long id);
    public void allEditora();

    //livro
    public void cadastrarLivro(Livro livro);
    public void editarLivro(Livro livro);
    public void excluirLivro(long id);
    public void getLivro(Long id);
    public void allLivro();
}
