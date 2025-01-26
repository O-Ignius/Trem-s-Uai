/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.model.dao;

import java.sql.*;
import ecommerce.model.entity.Pedido;
import ecommerce.model.entity.Carrinho;
/**
 *
 * @author Andre
 */
public class PedidoDAO {
    private Connection connection;

    public PedidoDAO() {
        connection = new Conexao().getConnection();
    }

    // Método para salvar um novo pedido
    public void salvar(Pedido pedido) {
        String sql = "INSERT INTO pedido (finalizado, precoTotal, dataPedido, tipoPagamento, carrinho_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setBoolean(1, pedido.isFinalizado());
            stmt.setDouble(2, pedido.getPrecoTotal());
            stmt.setDate(3, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setInt(4, pedido.getTipoPagamento());
            stmt.setInt(5, pedido.getCarrinho().getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para editar um pedido existente
    public void editar(Pedido pedido) {
        String sql = "UPDATE pedido SET finalizado = ?, precoTotal = ?, dataPedido = ?, tipoPagamento = ?, carrinho_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setBoolean(1, pedido.isFinalizado());
            stmt.setDouble(2, pedido.getPrecoTotal());
            stmt.setDate(3, new java.sql.Date(pedido.getDataPedido().getTime()));
            stmt.setInt(4, pedido.getTipoPagamento());
            stmt.setInt(5, pedido.getCarrinho().getId());
            stmt.setInt(6, pedido.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para excluir um pedido pelo id
    public void excluir(int id) {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para obter um pedido pelo id
    public Pedido get(int id) {
        Pedido pedido = null;
        Carrinho carrinho = null;
        
        String sql = "SELECT * FROM pedido WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setFinalizado(rs.getBoolean("finalizado"));
                pedido.setPrecoTotal(rs.getDouble("precoTotal"));
                pedido.setDataPedido(rs.getDate("dataPedido"));
                pedido.setTipoPagamento(rs.getInt("tipoPagamento"));
                carrinho.setId(rs.getInt("carrinho_id"));
                pedido.setCarrinho(carrinho);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pedido;
    }
}
