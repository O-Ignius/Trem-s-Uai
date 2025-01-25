package biblioteca.model.entity;

import java.time.LocalDate;

public class Livro {
    private Long id;
    private String nome;
    private String descricao;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private double preco;
    private Editora editora;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public int calculaIdade(int ano){
        int idade = ano - anoPublicacao;
        return idade;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
            
    public int calculaIdade(){
        LocalDate dataHoje = LocalDate.now();         
        int idade = dataHoje.getYear() - anoPublicacao;
        return idade;
    }
    
    public void imprimir(){
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Autor: " + autor);
        System.out.println("Isbn: " + isbn);
        System.out.println("Ano Publicação: " + anoPublicacao);
        System.out.println("Preço: " + preco);
        System.out.println("Editora - Nome: " + editora.getNome());
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
        
}
