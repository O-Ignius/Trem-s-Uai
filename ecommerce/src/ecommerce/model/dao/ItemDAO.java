/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.model.dao;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Carrinho;

/**
 *
 * @author Andre
 */

import java.sql.*;

public class ItemDAO {
    private Connection connection;

    public ItemDAO() {
        connection = new Conexao().getConnection();
    }

    // Método para salvar um novo Item
    public void salvar(Item item, Carrinho carrinho) {
        String sql = "INSERT INTO item (quantidadeItem, subTotal, produto_id, carrinho_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidadeItem());
            stmt.setDouble(2, item.getSubTotal());
            stmt.setInt(3, item.getProduto().getId());
            stmt.setInt(4, carrinho.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para editar um Item existente
    public void editar(Item item) {
        String sql = "UPDATE item SET quantidadeItem = ?, subTotal = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidadeItem());
            stmt.setDouble(2, item.getSubTotal());
            stmt.setInt(5, item.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para excluir um Item pelo id
    public void excluir(int id) {
        String sql = "DELETE FROM item WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para buscar um Item pelo id
    public void buscaItemPorIdCarrinho(int id) {
    String sql = "select p.nome, i.quantidadeItem, i.subTotal as subTotal from item i  inner join produto p on (p.id = i.produto_id) where i.carrinho_id =" + id + ";";

    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            System.out.println("\nProduto: " + rs.getString("nome") + "\n"
                    + "Quantidade: " + rs.getString("quantidadeItem") + "\n"
                    + "Sub Total: " + rs.getDouble("subTotal"));
        }
        
        rs.close();
        stmt.close();
    } catch (SQLException u) {
        throw new RuntimeException(u);
    }
}
}
