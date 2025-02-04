package ecommerce.model.dao;

import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Cliente;
import ecommerce.controller.EcommerceController;

import java.sql.*;

public class CarrinhoDAO {
    private EcommerceController ecommerceController = new EcommerceController();

    public CarrinhoDAO() {
    }

    // Método para salvar um novo Carrinho
    public void salvar(Carrinho carrinho, Connection connection) {
        String sql = "INSERT INTO carrinho (cliente_id, data_criacao) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, carrinho.getCliente().getId());
            stmt.setTimestamp(2, new Timestamp(carrinho.getDataCriacao().getTime()));
            stmt.executeUpdate();
            
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                carrinho.setId(generatedKeys.getInt(1));
            }
            
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para excluir um Carrinho pelo id
    public void excluir(int id, Connection connection) {
        String sql = "DELETE FROM carrinho WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para buscar um Carrinho pelo id do cliente
    public Carrinho getCarrinhoPorCliente(int clienteId, Connection connection) {
        Carrinho carrinho = null;
        String sql = "SELECT * FROM carrinho WHERE cliente_id = ? ORDER BY data_criacao DESC LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, clienteId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                carrinho = new Carrinho();
                carrinho.setId(rs.getInt("id"));
                carrinho.setCliente(ecommerceController.getCliente(clienteId, connection));
                carrinho.setDataCriacao(rs.getTimestamp("data_criacao"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return carrinho;
    }
    public Carrinho getCarrinhoById(int carrinhoId, Connection connection) {
        Carrinho carrinho = null;
        String sql = "SELECT * FROM ecommerce.carrinho WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, carrinhoId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                carrinho = new Carrinho();
                carrinho.setId(rs.getInt("id"));
                // Aqui, recuperamos o cliente associado ao carrinho
                int clienteId = rs.getInt("cliente_id");
                carrinho.setCliente(ecommerceController.getCliente(clienteId, connection));
                carrinho.setDataCriacao(rs.getTimestamp("data_criacao"));
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carrinho;
    }
    
    public void limparCarrinho(int carrinhoId, Connection connection) {
        String sql = "DELETE FROM ItensCarrinho WHERE carrinho_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, carrinhoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao limpar o carrinho.");
        }


    }
    
    
}
