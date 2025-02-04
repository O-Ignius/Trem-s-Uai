package ecommerce.model.dao;

import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Vendedor;
import ecommerce.controller.EcommerceController;

import java.sql.*;

public class ProdutoDAO {
    private EcommerceController ecommerceController = new EcommerceController();

    public ProdutoDAO() {
    }

    // Método para salvar um novo Produto
    public void salvar(Produto produto, Connection connection) {
        String sql = "INSERT INTO produto (nome, descricao, valor_atual, custo_atual, estoque, vendedor_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getValorAtual());
            stmt.setDouble(4, produto.getCustoAtual()); 
            stmt.setInt(5, produto.getEstoque());
            stmt.setInt(6, produto.getVendedor().getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para editar um Produto existente
    public void editar(Produto produto, Connection connection) {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, valor_atual = ?, custo_atual = ?, estoque = ?, vendedor_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getValorAtual()); 
            stmt.setDouble(4, produto.getCustoAtual()); 
            stmt.setInt(5, produto.getEstoque());
            stmt.setInt(6, produto.getVendedor().getId());
            stmt.setInt(7, produto.getId());
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
        Vendedor vendedor = new Vendedor();
        int encontrado = 0;

        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                encontrado++;
                vendedor = ecommerceController.getVendedor(rs.getInt("vendedor_id"), connection);

                System.out.println("Id: " + rs.getInt("id") + "\n"
                        + "Nome: " + rs.getString("nome") + "\n"
                        + "Descrição: " + rs.getString("descricao") + "\n"
                        + "Valor Atual: " + rs.getDouble("valor_atual") + "\n"
                        + "Custo Atual: " + rs.getDouble("custo_atual") + "\n"
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

        String sql = "SELECT * FROM produto WHERE vendedor_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                vendedor = vendedorDAO.get(id, connection);

                System.out.println("\nNome: " + rs.getString("nome") + "\n"
                        + "Descrição: " + rs.getString("descricao") + "\n"
                        + "Valor Atual: " + rs.getDouble("valor_atual") + "\n"
                        + "Custo Atual: " + rs.getDouble("custo_atual") + "\n"
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
                produto.setValorAtual(rs.getDouble("valor_atual")); 
                produto.setCustoAtual(rs.getDouble("custo_atual")); 
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
        String sql = "UPDATE produto SET estoque = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getEstoque());
            stmt.setInt(2, produto.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
