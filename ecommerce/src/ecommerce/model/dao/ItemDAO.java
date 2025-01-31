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
    private Connection connection;
    private EcommerceController ecommerceController = new EcommerceController(); 
    
    public ItemDAO() {
        connection = new Conexao().getConnection();
    }

    // Método para salvar um novo Item
    public void salvar(Item item) {
        Carrinho carrinho = ecommerceController.buscaCarrinhoAtual(item.getCarrinho().getCliente().getId());
        Produto produto = ecommerceController.getProduto(item.getProduto().getId());
        
        item.setCarrinho(carrinho);
        item.setProduto(produto);
        
        String sql = "INSERT INTO item (quantidadeItem, subTotal, produto_id, carrinho_id) VALUES (?, ?, ?, ?)";
        
        item.setSubTotal(item.getProduto().getValor() * item.getQuantidade());
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidade());
            stmt.setDouble(2, item.getSubTotal());
            stmt.setInt(3, item.getProduto().getId());
            stmt.setInt(4, item.getCarrinho().getId());
            stmt.execute();
            stmt.close();
            
            ecommerceController.alterarPrecoTotalCarrinho(item.getCarrinho());
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para editar um Item existente
    public void editar(Item item) {
        String sql = "UPDATE item SET quantidadeItem = ?, subTotal = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidade());
            stmt.setDouble(2, item.getSubTotal());
            stmt.setInt(3, item.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Item getItem(int id){
        Item item = new Item();
        String sql = "SELECT * FROM item WHERE id = ?";
        Carrinho carrinho = new Carrinho();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                item = new Item();
                item.setId(rs.getInt("id"));
                item.setQuantidade(rs.getInt("quantidadeItem"));
                item.setSubTotal(rs.getDouble("subTotal"));
                item.setProduto(ecommerceController.getProduto(rs.getInt("produto_id"))); 
                item.setCarrinho(carrinho); 
                carrinho.setId(rs.getInt("carrinho_id"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return item;
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
    public int buscaItemPorIdCarrinho(int id) {
        String sql = "select i.id, p.nome, i.quantidadeItem, i.subTotal, p.estoque, p.valor from item i  inner join produto p on (p.id = i.produto_id) where i.carrinho_id =" + id + ";";
        Item item = new Item();
        int encontrado = 0;
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                encontrado++;
                item.setId(rs.getInt("i.id"));
                item.setQuantidade(rs.getInt("quantidadeItem"));
                
                if(rs.getInt("estoque") < item.getQuantidade()){
                    System.err.println("Quantidade do item excede o estoque, valor alterado!");
                    item.setQuantidade(rs.getInt("p.estoque"));
                    item.setSubTotal(rs.getDouble("p.valor") * item.getQuantidade());
                    ecommerceController.editarItem(item);
                } 
                
                System.out.println("\nProduto: " + rs.getString("nome") + "\n"
                            + "Quantidade: " + item.getQuantidade() + "\n"
                            + "Sub Total: " + item.getSubTotal());
            }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return encontrado;
    }
    
    public double somaValorItensCarrinho(int id) {
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
    
    public void editaEstoqueItemPorIdCarrinho(int id) {
        String sql = "select i.id as idItem, p.id as idProduto from item i inner join produto p on (p.id = i.produto_id) where i.carrinho_id =" + id + ";";
        Produto produto;
        Item item;
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                produto = ecommerceController.getProduto(rs.getInt("idProduto"));
                item = ecommerceController.getItem(id);
                
                produto.setEstoque(produto.getEstoque() - item.getQuantidade());
                ecommerceController.editarQuantidadeEstoque(produto);
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
