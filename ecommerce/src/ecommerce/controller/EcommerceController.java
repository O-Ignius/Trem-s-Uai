
package ecommerce.controller;

//imports entity
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

//Service
import ecommerce.model.service.EcommerceService;
import java.util.Scanner;

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
    
    public void editarCliente(Cliente cliente, int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarCliente(cliente, id);
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
    public int cadastrarEndereco(Endereco endereco) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.salvarEndereco(endereco);
    }
    
    public void editarEndereco(Endereco endereco, int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarEndereco(endereco, id);
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
    
    public void editarVendedor(Vendedor vendedor, int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarVendedor(vendedor, id);
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
    
    public int buscarPornome(String nome){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.buscarPornome(nome);
    }
    
    public Produto getProduto (int id) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getProduto(id);
    }
    
    public void buscaProdutosPorIdVendedor(int id){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.buscaProdutosPorIdVendedor(id);
    }
    
    public void editarQuantidadeEstoque(Produto produto) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarQuantidadeEstoque(produto);
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
    
    public Carrinho buscaCarrinhoAtual(int id_Cliente){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.buscaCarrinhoAtual(id_Cliente);
    }
    
    public void alterarPrecoTotalCarrinho(Carrinho carrinho) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.alterarPrecoTotalCarrinho(carrinho);
    }
    
    public void finalizarCarrinho(Carrinho carrinho) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.finalizarCarrinho(carrinho);
    }
    
    public void buscaPedidosFinalizados(int idCliente){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.buscaPedidosFinalizados(idCliente);
    }
    /////////////////////////////////////////////////////////////////
    //item
    public void salvarItem(Item item){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarItem(item);
    }
    
    public void editarItem(Item Item){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarItem(Item);
    }
    
    public void excluirItem(int id){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirItem(id);
    }
    
    public Item getItem(int id){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getItem(id);
    }
    
    public int buscaItemPorIdCarrinho(Carrinho carrinho){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.buscaItemPorIdCarrinho(carrinho);
    }
    
    public double somaValorItensCarrinho(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.somaValorItensCarrinho(id);
    }
    
    public void editaEstoqueItemPorIdCarrinho(int id) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editaEstoqueItemPorIdCarrinho(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //autenticaçao
    public int login(String email, String senha, String tableNome){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.login(email, senha, tableNome);
    }

    /////////////////////////////////////////////////////////////////
    //Views
    public void cadastroLoginMenu(){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.cadastroLoginMenu();
    }
    
    public void cadastroMenu(Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.cadastroMenu(input);
    }
    
    public void loginMenu(Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.loginMenu(input);
    }
    
    public void clienteMenu(int id, Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.clienteMenu(id, input);
    }
    
    public void vendedorMenu(int id, Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.vendedorMenu(id, input);
    }
    
    ////////////////////////////////
    //Login
    public void cadastroClienteAutenticacao(Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.cadastroClienteAutenticacao(input);
    }
    
    public void cadastroVendedorAutenticacao(Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.cadastroVendedorAutenticacao(input);
    }
    
    public int loginAutenticacao(String email, String senha, Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.loginAutenticacao(email, senha, input);
    }
    
    /////////////////////////////////////////////////////////////////
    //Formulario
    public Endereco lerEndereco(Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerEndereco(input);
    }
    public Cliente lerCliente(Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerCliente(input);
    }
    public Vendedor lerVendedor(Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerVendedor(input);
    }
    public Produto lerProduto(int id, Scanner input){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerProduto(id, input);
    }
    public Item lerItem(Scanner input, int idCliente){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerItem(input, idCliente);
    }
    
    public Carrinho lerCarrinho(Scanner input, Carrinho carrinho){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerCarrinho(input, carrinho);
    }
}
