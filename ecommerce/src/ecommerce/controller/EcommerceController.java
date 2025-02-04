
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
import java.sql.Connection;
import java.util.List;
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
    public void cadastrarCliente(Cliente cliente, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarCliente(cliente, connection);
    }
    
    public void editarCliente(Cliente cliente, int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarCliente(cliente, id, connection);
    }
    
    public void excluirCliente(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirCliente(id, connection);
    }
    
    public Cliente getCliente(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getCliente(id, connection);
    }
    
    ///////////////////////////////////////////////////////////////////////
    //endereco
    public int cadastrarEndereco(Endereco endereco, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.salvarEndereco(endereco, connection);
    }
    
    public void editarEndereco(Endereco endereco, int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarEndereco(endereco, id, connection);
    }
    
    public void excluirEndereco(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirEndereco(id, connection);
    }
    
    public Endereco getEndereco(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getEndereco(id, connection);
    }
    
    ////////////////////////////////////////////////////////////////////////
    //Vendedor
    public void cadastrarVendedor(Vendedor vendedor, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarVendedor(vendedor, connection);
    }
    
    public void editarVendedor(Vendedor vendedor, int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarVendedor(vendedor, id, connection);
    }
    
    public void excluirVendedor(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirVendedor(id, connection);
    }
    
    public Vendedor getVendedor(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getVendedor(id, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //produto
    
    public void salvarProduto(Produto produto, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarProduto(produto, connection);
    }
    
    public void editarProduto(Produto produto, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarProduto(produto, connection);
    }
    
    public void excluirProduto(int id, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirProduto(id, connection);
    }
    
    public int buscarPornome(String nome, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.buscarPornome(nome, connection);
    }
    
    public Produto getProduto (int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getProduto(id, connection);
    }
    
    public void buscaProdutosPorIdVendedor(int id, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.buscaProdutosPorIdVendedor(id, connection);
    }
    
    public void editarQuantidadeEstoque(Produto produto, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarQuantidadeEstoque(produto, connection);
    }
    /////////////////////////////////////////////////////////////////
    //avaliacao
    public void salvarAvaliacao(Avaliacao avaliacao, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarAvaliacao(avaliacao, connection);
    }
    
    public void editarAvaliacao(Produto produto, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarProduto(produto, connection);
    }
    
    public void excluirAvaliacao(int idCliente, int idProduto, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirAvaliacao(idCliente, idProduto, connection);
    }
    
    public Avaliacao getProduto (int idCliente, int idProduto, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getAvaliacao(idCliente, idProduto, connection);
    }
    /////////////////////////////////////////////////////////////////
    //carrinho
    public void salvarCarrinho(Cliente cliente, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarCarrinho(cliente, connection);
    }
    
    public Carrinho buscaCarrinhoAtual(int id_Cliente, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.buscaCarrinhoAtual(id_Cliente, connection);
    }
    
    public void alterarPrecoTotalCarrinho(Carrinho carrinho, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.alterarPrecoTotalCarrinho(carrinho, connection);
    }
    
    public void finalizarCarrinho(Carrinho carrinho, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.finalizarCarrinho(carrinho, connection);
    }
    
    public void buscaPedidosFinalizados(int idCliente, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.buscaPedidosFinalizados(idCliente, connection);
    }
    /////////////////////////////////////////////////////////////////
    //item
    public void salvarItem(Item item, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarItem(item, connection);
    }
    
    public void editarItem(Item Item, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarItem(Item, connection);
    }
    
    public void excluirItem(int id, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirItem(id, connection);
    }

    public Item getItem(int id, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getItem(id, connection);
    }
    
    public int buscaItemPorIdCarrinho(Carrinho carrinho, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.buscaItemPorIdCarrinho(carrinho, connection);
    }
    
    public double somaValorItensCarrinho(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.somaValorItensCarrinho(id, connection);
    }
    
    public void editaEstoqueItemPorIdCarrinho(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editaEstoqueItemPorIdCarrinho(id, connection);
    }
    
    /////////////////////////////////////////////////////////////////
    //autenticaçao
    public int login(String email, String senha, String tableNome, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.login(email, senha, tableNome, connection);
    }

    /////////////////////////////////////////////////////////////////
    //Views
    public void cadastroLoginMenu(){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.cadastroLoginMenu();
    }
    
    public void cadastroMenu(Scanner input, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.cadastroMenu(input, connection);
    }
    
    public void loginMenu(Scanner input, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.loginMenu(input, connection);
    }
    
    public void clienteMenu(int id, Scanner input, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.clienteMenu(id, input, connection);
    }
    
    public void vendedorMenu(int id, Scanner input, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.vendedorMenu(id, input, connection);
    }
    
    ////////////////////////////////
    //Login
    public void cadastroClienteAutenticacao(Scanner input, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.cadastroClienteAutenticacao(input, connection);
    }
    
    public void cadastroVendedorAutenticacao(Scanner input, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.cadastroVendedorAutenticacao(input, connection);
    }
    
    public int loginAutenticacao(String email, String senha, Scanner input, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.loginAutenticacao(email, senha, input, connection);
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
    public Item lerItem(Scanner input, int idCliente, Connection connection){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerItem(input, idCliente, connection);
    }
    
    public Carrinho lerCarrinho(Scanner input, Carrinho carrinho){
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerCarrinho(input, carrinho);
    }
    
    /////////////////////////////////////////////////////////////////
    //CONSULTAS BD
    
    public List<Cliente> listarClientesComEndereco(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.listarClientesComEndereco(connection);
    }
    
    public List<Avaliacao> listarAvaliacoesComProduto(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.listarAvaliacoesComProduto(connection);
    }
    
    public List<Carrinho> listarCarrinhosComItensECliente (Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.listarCarrinhosComItensECliente(connection);
    }
    
    ///
    
    public List<String> obterQuantidadePedidosPorCliente(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterQuantidadePedidosPorCliente(connection);
    }
    
    public List<String> obterMediaPrecoPorTipoPagamento(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterMediaPrecoPorTipoPagamento(connection);
    }
    
    public List<String> obterProdutosMaisVendidos (Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterProdutosMaisVendidos(connection);
    }
    
    ///
    
    public int obterTotalPedidosUltimoMes(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterTotalPedidosUltimoMes(connection);
    }
    
    public double obterMediaVendasUltimaSemana(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterMediaVendasUltimaSemana(connection);
    }
    
    public List<String> obterClientesAtivosUltimoMes(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterClientesAtivosUltimoMes(connection);
    }
    
    ///

    public String obterClienteComMaisPedidos(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterClienteComMaisPedidos(connection);
    }
    
    public List<String> obterClientesComPedidosAcimaDaMedia(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterClientesComPedidosAcimaDaMedia(connection);
    }
    
    public List<String> obterVendedoresComProdutosBemAvaliados(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterVendedoresComProdutosBemAvaliados(connection);
    }
}
