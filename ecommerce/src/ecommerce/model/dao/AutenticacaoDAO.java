package ecommerce.model.dao;

//imports obrigatorios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutenticacaoDAO {
    private Connection connection;
    
    public AutenticacaoDAO() {
        connection = new Conexao().getConnection();
    }
    
    //login
    public int login(String email, String senha, String tableNome) {
        String sql = "SELECT nome FROM " + tableNome + " WHERE email = ? AND senha = ?";
        int id;
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
                else {
                    return -1;
                }
            }
                
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    
        return id;
    }
}
