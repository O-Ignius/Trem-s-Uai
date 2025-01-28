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
import ecommerce.model.dao.PedidoDAO;
import ecommerce.model.dao.AutenticacaoDAO;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Pedido;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;
import javax.swing.text.View;

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
    private PedidoDAO pedidoDAO;
    private AutenticacaoDAO autenticacaoDAO;
    
    //views
    private Menus menu;
    private Autenticacao autenticacao;
            
    public EcommerceService(){
        this.clienteDAO = new ClienteDAO();
        this.enderecoDAO = new EnderecoDAO();
        this.vendedorDAO = new VendedorDAO();
        
        //view
        this.autenticacao = new Autenticacao();
        this.menu = new Menus();
    } 
    
    //cliente
    public void salvarCliente(Cliente cliente){
        clienteDAO.salvar(cliente);
    }
    
    public void editarCliente(Cliente cliente){
        clienteDAO.editar(cliente);
    }
    
    public void excluirCliente(int id){
        clienteDAO.excluir(id);
    }
    
    public Cliente getCliente(int id){
        return clienteDAO.get(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //endereço
    public void salvarEndereco(Endereco endereco){
        enderecoDAO.salvar(endereco);
    }
    
    public void editarEndereco(Endereco endereco){
        enderecoDAO.editar(endereco);
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
    
    public void editarVendedor(Vendedor vendedor){
        vendedorDAO.editar(vendedor);
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
    
    public void buscarPornome(String nome){
        produtoDAO.buscaPorNome(nome);
    }
    
    public Produto getProduto(int id) {
        return produtoDAO.getProduto(id);
    }
    
    public void buscaProdutosPorIdVendedor(int id){
        produtoDAO.buscaProdutosPorIdVendedor(id);
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
    
    /////////////////////////////////////////////////////////////////
    //item

    public void salvarItem(Item item, Carrinho carrinho){
        itemDAO.salvar(item, carrinho);
    }
    
    public void editarItem(Item Item){
        itemDAO.editar(Item);
    }
    
    public void excluirItem(int id){
        itemDAO.excluir(id);
    }
    
    public void buscaItemPorIdCarrinho(Carrinho carrinho){
        itemDAO.buscaItemPorIdCarrinho(carrinho.getId());
    }
    
    /////////////////////////////////////////////////////////////////
    //pedido
    public void salvarPedido(Pedido pedido){
        pedidoDAO.salvar(pedido);
    }
    
    public void editarPedido(Pedido Pedido){
        pedidoDAO.editar(Pedido);
    }
    
    public void excluirPedido(int id){
        pedidoDAO.excluir(id);
    }
    
    public Pedido getPedido (int id){
        return pedidoDAO.get(id);
    }
    
    public void buscaPedidosPorIdCliente(int id){
        pedidoDAO.buscaPedidosPorIdCliente(id);
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

    public void cadastroMenu() {
        menu.cadastro();
    }
    
    public void loginMenu() {
        menu.login();
    }

    public void clienteMenu(int id) {
        menu.cliente(id);
    }
    
    public void vendedorMenu(int id) {
        menu.vendedor(id);
    }
    
    /////////////////////////////////////////////////////////////////
    //View - Autenticacao
    public void cadastroClienteAutenticacao() {
        autenticacao.cadastroCliente();
    }
    
    public void cadastroVendedorAutenticacao() {
        autenticacao.cadastroVendedor();
    }
    
    public int loginAutenticacao(String email, String senha) {
        return autenticacao.login(email, senha);
    }
}
