package ecommerce.model.dao;

//entity relacionados
import ecommerce.model.entity.Avaliacao;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

//imports obrigatorios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemploDAO {
    /*
    private Connection connection;  
    
    public EditoraDAO(){
        connection = new Conexao().getConnection();
    }    

    // Método para salvar uma nova editora
    public void salvar(Editora editora) {      
        String sql = "INSERT INTO Editora (nome, endereco, telefone, email) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getEndereco());
            stmt.setString(3, editora.getTelefone());
            stmt.setString(4, editora.getEmail());            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para editar uma editora existente
    public void editar(Editora editora) {      
        String sql = "UPDATE Editora SET nome = ?, endereco = ?, telefone = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, editora.getNome());
            stmt.setString(2, editora.getEndereco());
            stmt.setString(3, editora.getTelefone());
            stmt.setString(4, editora.getEmail());
            stmt.setLong(5, editora.getId());  // A editora tem um atributo 'id'
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para excluir uma editora pelo id
    public void excluir(long id) {
        String sql = "DELETE FROM Editora WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);  // Usamos o 'id' para identificar a editora a ser excluída
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public Editora get(long id) {
        Editora editora = null;
        String sql = "SELECT * FROM Editora WHERE id=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id); // Aqui passamos o id da editora para a consulta
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                editora = new Editora();
                editora.setId(rs.getLong("id"));
                editora.setNome(rs.getString("nome"));
                editora.setEndereco(rs.getString("endereco"));
                editora.setTelefone(rs.getString("telefone"));
                editora.setEmail(rs.getString("email"));
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return editora;
    }  

    public void all() {
        String sql = "SELECT * FROM Editora";
        try {
            connection.prepareStatement(sql);
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    */
}
