package ecommerce.model.dao;

//entitys
import java.sql.Statement;
import ecommerce.model.entity.Cliente;

//controller
import ecommerce.controller.EcommerceController;

//imports obrigatorios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClienteDAO {
    private EcommerceController ecommerceController = new EcommerceController(); 
    
    public ClienteDAO(){
    }
    
    //metodo salvar
    public void salvar(Cliente cliente, Connection connection) {
        String sql = "INSERT INTO cliente (nome, cpf, email, senha, telefone, dataNascimento, nacionalidade, genero, endereco_id) VALUES (?,?,?,?,?,?,?,?,?)";

        //Cadastro de endereco na tabela endereco
        int endereco = ecommerceController.cadastrarEndereco(cliente.getEndereco(), connection);

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getSenha());
            stmt.setString(5, cliente.getTelefone());
            stmt.setDate(6, cliente.getDataNascimento());
            stmt.setString(7, cliente.getNacionalidade());
            stmt.setString(8, cliente.getGenero());
            stmt.setInt(9, endereco);

            stmt.executeUpdate(); 


            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                cliente.setId(rs.getInt(1)); 

                // Criando o carrinho com o ID do cliente
                ecommerceController.salvarCarrinho(cliente, connection);
            }

            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    //metodo editar
    public void editar(Cliente cliente, int id, Connection connection) {      
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, senha = ?, telefone = ?, dataNascimento = ?, nacionalidade = ?, genero = ? WHERE id = ?";
        
        //coleta id do endereco atual
        int idEndereco = get(id, connection).getEndereco().getId();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getSenha());
            stmt.setString(5, cliente.getTelefone());
            stmt.setDate(6, cliente.getDataNascimento());
            stmt.setString(7, cliente.getNacionalidade());
            stmt.setString(8, cliente.getGenero());
            
            //Cadastro de endereco na tabela endereco
            ecommerceController.editarEndereco(cliente.getEndereco(), idEndereco, connection);
            
            stmt.setInt(9, id);
            
            //Tabela Carrinho
            
            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }                 
    
    //metodo excluir

    public void excluir(int id, Connection connection) {
        Cliente cliente = get(id, connection);
        ecommerceController.excluirEndereco(cliente.getEndereco().getId(), connection);
    }
    
    //metodo get
    public Cliente get(int id, Connection connection) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setNome(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEmail(rs.getString("senha"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setDataNascimento(rs.getDate("dataNascimento"));
                cliente.setNacionalidade(rs.getString("nacionalidade"));
                cliente.setGenero(rs.getString("genero"));
                
                //tabela endereco
                cliente.setEndereco(ecommerceController.getEndereco(rs.getInt("endereco_id"), connection));
                
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return cliente;
    }
}
