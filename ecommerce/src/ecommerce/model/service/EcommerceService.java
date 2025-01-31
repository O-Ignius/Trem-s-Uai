package ecommerce.model.service;

/* MODELO
import biblioteca.model.dao.EditoraDAO;
import biblioteca.model.dao.LivroDAO;
import biblioteca.model.entity.Editora;
import biblioteca.model.entity.Livro;
*/

//Views
import ecommerce.view.Autenticacao;
import ecommerce.view.Menus;

//DAO
import ecommerce.model.dao.AvaliacaoDAO;
import ecommerce.model.dao.ClienteDAO;
import ecommerce.model.dao.EnderecoDAO;
import ecommerce.model.dao.VendedorDAO;
import ecommerce.model.dao.ProdutoDAO;
import ecommerce.model.dao.CarrinhoDAO;
import ecommerce.model.dao.ItemDAO;
import ecommerce.model.dao.AutenticacaoDAO;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;
import ecommerce.view.Formulario;

//scanner
import java.util.Scanner;

public class EcommerceService {
    /*
    private EditoraDAO editoraDAO;
    private LivroDAO livroDAO;
    
    public EcommerceService(){
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
    */
    
    //classes
    private ClienteDAO clienteDAO;
    private EnderecoDAO enderecoDAO;
    private VendedorDAO vendedorDAO;
    private ProdutoDAO produtoDAO;
    private AvaliacaoDAO avaliacaoDAO;
    private CarrinhoDAO carrinhoDAO;
    private ItemDAO itemDAO;
    private AutenticacaoDAO autenticacaoDAO;
    private Formulario formulario;
    
    //views
    private Menus menu;
    private Autenticacao autenticacao;
            
    public EcommerceService(){
        this.clienteDAO = new ClienteDAO();
        this.enderecoDAO = new EnderecoDAO();
        this.vendedorDAO = new VendedorDAO();
        this.produtoDAO = new ProdutoDAO();
        this.carrinhoDAO = new CarrinhoDAO();
        this.itemDAO = new ItemDAO();
        this.autenticacaoDAO = new AutenticacaoDAO();
        this.avaliacaoDAO = new AvaliacaoDAO();
        
        
        //Fazer de todos
        //view
        this.autenticacao = new Autenticacao();
        this.menu = new Menus();
        this.formulario = new Formulario();
    } 
    
    //cliente
    public void salvarCliente(Cliente cliente){
        clienteDAO.salvar(cliente);
    }
    
    public void editarCliente(Cliente cliente, int id){
        clienteDAO.editar(cliente, id);
    }
    
    public void excluirCliente(int id){
        clienteDAO.excluir(id);
    }
    
    public Cliente getCliente(int id){
        return clienteDAO.get(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //endereço
    public int salvarEndereco(Endereco endereco){
        return enderecoDAO.salvar(endereco);
    }
    
    public void editarEndereco(Endereco endereco, int id){
        enderecoDAO.editar(endereco, id);
    }
    
    public void excluirEndereco(int id){
        enderecoDAO.excluir(id);
    }
    
    public Endereco getEndereco(int id){
        return enderecoDAO.get(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //vendedor
    public void salvarVendedor(Vendedor vendedor){
        vendedorDAO.salvar(vendedor);
    }
    
    public void editarVendedor(Vendedor vendedor, int id){
        vendedorDAO.editar(vendedor, id);
    }
    
    public void excluirVendedor(int id){
        vendedorDAO.excluir(id);
    }
    
    public Vendedor getVendedor(int id){
        return vendedorDAO.get(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //produto
    
    public void salvarProduto(Produto produto){
        produtoDAO.salvar(produto);
    }
    
    public void editarProduto(Produto produto){
        produtoDAO.editar(produto);
    }
    
    public void excluirProduto(int id){
        produtoDAO.excluir(id);
    }
    
    public int buscarPornome(String nome){
        return produtoDAO.buscaPorNome(nome);
    }
    
    public Produto getProduto(int id) {
        return produtoDAO.getProduto(id);
    }
    
    public void buscaProdutosPorIdVendedor(int id){
        produtoDAO.buscaProdutosPorIdVendedor(id);
    }
    
    public void editarQuantidadeEstoque(Produto produto) {
        produtoDAO.editarQuantidadeEstoque(produto);
    }
    
    /////////////////////////////////////////////////////////////////
    //avaliacao
    public void salvarAvaliacao(Avaliacao avaliacao){
        avaliacaoDAO.salvar(avaliacao);
    }
    
    public void editarProduto(Avaliacao avaliacao){
        avaliacaoDAO.editar(avaliacao);
    }
    
    public void excluirAvaliacao(int idCliente, int idVendedor){
        avaliacaoDAO.excluir(idCliente, idVendedor);
    }
    
    public Avaliacao getAvaliacao(int idCliente, int idVendedor) {
        return avaliacaoDAO.get(idCliente, idVendedor);
    }
    
    /////////////////////////////////////////////////////////////////
    //carrinho
    
    public void salvarCarrinho(Cliente cliente){
        carrinhoDAO.salvar(cliente);
    }
    
    public Carrinho buscaCarrinhoAtual(int id_Cliente){
        return carrinhoDAO.buscaCarrinhoAtual(id_Cliente);
    }
    
    public void alterarPrecoTotalCarrinho(Carrinho carrinho) {
        carrinhoDAO.alterarPrecoTotalCarrinho(carrinho);
    }
    
    public void finalizarCarrinho(Carrinho carrinho) {
        carrinhoDAO.finalizarCarrinho(carrinho);
    }
    
    public void buscaPedidosFinalizados(int idCliente){
        carrinhoDAO.buscaPedidosFinalizados(idCliente);
    }
    /////////////////////////////////////////////////////////////////
    //item

    public void salvarItem(Item item){
        itemDAO.salvar(item);
    }
    
    public void editarItem(Item Item){
        itemDAO.editar(Item);
    }
    
    public void excluirItem(int id){
        itemDAO.excluir(id);
    }
    
    public Item getItem(int id){
        return itemDAO.getItem(id);
    }
    
    public int buscaItemPorIdCarrinho(Carrinho carrinho){
        return itemDAO.buscaItemPorIdCarrinho(carrinho.getId());
    }
    
    public double somaValorItensCarrinho(int id) {
        return itemDAO.somaValorItensCarrinho(id);
    }
    
    public void editaEstoqueItemPorIdCarrinho(int id) {
        itemDAO.editaEstoqueItemPorIdCarrinho(id);
    }
    /////////////////////////////////////////////////////////////////
    //autenticação
    public int login(String email, String senha, String tableNome) {
        return autenticacaoDAO.login(email, senha, tableNome);
    }
    
    /////////////////////////////////////////////////////////////////
    //View - Menus
    public void cadastroLoginMenu() {
        menu.cadastroLogin();
    }

    public void cadastroMenu(Scanner input) {
        menu.cadastro(input);
    }
    
    public void loginMenu(Scanner input) {
        menu.login(input);
    }

    public void clienteMenu(int id, Scanner input) {
        menu.cliente(id, input);
    }
    
    public void vendedorMenu(int id, Scanner input) {
        menu.vendedor(id, input);
    }
    
    /////////////////////////////////////////////////////////////////
    //View - Autenticacao
    public void cadastroClienteAutenticacao(Scanner input) {
        autenticacao.cadastroCliente(input);
    }
    
    public void cadastroVendedorAutenticacao(Scanner input) {
        autenticacao.cadastroVendedor(input);
    }
    
    public int loginAutenticacao(String email, String senha, Scanner input) {
        return autenticacao.login(email, senha, input);
    }
    
    /////////////////////////////////////////////////////////////////
    //Formulario
    public Endereco lerEndereco(Scanner input){
        return formulario.lerEndereco(input);
    }
    public Cliente lerCliente(Scanner input){
        return formulario.lerCliente(input);
    }
    public Vendedor lerVendedor(Scanner input){
        return formulario.lerVendedor(input);
    }
    public Produto lerProduto(int id, Scanner input){
        return formulario.lerProduto(id, input);
    }
    public Item lerItem(Scanner input, int idCliente){
        return formulario.lerItem(input, idCliente);
    }
    
    public Carrinho lerCarrinho(Scanner input, Carrinho carrinho){
        return formulario.lerCarrinho(input, carrinho);
    }
}