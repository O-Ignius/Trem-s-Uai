/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.model.dao;
import ecommerce.model.entity.Item;
import ecommerce.model.entity.Carrinho;
import ecommerce.model.entity.Produto;


//controller
import ecommerce.controller.EcommerceController;

/**
 *
 * @author Andre
 */

import java.sql.*;

public class ItemDAO {
    private EcommerceController ecommerceController = new EcommerceController(); 
    
    public ItemDAO() {
    }

    // Método para salvar um novo Item
    public void salvar(Item item, Connection connection) {
        Carrinho carrinho = ecommerceController.buscaCarrinhoAtual(item.getCarrinho().getCliente().getId(), connection);
        Produto produto = ecommerceController.getProduto(item.getProduto().getId(), connection);
        
        item.setCarrinho(carrinho);
        item.setProduto(produto);
        
        String sql = "INSERT INTO item (quantidadeItem, subTotal, produto_id, carrinho_id) VALUES (?, ?, ?, ?)";
        
        item.setSubTotal(item.getProduto().getValor() * item.getQuantidadeItem());
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidadeItem());
            stmt.setDouble(2, item.getSubTotal());
            stmt.setInt(3, item.getProduto().getId());
            stmt.setInt(4, item.getCarrinho().getId());
            stmt.execute();
            stmt.close();
            
            ecommerceController.alterarPrecoTotalCarrinho(item.getCarrinho(),connection);
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para editar um Item existente
    public void editar(Item item, Connection connection) {
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
    public void excluir(int id, Connection connection) {
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
    public int buscaItemPorIdCarrinho(int id, Connection connection) {
        String sql = "select p.nome, i.quantidadeItem, i.subTotal as subTotal from item i  inner join produto p on (p.id = i.produto_id) where i.carrinho_id =" + id + ";";
        int encontrado = 0;
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                encontrado++;
                System.out.println("\nProduto: " + rs.getString("nome") + "\n"
                        + "Quantidade: " + rs.getString("quantidadeItem") + "\n"
                        + "Sub Total: " + rs.getDouble("subTotal"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return encontrado;
    }
    
    public double somaValorItensCarrinho(int id, Connection connection) {
        String sql = "select sum(i.subTotal) as subTotal from item i where i.carrinho_id =" + id + ";";
        double total = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("subTotal");
            }

            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return total;
    }
}
