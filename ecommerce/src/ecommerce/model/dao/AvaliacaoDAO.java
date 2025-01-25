package ecommerce.model.dao;

//entitys
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Produto;

//controller
import ecommerce.controller.EcommerceController;

//imports obrigatorios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliacaoDAO {
    private Connection connection;
    private Cliente cliente;
    private Produto produto;
    private EcommerceController ecommerceController = new EcommerceController();
    
    
    public AvaliacaoDAO(){
        connection = new Conexao().getConnection();
    }
    
    //metodo salvar
    public void salvar(Avaliacao avaliacao) {      
        String sql = "INSERT INTO avaliacao (nota, comentario, data, cliente_id, produto_id VALUES (?,?,?,?,?)";
        try {
            cliente = new Cliente();
            produto = new Produto();
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, avaliacao.getNota());
            stmt.setString(2, avaliacao.getComentario());
            stmt.setDate(3, avaliacao.getData());
            
            cliente = avaliacao.getCliente();
            
            stmt.setInt(4, cliente.getId());
            
            produto = avaliacao.getProduto();
            
            stmt.setInt(5, produto.getId());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    //metodo editar
    public void editar(Avaliacao avaliacao) {      
        String sql = "UPDATE avaliacao SET nota = ?, comentario = ?, data = ? WHERE cliente_id = ? AND produto_id = ?";
        try {
            cliente = new Cliente();
            produto = new Produto();
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, avaliacao.getNota());
            stmt.setString(2, avaliacao.getComentario());
            stmt.setDate(3, avaliacao.getData());
            
            cliente = avaliacao.getCliente();
            
            stmt.setInt(4, cliente.getId());
            
            produto = avaliacao.getProduto();
            
            stmt.setInt(5, produto.getId());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    //metodo excluir
    public void excluir(int idCliente, int idProduto) {
        String sql = "DELETE FROM avaliacao WHERE cliente_id = ? AND produto_id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idCliente);
            stmt.setLong(1, idProduto);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    //metodo get
    public Avaliacao get(int idCliente, int idProduto) {
        Avaliacao avaliacao = null;
        String sql = "SELECT * FROM avaliacao cliente_id = ? AND produto_id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, idCliente);
            stmt.setLong(1, idProduto);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                avaliacao = new Avaliacao();
                avaliacao.setNota(rs.getInt("nota"));
                avaliacao.setComentario(rs.getString("comentario"));
                avaliacao.setData(rs.getDate("data"));
                
                //get cliente
                ecommerceController.getCliente(rs.getInt("cliente"));
                
                //get produto
                ecommerceController.getProduto(rs.getInt("produto"));
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return avaliacao;
    }
}
