
package ecommerce.controller;

//imports entity
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Venda;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.ItensCarrinho;
import ecommerce.model.entity.ItensVenda;
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
    //VEnda
    public void salvarVenda(Venda venda, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarVenda(venda, connection);
    }

    public void editarVenda(Venda venda, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarVenda(venda, connection);
    }

    public Venda buscarVendaPorId(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.buscarVendaPorId(id, connection);
    }

    public void excluirVenda(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirVenda(id, connection);
    }

    public double obterTotalVendas(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.obterTotalVendas(connection);
    }

    public List<Venda> listarTodasVendas(Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.listarTodasVendas(connection);
    }

    /////////////////////////////////////////////////////////////////
    //ItensVenda
    public void salvarItemVenda(ItensVenda itemVenda, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarItemVenda(itemVenda, connection);
    }

    public void editarItemVenda(ItensVenda itemVenda, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.editarItemVenda(itemVenda, connection);
    }

    public void excluirItemVenda(int vendaId, int produtoId, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirItemVenda(vendaId, produtoId, connection);
    }

    public List<ItensVenda> listarItensVenda(int vendaId, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.listarItensVenda(vendaId, connection);
    }
    /////////////////////////////////////////////////////////////////
    ///Carrinho
    public void salvarCarrinho(Carrinho carrinho, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.salvarCarrinho(carrinho, connection);
    }

    public void excluirCarrinho(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.excluirCarrinho(id, connection);
    }
    public void limparCarrinho(int idCarrinho, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.limparCarrinho(idCarrinho, connection);
    }

    public Carrinho getCarrinhoPorCliente(int clienteId, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getCarrinhoPorCliente(clienteId, connection);
    }
    /////////////////////////////////////////////////////////////////
    //ItensCarrinho
    public void adicionarItem(ItensCarrinho item, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.adicionarItem(item, connection);
    }

    public void removerItem(int id, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.removerItem(id, connection);
    }

    public void atualizarQuantidade(ItensCarrinho item, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        ecommerceService.atualizarQuantidade(item, connection);
    }

    public List<ItensCarrinho> getItensPorCarrinho(int carrinhoId, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.getItensPorCarrinho(carrinhoId, connection);
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
    public ItensCarrinho lerItem(Scanner input, int idCliente, Connection connection) {
        EcommerceService ecommerceService = new EcommerceService();
        return ecommerceService.lerItem(input, idCliente, connection);
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
