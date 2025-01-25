/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecommerce.model.entity.Cliente;
/**
 *
 * @author Andre
 */
public class CarrinhoDAO {
    private Connection connection;

    public CarrinhoDAO() {
        connection = new Conexao().getConnection();
    }

    // Método para salvar um novo Carrinho
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO carrinho (cliente_id) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
