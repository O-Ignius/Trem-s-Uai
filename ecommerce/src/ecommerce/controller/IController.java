package ecommerce.controller;

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
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

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
    public void cadastrarCliente(Cliente cliente, Connection connection);
    public void editarCliente(Cliente cliente, int id, Connection connection);
    public void excluirCliente(int id, Connection connection);
    public Cliente getCliente(int id, Connection connection);
    
    //////////////////////////////////////////////////////////////////////
    //Endereco
    public int cadastrarEndereco(Endereco endereco, Connection connection);
    public void editarEndereco(Endereco endereco, int id, Connection connection);
    public void excluirEndereco(int id, Connection connection);
    public Endereco getEndereco(int id, Connection connection);
    
    /////////////////////////////////////////////////////////////////////////
    //Vendedor
    public void cadastrarVendedor(Vendedor vendedor, Connection connection);
    public void editarVendedor(Vendedor vendedor, int id, Connection connection);
    public void excluirVendedor(int id, Connection connection);
    public Vendedor getVendedor(int id, Connection connection);
    
    /////////////////////////////////////////////////////////////////
    //produto
    public void salvarProduto(Produto produto, Connection connection);
    public void editarProduto(Produto produto, Connection connection);
    public void excluirProduto(int id, Connection connection);
    public int buscarPornome(String nome, Connection connection);
    public Produto getProduto (int id, Connection connection);
    public void buscaProdutosPorIdVendedor(int id, Connection connection);
    public void editarQuantidadeEstoque(Produto produto, Connection connection);
    
    /////////////////////////////////////////////////////////////////
    //avaliacao
    public void salvarAvaliacao(Avaliacao avaliacao, Connection connection);
    public void editarAvaliacao(Produto produto, Connection connection);
    public void excluirAvaliacao(int idCliente, int idProduto, Connection connection);
    public Avaliacao getProduto (int idCliente, int idProduto, Connection connection);
    
    /////////////////////////////////////////////////////////////////
    //Vendas
    public void salvarVenda(Venda venda, Connection connection) ;
    public void editarVenda(Venda venda, Connection connection) ;
    public Venda buscarVendaPorId(int id, Connection connection) ;
    public void excluirVenda(int id, Connection connection) ;
    public double obterTotalVendas(Connection connection) ;
    public List<Venda> listarTodasVendas(Connection connection) ;
    
    /////////////////////////////////////////////////////////////////
    // Itens vendas
    public void salvarItemVenda(ItensVenda itemVenda, Connection connection);
    public void editarItemVenda(ItensVenda itemVenda, Connection connection);
    public void excluirItemVenda(int vendaId, int produtoId, Connection connection);
    public List<ItensVenda> listarItensVenda(int vendaId, Connection connection);
    /////////////////////////////////////////////////////////////////
    // Carrinho
    public void salvarCarrinho(Carrinho carrinho, Connection connection);
    public void excluirCarrinho(int id, Connection connection);
    public Carrinho getCarrinhoPorCliente(int clienteId, Connection connection);
    public void limparCarrinho(int idCarrinho, Connection connection);
    
    /////////////////////////////////////////////////////////////////
    // ItensCarrinho
    public void adicionarItem(ItensCarrinho item, Connection connection);
    public void removerItem(int id, Connection connection);
    public void atualizarQuantidade(ItensCarrinho item, Connection connection);
    public List<ItensCarrinho> getItensPorCarrinho(int carrinhoId, Connection connection);
    
    
    /////////////////////////////////////////////////////////////////
    //autenticação
    public int login(String email, String senha, String tableNome, Connection connection);

    /////////////////////////////////////////////////////////////////
    //Views
    public void cadastroLoginMenu();
    public void cadastroMenu(Scanner input, Connection connection);
    public void loginMenu(Scanner input, Connection connection);
    public void clienteMenu(int id, Scanner input, Connection connection);
    public void vendedorMenu(int id, Scanner input, Connection connection);        
    public void cadastroClienteAutenticacao(Scanner input, Connection connection);      
    public void cadastroVendedorAutenticacao(Scanner input, Connection connection);     
    public int loginAutenticacao(String email, String senha, Scanner input, Connection connection);
    
    /////////////////////////////////////////////////////////////////
    //Formulario
    public Endereco lerEndereco(Scanner input);
    public Cliente lerCliente(Scanner input);
    public Vendedor lerVendedor(Scanner input);
    public Produto lerProduto(int id, Scanner input);
    public ItensCarrinho lerItem(Scanner input, int idCliente, Connection connection);

    /////////////////////////////////////////////////////////////////
    //BD
    
    public List<Cliente> listarClientesComEndereco(Connection connection);
    
    public List<Avaliacao> listarAvaliacoesComProduto(Connection connection);
    
    public List<Carrinho> listarCarrinhosComItensECliente (Connection connection);
    
    ///
    
    public List<String> obterQuantidadePedidosPorCliente(Connection connection);
    
    public List<String> obterMediaPrecoPorTipoPagamento(Connection connection);
    
    public List<String> obterProdutosMaisVendidos (Connection connection);
    
    ///
    
    public int obterTotalPedidosUltimoMes(Connection connection);
    
    public double obterMediaVendasUltimaSemana(Connection connection);
    
    public List<String> obterClientesAtivosUltimoMes(Connection connection);
    
    ///

    public String obterClienteComMaisPedidos(Connection connection);
    
    public List<String> obterClientesComPedidosAcimaDaMedia(Connection connection);
    
    public List<String> obterVendedoresComProdutosBemAvaliados(Connection connection);
}
