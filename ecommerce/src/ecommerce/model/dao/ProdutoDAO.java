/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.model.dao;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;

/**
 *
 * @author Andre
 */
import java.sql.*;

//controller
import ecommerce.controller.EcommerceController;

public class ProdutoDAO {
    private Connection connection;
    private EcommerceController ecommerceController = new EcommerceController(); 

    public ProdutoDAO() {
        connection = new Conexao().getConnection();
    }

    // Método para salvar um novo Produto
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, valor, estoque, vendedor_id) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getValor());
            stmt.setInt(4, produto.getEstoque());
            stmt.setInt(5, produto.getVendedor().getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para editar um Produto existente
    public void editar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, valor = ?, estoque = ?, vendedor_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getValor());
            stmt.setInt(4, produto.getEstoque());
            stmt.setInt(5, produto.getVendedor().getId());
            stmt.setInt(6, produto.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para excluir um Produto pelo id
    public void excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para buscar um Produto pelo nome
    public Produto buscaPorNome(String nome) {
        Produto produto = null;
        VendedorDAO vendedorDAO = null;
        Vendedor vendedor = null;
        
        String sql = "select * from produto p where p.nome like '% " + nome + "%';";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            vendedor = vendedorDAO.get(rs.getInt("vendedor_id"));
            
            System.out.println("\nNome: " + rs.getString("nome") + "\n"
                    + "Descrição: " + rs.getString("descricao") + "\n"
                    + "Valor: " + rs.getDouble("valor") + "\n"
                    + "Estoque: " + rs.getInt("estoque") + "\n"
                    + "Vendedor: " + vendedor.getNome());
        }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return produto;
    }
    
    public Produto getProduto(int id) {
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getDouble("valor"));
                produto.setEstoque(rs.getInt("estoque"));
                
                produto.setVendedor(ecommerceController.getVendedor(rs.getInt("vendedor_id")));
            }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return produto;
    }
}