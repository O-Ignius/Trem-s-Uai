package ecommerce.model.dao;

//entitys
import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Endereco;

//controller
import ecommerce.controller.EcommerceController;

//imports obrigatorios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClienteDAO {
    private Connection connection;
    private EcommerceController ecommerceController = new EcommerceController(); 
    
    public ClienteDAO(){
        connection = new Conexao().getConnection();
    }
    
    //metodo salvar
    public void salvar(Cliente cliente) {      
        String sql = "INSERT INTO cliente (nome, cpf, email, senha, telefone, dataNascimento, nacionalidade, genero, endereco_id) VALUES (?,?,?,?,?,?,?,?,?)";
        
        Endereco endereco = new Endereco();
        
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
            
            endereco = cliente.getEndereco();
            stmt.setInt(9, endereco.getId());
            
            //Cadastro de endereco na tabela endereco
            ecommerceController.cadastrarEndereco(cliente.getEndereco());
            
            //Tabela Carrinho
            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    //metodo editar
    public void editar(Cliente cliente) {      
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, senha = ?, telefone = ?, dataNascimento = ?, nacionalidade = ?, genero = ?, endereco_id = ? WHERE id = ?";
        
        Endereco endereco = new Endereco();
        
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
            
            //salva novo endereço id
            endereco = cliente.getEndereco();
            stmt.setInt(9, endereco.getId());
            
            //Cadastro de endereco na tabela endereco
            ecommerceController.editarEndereco(cliente.getEndereco());
            
            //Tabela Carrinho
            
            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    //metodo excluir
    public void excluir(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        
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
    public Cliente get(int id) {
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
                ecommerceController.getEndereco(rs.getInt("endereco_id"));
                
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return cliente;
    }
}
