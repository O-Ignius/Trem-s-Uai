package biblioteca.model.dao;

import biblioteca.model.entity.Editora;
import biblioteca.model.entity.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO {
    private Connection connection;  
    
    public LivroDAO(){
        connection = new Conexao().getConnection();
    }    
    public void salvar(Livro livro) {      
        String sql = "INSERT INTO "
                + "Livro (nome, descricao, autor, isbn, anoPublicacao, preco, id_Editora) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getDescricao());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getIsbn());
            stmt.setInt(5, livro.getAnoPublicacao());
            stmt.setDouble(6, livro.getPreco());
            stmt.setLong(7, livro.getEditora().getId());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void editar(Livro livro) {
        String sql = "UPDATE Livro SET "
                   + "nome = ?, descricao = ?, autor = ?, isbn = ?, anoPublicacao = ?, preco = ?, id_Editora = ? "
                   + "WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, livro.getNome());
            stmt.setString(2, livro.getDescricao());
            stmt.setString(3, livro.getAutor());
            stmt.setString(4, livro.getIsbn());
            stmt.setInt(5, livro.getAnoPublicacao());
            stmt.setDouble(6, livro.getPreco());
            stmt.setLong(7, livro.getEditora().getId());
            stmt.setLong(8, livro.getId()); // Aqui, o id do livro é utilizado para identificar qual livro será editado
            
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void excluir(long id) {
        String sql = "DELETE FROM Livro WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id); // Aqui, o id do livro é utilizado para identificar qual livro será excluído
            
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public Livro get(long id) {
        Livro livro = null;
        String sql = "SELECT * FROM Livro WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id); // Aqui, o id do livro é utilizado para identificar qual livro será excluído

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                livro = new Livro();
                livro.setId(rs.getLong("id"));
                livro.setNome(rs.getString("nome"));
                livro.setDescricao(rs.getString("descricao"));
                livro.setAutor(rs.getString("autor"));
                livro.setIsbn(rs.getString("isbn"));
                livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
                livro.setPreco(rs.getDouble("preco"));

                Editora editora = new Editora();
                editora.setId(rs.getLong("id_Editora"));
                livro.setEditora(editora);
            }

            rs.close();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

        return livro;
    }  

    public void all() {
        String sql = "SELECT * FROM Livro";
        try {
            connection.prepareStatement(sql);
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
