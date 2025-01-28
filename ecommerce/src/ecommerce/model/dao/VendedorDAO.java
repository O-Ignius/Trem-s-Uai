package ecommerce.model.dao;

//entitys
import ecommerce.model.entity.Vendedor;

//controller
import ecommerce.controller.EcommerceController;
import ecommerce.model.entity.Endereco;

//imports obrigatorios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {
    private Connection connection;
    private EcommerceController ecommerceController = new EcommerceController(); 
    
    public VendedorDAO(){
        connection = new Conexao().getConnection();
    }
    
    //metodo salvar
    public void salvar(Vendedor vendedor) {      
        String sql = "INSERT INTO vendedor (nome, cpf, cnpj, email, senha, telefone, dataNascimento, nacionalidade, genero, endereco_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
                
        Endereco endereco = new Endereco();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCpf());
            stmt.setString(3, vendedor.getCnpj());
            stmt.setString(4, vendedor.getEmail());
            stmt.setString(5, vendedor.getSenha());
            stmt.setString(6, vendedor.getTelefone());
            stmt.setDate(7, vendedor.getDataNascimento());
            stmt.setString(8, vendedor.getNacionalidade());
            stmt.setString(9, vendedor.getGenero());
            
            //salva novo endereço id
            endereco = vendedor.getEndereco();
            stmt.setInt(10, endereco.getId());
            
            //Cadastro de endereco na tabela endereco
            ecommerceController.cadastrarEndereco(vendedor.getEndereco());
            
            //Tabela Carrinho
            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    //metodo editar
    public void editar(Vendedor vendedor) {      
        String sql = "UPDATE vendedor SET nome = ?, cpf = ?, cnpj = ?, email = ?, senha = ?, telefone = ?, dataNascimento = ?, nacionalidade = ?, genero = ?, endereco_id = ? WHERE id = ?";
                        
        Endereco endereco = new Endereco();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCpf());
            stmt.setString(3, vendedor.getCnpj());
            stmt.setString(4, vendedor.getEmail());
            stmt.setString(5, vendedor.getSenha());
            stmt.setString(6, vendedor.getTelefone());
            stmt.setDate(7, vendedor.getDataNascimento());
            stmt.setString(8, vendedor.getNacionalidade());
            stmt.setString(9, vendedor.getGenero());
            
            //salva novo endereço id
            endereco = vendedor.getEndereco();
            stmt.setInt(10, endereco.getId());
            
            //Cadastro de endereco na tabela endereco
            ecommerceController.editarEndereco(vendedor.getEndereco());
            
            //Tabela Carrinho
            
            
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    //metodo excluir
    public void excluir(int id) {
        String sql = "DELETE FROM vendedor WHERE id = ?";
        
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
    public Vendedor get(int id) {
        Vendedor vendedor = null;
        String sql = "SELECT * FROM vendedor WHERE id=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                vendedor = new Vendedor();
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCpf(rs.getString("cpf"));
                vendedor.setCnpj(rs.getString("cnpj"));
                vendedor.setEmail(rs.getString("email"));
                vendedor.setSenha(rs.getString("senha"));
                vendedor.setTelefone(rs.getString("telefone"));
                vendedor.setDataNascimento(rs.getDate("dataNascimento"));
                vendedor.setNacionalidade(rs.getString("nacionalidade"));
                vendedor.setGenero(rs.getString("genero"));
                
                //tabela endereco
                ecommerceController.getEndereco(rs.getInt("endereco_id"));
                
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return vendedor;
    }
}
