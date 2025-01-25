package ecommerce.controller;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Pedido;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

public interface IController {
    /*
    //editora
    public void cadastrarEditora(Editora editora);
    public void editarEditora(Editora editora);
    public void excluirEditora(long id);
    public void getEditora(long id);
    public void allEditora();
    */
    //preview funções
    //Cliente
    public void cadastrarCliente(Cliente cliente);
    public void editarCliente(Cliente cliente);
    public void excluirCliente(int id);
    public void getCliente(int id);
    
    //////////////////////////////////////////////////////////////////////
    //Endereco
    public void cadastrarEndereco(Endereco endereco);
    public void editarEndereco(Endereco endereco);
    public void excluirEndereco(int id);
    public void getEndereco(int id);
    
    /////////////////////////////////////////////////////////////////////////
    //Vendedor
}
