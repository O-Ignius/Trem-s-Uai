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
import ecommerce.model.dao.VendaDAO;
import ecommerce.model.dao.ItensVendaDAO;
import ecommerce.model.dao.AutenticacaoDAO;
import ecommerce.model.dao.CarrinhoDAO;
import ecommerce.model.dao.ConsultasDAO;
import ecommerce.model.dao.ItensCarrinhoDAO;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Venda;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.ItensCarrinho;
import ecommerce.model.entity.ItensVenda;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;
import ecommerce.view.Formulario;

import java.sql.Connection;
import java.util.List;

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
    private VendaDAO vendaDAO;
    private ItensVendaDAO itensVendaDAO;
    private AutenticacaoDAO autenticacaoDAO;
    private Formulario formulario;
    private ConsultasDAO consultas;
    private ItensCarrinhoDAO itensCarrinhoDAO;
    private CarrinhoDAO carrinhoDAO;
    
    //views
    private Menus menu;
    private Autenticacao autenticacao;
            
    public EcommerceService(){
        this.clienteDAO = new ClienteDAO();
        this.enderecoDAO = new EnderecoDAO();
        this.vendedorDAO = new VendedorDAO();
        this.produtoDAO = new ProdutoDAO();
        this.vendaDAO = new VendaDAO();
        this.itensVendaDAO = new ItensVendaDAO();
        this.autenticacaoDAO = new AutenticacaoDAO();
        this.avaliacaoDAO = new AvaliacaoDAO();
        this.itensCarrinhoDAO = new ItensCarrinhoDAO();
        this.carrinhoDAO = new CarrinhoDAO();
        
        //BD
        this.consultas = new ConsultasDAO();
        
        //Fazer de todos
        //view
        this.autenticacao = new Autenticacao();
        this.menu = new Menus();
        this.formulario = new Formulario();
    } 
    
    //cliente
    public void salvarCliente(Cliente cliente, Connection connection){
        clienteDAO.salvar(cliente, connection);
    }
    
    public void editarCliente(Cliente cliente, int id, Connection connection){
        clienteDAO.editar(cliente, id, connection);
    }
    
    public void excluirCliente(int id, Connection connection){
        clienteDAO.excluir(id, connection);
    }
    
    public Cliente getCliente(int id, Connection connection){
        return clienteDAO.get(id, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //endereço
    public int salvarEndereco(Endereco endereco, Connection connection){
        return enderecoDAO.salvar(endereco, connection);
    }
    
    public void editarEndereco(Endereco endereco, int id, Connection connection){
        enderecoDAO.editar(endereco, id, connection);
    }
    
    public void excluirEndereco(int id, Connection connection){
        enderecoDAO.excluir(id, connection);
    }
    
    public Endereco getEndereco(int id, Connection connection){
        return enderecoDAO.get(id, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //vendedor
    public void salvarVendedor(Vendedor vendedor, Connection connection){
        vendedorDAO.salvar(vendedor, connection);
    }
    
    public void editarVendedor(Vendedor vendedor, int id, Connection connection){
        vendedorDAO.editar(vendedor, id, connection);
    }
    
    public void excluirVendedor(int id, Connection connection){
        vendedorDAO.excluir(id, connection);
    }
    
    public Vendedor getVendedor(int id, Connection connection){
        return vendedorDAO.get(id, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //produto
    
    public void salvarProduto(Produto produto, Connection connection){
        produtoDAO.salvar(produto, connection);
    }
    
    public void editarProduto(Produto produto, Connection connection){
        produtoDAO.editar(produto, connection);
    }
    
    public void excluirProduto(int id, Connection connection){
        produtoDAO.excluir(id, connection);
    }
    
    public int buscarPornome(String nome, Connection connection){
        return produtoDAO.buscaPorNome(nome, connection);
    }
    
    public Produto getProduto(int id, Connection connection) {
        return produtoDAO.getProduto(id, connection);
    }
    
    public void buscaProdutosPorIdVendedor(int id, Connection connection){
        produtoDAO.buscaProdutosPorIdVendedor(id, connection);
    }
    
    public void editarQuantidadeEstoque(Produto produto, Connection connection) {
        produtoDAO.editarQuantidadeEstoque(produto, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //avaliacao
    public void salvarAvaliacao(Avaliacao avaliacao, Connection connection){
        avaliacaoDAO.salvar(avaliacao, connection);
    }
    
    public void editarProduto(Avaliacao avaliacao, Connection connection){
        avaliacaoDAO.editar(avaliacao, connection);
    }
    
    public void excluirAvaliacao(int idCliente, int idVendedor, Connection connection){
        avaliacaoDAO.excluir(idCliente, idVendedor, connection);
    }
    
    public Avaliacao getAvaliacao(int idCliente, int idVendedor, Connection connection) {
        return avaliacaoDAO.get(idCliente, idVendedor, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //VEnda
    public void salvarVenda(Venda venda, Connection connection) {
        vendaDAO.salvar(venda, connection);
    }
    public void editarVenda(Venda venda, Connection connection) {
        vendaDAO.editar(venda, connection);
    }
    public Venda buscarVendaPorId(int id, Connection connection) {
        return vendaDAO.getVenda(id, connection);
    }
    public void excluirVenda(int id, Connection connection) {
        vendaDAO.excluir(id, connection);
    }
    public double obterTotalVendas(Connection connection) {
        return vendaDAO.getTotalVendas(connection);
    }
    public List<Venda> listarTodasVendas(Connection connection) {
        return vendaDAO.listarTodasVendas(connection);
    }
    /////////////////////////////////////////////////////////////////
    //ItensVenda
    public void salvarItemVenda(ItensVenda itemVenda, Connection connection) {
        itensVendaDAO.salvar(itemVenda, connection);
    }
    public void editarItemVenda(ItensVenda itemVenda, Connection connection) {
        itensVendaDAO.editar(itemVenda, connection);
    }
    public void excluirItemVenda(int vendaId, int produtoId, Connection connection) {
        itensVendaDAO.excluir(vendaId, produtoId, connection);
    }
    public List<ItensVenda> listarItensVenda(int vendaId, Connection connection) {
        return itensVendaDAO.listarItensVenda(vendaId, connection);
    }
    /////////////////////////////////////////////////////////////////
    ///ItensCarrinhos
    public void adicionarItem(ItensCarrinho item, Connection connection) {
        itensCarrinhoDAO.adicionarItem(item, connection);
    }
    public void removerItem(int id, Connection connection) {
        itensCarrinhoDAO.removerItem(id, connection);
    }
    public void atualizarQuantidade(ItensCarrinho item, Connection connection) {
        itensCarrinhoDAO.atualizarQuantidade(item, connection);
    }
    public List<ItensCarrinho> getItensPorCarrinho(int carrinhoId, Connection connection) {
        return itensCarrinhoDAO.getItensPorCarrinho(carrinhoId, connection);
    }
    /////////////////////////////////////////////////////////////////
    ///Carrinho
    public void salvarCarrinho(Carrinho carrinho, Connection connection) {
        carrinhoDAO.salvar(carrinho, connection);
    }
    public void excluirCarrinho(int id, Connection connection) {
        carrinhoDAO.excluir(id, connection);
    }
    public Carrinho getCarrinhoPorCliente(int clienteId, Connection connection) {
        return carrinhoDAO.getCarrinhoPorCliente(clienteId, connection);
    }
    
    public void limparCarrinho(int carrinhoId, Connection connection) {
        carrinhoDAO.limparCarrinho(carrinhoId, connection);
    }
    
    
    
    
    /////////////////////////////////////////////////////////////////
    //autenticação
    public int login(String email, String senha, String tableNome, Connection connection) {
        return autenticacaoDAO.login(email, senha, tableNome, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //View - Menus
    public void cadastroLoginMenu() {
        menu.cadastroLogin();
    }

    public void cadastroMenu(Scanner input, Connection connection) {
        menu.cadastro(input, connection);
    }
    
    public void loginMenu(Scanner input, Connection connection) {
        menu.login(input, connection);
    }

    public void clienteMenu(int id, Scanner input, Connection connection) {
        menu.cliente(id, input, connection);
    }
    
    public void vendedorMenu(int id, Scanner input, Connection connection) {
        menu.vendedor(id, input, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //View - Autenticacao
    public void cadastroClienteAutenticacao(Scanner input, Connection connection) {
        autenticacao.cadastroCliente(input, connection);
    }
    
    public void cadastroVendedorAutenticacao(Scanner input, Connection connection) {
        autenticacao.cadastroVendedor(input, connection);
    }
    
    public int loginAutenticacao(String email, String senha, Scanner input, Connection connection) {
        return autenticacao.login(email, senha, input, connection);
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
    public ItensCarrinho lerItem(Scanner input, int idCliente, Connection connection) {
        return formulario.lerItem(input, idCliente, connection);
    }


    
    
    /////////////////////////////////////////////////////////////////
    //CONSULTAS BD
    public List<Cliente> listarClientesComEndereco(Connection connection) {
        return consultas.listarClientesComEndereco(connection);
    }
    
    public List<Avaliacao> listarAvaliacoesComProduto(Connection connection) {
        return consultas.listarAvaliacoesComProduto(connection);
    }
    
    public List<Carrinho> listarCarrinhosComItensECliente (Connection connection) {
        return consultas.listarCarrinhosComItensECliente(connection);
    }
    
    ///
    
    public List<String> obterQuantidadePedidosPorCliente(Connection connection) {
        return consultas.obterQuantidadePedidosPorCliente(connection);
    }
    
    public List<String> obterMediaPrecoPorTipoPagamento(Connection connection) {
        return consultas.obterMediaPrecoPorTipoPagamento(connection);
    }
    
    public List<String> obterProdutosMaisVendidos (Connection connection) {
        return consultas.obterProdutosMaisVendidos(connection);
    }
    
    ///
    
    public int obterTotalPedidosUltimoMes(Connection connection) {
        return consultas.obterTotalPedidosUltimoMes(connection);
    }
    
    public double obterMediaVendasUltimaSemana(Connection connection) {
        return consultas.obterMediaVendasUltimaSemana(connection);
    }
    
    public List<String> obterClientesAtivosUltimoMes(Connection connection) {
        return consultas.obterClientesAtivosUltimoMes(connection);
    }
    
    
    ///
    
    public String obterClienteComMaisPedidos(Connection connection) {
        return consultas.obterClienteComMaisPedidos(connection);
    }
    
    public List<String> obterClientesComPedidosAcimaDaMedia(Connection connection) {
        return consultas.obterClientesComPedidosAcimaDaMedia(connection);
    }
    
    public List<String> obterVendedoresComProdutosBemAvaliados(Connection connection) {
        return consultas.obterVendedoresComProdutosBemAvaliados(connection);
    }
}