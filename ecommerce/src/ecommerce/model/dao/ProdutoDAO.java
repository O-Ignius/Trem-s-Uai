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
    private EcommerceController ecommerceController = new EcommerceController();

    public ProdutoDAO() {
    }

    // Método para salvar um novo Produto
    public void salvar(Produto produto, Connection connection) {
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
    public void editar(Produto produto, Connection connection) {
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
    public void excluir(int id, Connection connection) {
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
    public int buscaPorNome(String nome, Connection connection) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        Vendedor vendedor = new Vendedor();
        int encontrado = 0;

        String sql = "select * from produto p where p.nome like '%" + nome + "%';";
        System.out.println("\n");
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                encontrado++;
                vendedor = ecommerceController.getVendedor(rs.getInt("vendedor_id"), connection);

                System.out.println("Id: " + rs.getInt("id") + "\n"
                        + "Nome: " + rs.getString("nome") + "\n"
                        + "Descrição: " + rs.getString("descricao") + "\n"
                        + "Valor: " + rs.getDouble("valor") + "\n"
                        + "Estoque: " + rs.getInt("estoque") + "\n"
                        + "Vendedor: " + vendedor.getNome() + "\n");
            }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return encontrado;
    }

    // Método para buscar Produtos pelo Vendendor
    public void buscaProdutosPorIdVendedor(int id, Connection connection) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        Vendedor vendedor = new Vendedor();

        String sql = "select * from produto p where p.vendedor_id = " + id + ";";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vendedor = vendedorDAO.get(id, connection);

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
    }

    public Produto getProduto(int id, Connection connection) {
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

                produto.setVendedor(ecommerceController.getVendedor(rs.getInt("vendedor_id"), connection));
            }
            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return produto;
    }
    
    public void editarQuantidadeEstoque(Produto produto, Connection connection) {
        String sql = "UPDATE produto SET estoque = " + produto.getEstoque() +" WHERE id =" + produto.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
