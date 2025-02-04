package ecommerce.model.dao;

import ecommerce.model.entity.ItensVenda;
import ecommerce.model.entity.Venda;
import ecommerce.model.entity.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItensVendaDAO {

    // Método para salvar um item de venda
    public void salvar(ItensVenda item, Connection connection) {
        String sql = "INSERT INTO itensvenda (venda_id, produto_id, quantidade, preco_praticado) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, item.getVenda().getId());
            stmt.setInt(2, item.getProduto().getId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPrecoPraticado());
            stmt.executeUpdate();

            // Fechando os recursos
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para editar um item de venda existente
    public void editar(ItensVenda item, Connection connection) {
        String sql = "UPDATE itens_venda SET quantidade = ?, preco_praticado = ? WHERE venda_id = ? AND produto_id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidade());
            stmt.setDouble(2, item.getPrecoPraticado());
            stmt.setInt(3, item.getVenda().getId());
            stmt.setInt(4, item.getProduto().getId());
            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para excluir um item de venda
    public void excluir(int vendaId, int produtoId, Connection connection) {
        String sql = "DELETE FROM itens_venda WHERE venda_id = ? AND produto_id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, vendaId);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para listar os itens de venda de uma venda específica
    public List<ItensVenda> listarItensVenda(int vendaId, Connection connection) {
        List<ItensVenda> itensVenda = new ArrayList<>();
        String sql = "SELECT * FROM itens_venda WHERE venda_id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, vendaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItensVenda item = new ItensVenda();
                
                // Recuperando o produto
                int produtoId = rs.getInt("produto_id");
                Produto produto = new Produto();
                produto.setId(produtoId);

                // Atribuindo os dados ao item
                item.setProduto(produto);
                item.setVenda(new Venda());
                item.getVenda().setId(vendaId);
                item.setQuantidade(rs.getInt("quantidade"));
                item.setPrecoPraticado(rs.getDouble("preco_praticado"));
                
                itensVenda.add(item);
            }

            rs.close();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

        return itensVenda;
    }
}
