
package ecommerce.controller;

//imports entity
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Pedido;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

import ecommerce.model.service.EcommerceService;

public class EcommerceController implements IController{
    /*
    //funções
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
    */ 
    
    //cliente
    public void cadastrarCliente(Cliente cliente) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarCliente(cliente);
    }
    
    public void editarCliente(Cliente cliente) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarCliente(cliente);
    }
    
    public void excluirCliente(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirCliente(id);
    }
    
    public void getCliente(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.getCliente(id);
    }
    
    ///////////////////////////////////////////////////////////////////////
    //endereco
    public void cadastrarEndereco(Endereco endereco) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarEndereco(endereco);
    }
    
    public void editarEndereco(Endereco endereco) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarEndereco(endereco);
    }
    
    public void excluirEndereco(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirEndereco(id);
    }
    
    public void getEndereco(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.getEndereco(id);
    }
    
    ////////////////////////////////////////////////////////////////////////
    //Vendedor
    public void cadastrarVendedor(Vendedor vendedor) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarVendedor(vendedor);
    }
    
    public void editarVendedor(Vendedor vendedor) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarVendedor(vendedor);
    }
    
    public void excluirVendedor(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirVendedor(id);
    }
    
    public void getVendedor(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.getVendedor(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //produto
    
    public void salvarProduto(Produto produto){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarProduto(produto);
    }
    
    public void editarproduto(Produto produto){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarProduto(produto);
    }
    
    public void excluirproduto(int id){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirProduto(id);
    }
    
    public void buscarPornome(String nome){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.buscarPornome(nome);
    }
}
