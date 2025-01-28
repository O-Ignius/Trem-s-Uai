package ecommerce.controller;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Pedido;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

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
    public void cadastrarCliente(Cliente cliente);
    public void editarCliente(Cliente cliente);
    public void excluirCliente(int id);
    public Cliente getCliente(int id);
    
    //////////////////////////////////////////////////////////////////////
    //Endereco
    public void cadastrarEndereco(Endereco endereco);
    public void editarEndereco(Endereco endereco);
    public void excluirEndereco(int id);
    public Endereco getEndereco(int id);
    
    /////////////////////////////////////////////////////////////////////////
    //Vendedor
    public void cadastrarVendedor(Vendedor vendedor);
    public void editarVendedor(Vendedor vendedor);
    public void excluirVendedor(int id);
    public Vendedor getVendedor(int id);
    
    /////////////////////////////////////////////////////////////////
    //produto
    public void salvarProduto(Produto produto);
    public void editarProduto(Produto produto);
    public void excluirProduto(int id);
    public void buscarPornome(String nome);
    public Produto getProduto (int id);
    public void buscaProdutosPorIdVendedor(int id);
    
    /////////////////////////////////////////////////////////////////
    //avaliacao
    public void salvarAvaliacao(Avaliacao avaliacao);
    public void editarAvaliacao(Produto produto);
    public void excluirAvaliacao(int idCliente, int idProduto);
    public Avaliacao getProduto (int idCliente, int idProduto);
    
    /////////////////////////////////////////////////////////////////
    //carrinho
    public void salvarCarrinho(Cliente cliente);
    public Carrinho buscaCarrinhoAtual(int id_Cliente);
    
    /////////////////////////////////////////////////////////////////
    //item
    public void salvarItem(Item item, Carrinho carrinho);
    public void editarItem(Item Item);
    public void excluirItem(int id);
    public void buscaItemPorIdCarrinho(Carrinho carrinho);
    
    /////////////////////////////////////////////////////////////////
    //pedido
    public void salvarPedido(Pedido pedido);
    public void editarPedido(Pedido Pedido);
    public void excluirPedido(int id);
    public Pedido getPedido (int id);
    public void buscaPedidosPorIdCliente(int id);
    
    /////////////////////////////////////////////////////////////////
    //autenticação
    public int login(String email, String senha, String tableNome);

    /////////////////////////////////////////////////////////////////
    //Views
    public void cadastroLoginMenu();
    public void cadastroMenu();
    public void loginMenu();
    public void clienteMenu(int id);
    public void vendedorMenu(int id);        
    public void cadastroClienteAutenticacao();      
    public void cadastroVendedorAutenticacao();     
    public int loginAutenticacao(String email, String senha);
    
    /////////////////////////////////////////////////////////////////
    //Formulario
    public Endereco lerEndereco();
    public Cliente lerCliente();
    public Vendedor lerVendedor();
    public Produto lerProduto(int id);
}
