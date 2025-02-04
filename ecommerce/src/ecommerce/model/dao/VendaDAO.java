package ecommerce.model.dao;

import ecommerce.model.entity.Venda;
import ecommerce.model.entity.Cliente;
import ecommerce.controller.EcommerceController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private EcommerceController ecommerceController = new EcommerceController();

    public VendaDAO() {
    }

    // Método para salvar uma nova venda
    public void salvar(Venda venda, Connection connection) {
        String sql = "INSERT INTO venda (data_hora, total_pago, tipoPagamento, pagamento_efetuado, cliente_id) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setTimestamp(1, venda.getDataHora());
            stmt.setDouble(2, venda.getTotalPago());
            stmt.setString(3, venda.getTipoPagamento());
            stmt.setBoolean(4, venda.isPagamentoEfetuado());
            stmt.setInt(5, venda.getCliente().getId());
            stmt.executeUpdate();

            // Obtendo o ID gerado automaticamente
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                venda.setId(rs.getInt(1));
            }

            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para editar uma venda existente
    public void editar(Venda venda, Connection connection) {
        String sql = "UPDATE venda SET total_pago = ?, tipoPagamento = ?, pagamento_efetuado = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, venda.getTotalPago());
            stmt.setString(2, venda.getTipoPagamento());
            stmt.setBoolean(3, venda.isPagamentoEfetuado());
            stmt.setInt(4, venda.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para buscar uma venda pelo ID
    public Venda getVenda(int id, Connection connection) {
        Venda venda = null;
        String sql = "SELECT * FROM venda WHERE id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setDataHora(rs.getTimestamp("data_hora"));
                venda.setTotalPago(rs.getDouble("total_pago"));
                venda.setTipoPagamento(rs.getString("tipoPagamento"));
                venda.setPagamentoEfetuado(rs.getBoolean("pagamento_efetuado"));
                
                // Obtendo os dados do cliente relacionado
                int clienteId = rs.getInt("cliente_id");
                Cliente cliente = ecommerceController.getCliente(clienteId, connection);
                venda.setCliente(cliente);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return venda;
    }

    // Método para excluir uma venda pelo ID
    public void excluir(int id, Connection connection) {
        String sql = "DELETE FROM venda WHERE id = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para obter o total de vendas realizadas
    public double getTotalVendas(Connection connection) {
        String sql = "SELECT SUM(total_pago) AS total FROM venda";
        double total = 0;
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("total");
            }

            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return total;
    }

 
    public List<Venda> listarTodasVendas(Connection connection) {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM venda";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setDataHora(rs.getTimestamp("data_hora"));
                venda.setTotalPago(rs.getDouble("total_pago"));
                venda.setTipoPagamento(rs.getString("tipoPagamento"));
                venda.setPagamentoEfetuado(rs.getBoolean("pagamento_efetuado"));
                
                // Obtendo os dados do cliente relacionado
                int clienteId = rs.getInt("cliente_id");
                Cliente cliente = ecommerceController.getCliente(clienteId, connection);
                venda.setCliente(cliente);
                
                vendas.add(venda);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        
        return vendas;
    }
}
