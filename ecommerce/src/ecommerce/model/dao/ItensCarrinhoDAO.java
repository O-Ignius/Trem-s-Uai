package ecommerce.model.dao;

import ecommerce.model.entity.ItensCarrinho;
import ecommerce.model.entity.Produto;
import ecommerce.model.entity.Carrinho;
import ecommerce.controller.EcommerceController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItensCarrinhoDAO {
    private EcommerceController ecommerceController = new EcommerceController();

    public ItensCarrinhoDAO() {
    }

    // Método para adicionar um item ao carrinho
    public void adicionarItem(ItensCarrinho item, Connection connection) {
        String sql = "INSERT INTO itenscarrinho (carrinho_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getCarrinho().getId());
            stmt.setInt(2, item.getProduto().getId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPrecoUnitario());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    // Método para remover um item do carrinho
    public void removerItem(int id, Connection connection) {
        String sql = "DELETE FROM itenscarrinho WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

   
    // Método para atualizar a quantidade de um item no carrinho
    public void atualizarQuantidade(ItensCarrinho item, Connection connection) {
        String sql = "UPDATE itenscarrinho SET quantidade = ? WHERE carrinho_id = ? AND produto_id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, item.getQuantidade());
            stmt.setInt(2, item.getCarrinho().getId());  // Acesso ao id do carrinho
            stmt.setInt(3, item.getProduto().getId());   // Acesso ao id do produto
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }


    // Método para obter todos os itens de um carrinho
    public List<ItensCarrinho> getItensPorCarrinho(int carrinhoId, Connection connection) {
        List<ItensCarrinho> itens = new ArrayList<>();
        String sql = "SELECT * FROM ecommerce.itensCarrinho WHERE carrinho_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, carrinhoId);
            ResultSet rs = stmt.executeQuery();

            // Recupera o carrinho associado ao carrinhoId informado.
            CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
            Carrinho carrinho = carrinhoDAO.getCarrinhoById(carrinhoId, connection);


            while (rs.next()) {
                ItensCarrinho item = new ItensCarrinho();

                // Como o carrinho já foi recuperado, basta associá-lo ao item.
                item.setCarrinho(carrinho);

                // Recupera o produto associado ao item (assumindo que existe o método getProduto no ecommerceController)
                int produtoId = rs.getInt("produto_id");
                item.setProduto(ecommerceController.getProduto(produtoId, connection));

                item.setQuantidade(rs.getInt("quantidade"));
                item.setPrecoUnitario(rs.getDouble("preco_unitario"));
                itens.add(item);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return itens;
    }
    

}
