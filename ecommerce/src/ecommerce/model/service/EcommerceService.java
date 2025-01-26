package ecommerce.model.service;

/* MODELO
import biblioteca.model.dao.EditoraDAO;
import biblioteca.model.dao.LivroDAO;
import biblioteca.model.entity.Editora;
import biblioteca.model.entity.Livro;
*/

//DAO
import ecommerce.model.dao.ClienteDAO;
import ecommerce.model.dao.EnderecoDAO;
import ecommerce.model.dao.VendedorDAO;
import ecommerce.model.dao.ProdutoDAO;
import ecommerce.model.dao.CarrinhoDAO;
import ecommerce.model.dao.ItemDAO;
import ecommerce.model.dao.PedidoDAO;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Pedido;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

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
    private CarrinhoDAO carrinhoDAO;
    private ItemDAO itemDAO;
    private PedidoDAO pedidoDAO;
            
    public EcommerceService(){
        this.clienteDAO = new ClienteDAO();
        this.enderecoDAO = new EnderecoDAO();
        this.vendedorDAO = new VendedorDAO();
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
    
    /////////////////////////////////////////////////////////////////
    //carrinho
    
    public void salvarCarrinho(Cliente cliente){
        carrinhoDAO.salvar(cliente);
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
    
    public void buscarPorIdCarrinho(Carrinho carrinho){
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
}
