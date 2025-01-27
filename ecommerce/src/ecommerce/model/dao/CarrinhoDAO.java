/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Carrinho;

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
        String sql = "INSERT INTO carrinho (cliente_id, fechado) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.setInt(2, 0);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Carrinho buscaCarrinhoAtual(int id_Cliente){
        String sql = "select c.id from carrinho c where c.cliente_id =" + id_Cliente + "and c.fechado = 0;";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(id_Cliente);
                
                Carrinho carrinho = new Carrinho();
                carrinho.setId(rs.getInt("id"));
                carrinho.setFechado(false);
                carrinho.setCliente(cliente);
                
                return carrinho;
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return null;
    }
}
