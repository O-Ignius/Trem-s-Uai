
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

//Service
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
    
    public Cliente getCliente(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getCliente(id);
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
    
    public Endereco getEndereco(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getEndereco(id);
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
    
    public Vendedor getVendedor(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getVendedor(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //produto
    
    public void salvarProduto(Produto produto){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarProduto(produto);
    }
    
    public void editarProduto(Produto produto){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarProduto(produto);
    }
    
    public void excluirProduto(int id){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirProduto(id);
    }
    
    public void buscarPornome(String nome){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.buscarPornome(nome);
    }
    
    public Produto getProduto (int id) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getProduto(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //avaliacao
    public void salvarAvaliacao(Avaliacao avaliacao){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarAvaliacao(avaliacao);
    }
    
    public void editarAvaliacao(Produto produto){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarProduto(produto);
    }
    
    public void excluirAvaliacao(int idCliente, int idProduto){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirAvaliacao(idCliente, idProduto);
    }
    
    public Avaliacao getProduto (int idCliente, int idProduto) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getAvaliacao(idCliente, idProduto);
    }
    /////////////////////////////////////////////////////////////////
    //carrinho
    public void salvarCarrinho(Cliente cliente){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarCarrinho(cliente);
    }
    
    /////////////////////////////////////////////////////////////////
    //item
    public void salvarItem(Item item, Carrinho carrinho){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarItem(item, carrinho);
    }
    
    public void editarItem(Item Item){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarItem(Item);
    }
    
    public void excluirItem(int id){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirItem(id);
    }
    
    public void buscarPorIdCarrinho(Carrinho carrinho){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.buscarPorIdCarrinho(carrinho);
    }
    
    /////////////////////////////////////////////////////////////////
    //pedido
    public void salvarPedido(Pedido pedido){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarPedido(pedido);
    }
    
    public void editarPedido(Pedido Pedido){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarPedido(Pedido);
    }
    
    public void excluirPedido(int id){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirPedido(id);
    }
    
    public Pedido getPedido (int id){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getPedido(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //autenticaçao
    public int login(String email, String senha, String tableNome){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.login(email, senha, tableNome);
    }
}
