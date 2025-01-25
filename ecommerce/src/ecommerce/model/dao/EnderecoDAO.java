package ecommerce.model.dao;

//entity
import ecommerce.model.entity.Endereco;

//imports obrigatorios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {
    private Connection connection;  
    
    public EnderecoDAO(){
        connection = new Conexao().getConnection();
    }
    
    public void salvar(Endereco endereco) {      
        String sql = "INSERT INTO endereco (cep, rua, complemento, logradouro, bairro, cidade, estado, numero) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getLogradouro());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getCidade());
            stmt.setString(7, endereco.getEstado());
            stmt.setInt(8, endereco.getNumero());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    //metodo editar
    public void editar(Endereco endereco) {      
        String sql = "UPDATE endereco SET cep = ?, rua = ?, complemento = ?, logradouro = ?, bairro = ?, cidade = ?, estado = ?, numero = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getComplemento());
            stmt.setString(4, endereco.getLogradouro());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getCidade());
            stmt.setString(7, endereco.getEstado());
            stmt.setInt(8, endereco.getNumero());
            stmt.setInt(9, endereco.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    //metodo excluir
    public void excluir(int id) {
        String sql = "DELETE FROM endereco WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    //metodo get
    public Endereco get(int id) {
        Endereco endereco = null;
        String sql = "SELECT * FROM endereco WHERE id=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setCep(rs.getInt("cep"));
                endereco.setRua(rs.getString("rua"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setNumero(rs.getInt("numero"));
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return endereco;
    }
}
