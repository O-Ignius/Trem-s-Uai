package ecommerce.controller;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
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
    //carrinho
    public void salvarCarrinho(Cliente cliente, Connection connection);
    public Carrinho buscaCarrinhoAtual(int id_Cliente, Connection connection);
    public void alterarPrecoTotalCarrinho(Carrinho carrinho, Connection connection);
    public void finalizarCarrinho(Carrinho carrinho, Connection connection);
    public void buscaPedidosFinalizados(int idCliente, Connection connection);
    
    /////////////////////////////////////////////////////////////////
    //item

    public void salvarItem(Item item, Connection connection);
    public void editarItem(Item Item, Connection connection);
    public void excluirItem(int id, Connection connection);
    public int buscaItemPorIdCarrinho(Carrinho carrinho, Connection connection);
    public double somaValorItensCarrinho(int id, Connection connection);
    public void editaEstoqueItemPorIdCarrinho(int id, Connection connection);
    public Item getItem(int id, Connection connection);

    
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
    public Item lerItem(Scanner input, int idCliente, Connection connection);
    public Carrinho lerCarrinho(Scanner input, Carrinho carrinho);
    
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
    
    public List<String> obterClientesQueGastaramAcimaDaMedia(Connection connection);
}
