/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;

import ecommerce.model.entity.Cliente;
import ecommerce.model.entity.Carrinho;

//controller
import ecommerce.controller.EcommerceController;

/**
 *
 * @author Andre
 */
public class CarrinhoDAO {
    private EcommerceController ecommerceController = new EcommerceController();
    
    public CarrinhoDAO() {
    }

    // Método para salvar um novo Carrinho
    public void salvar(Cliente cliente, Connection connection) {
        String sql = "INSERT INTO carrinho (cliente_id, fechado) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.setBoolean(2, false);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public Carrinho buscaCarrinhoAtual(int id_Cliente, Connection connection){
        Carrinho carrinho = new Carrinho();  
        Cliente cliente = new Cliente();
        cliente.setId(id_Cliente);
        
        String sql = "select c.id, c.precoTotal, c.dataPedido, c.tipoPagamento from carrinho c where c.cliente_id =" + id_Cliente +" and c.fechado = false;";
                                  
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                carrinho.setId(rs.getInt("id"));
                carrinho.setFechado(false);
                carrinho.setPrecoTotal(rs.getDouble("precoTotal"));
                carrinho.setDataPedido(rs.getDate("dataPedido"));
                carrinho.setTipoPagamento(rs.getInt("tipoPagamento"));
                carrinho.setCliente(cliente);
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return carrinho;
    }
    
    public void alterarPrecoTotalCarrinho(Carrinho carrinho, Connection connection) {
        String sql = "UPDATE carrinho SET precoTotal = ? WHERE carrinho.id ="+ carrinho.getId();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            double total = ecommerceController.somaValorItensCarrinho(carrinho.getId(), connection);
            System.out.println("VALOR TOTAL CARRINHO: " + total);
            stmt.setDouble(1, total);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void finalizarCarrinho(Carrinho carrinho, Connection connection) {
        String sql = "UPDATE carrinho SET fechado = ?, dataPedido = ?, tipoPagamento = ?, cliente_id = ? WHERE id = ?";
        Date dataAtual = new Date(System.currentTimeMillis());

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setDate(2, dataAtual);
            stmt.setInt(3, carrinho.getTipoPagamento());
            stmt.setInt(4, carrinho.getCliente().getId());
            stmt.setInt(5, carrinho.getId());

            stmt.execute();
            stmt.close();

            ecommerceController.alterarPrecoTotalCarrinho(carrinho, connection);
            ecommerceController.editaEstoqueItemPorIdCarrinho(carrinho.getId(), connection);
            ecommerceController.salvarCarrinho(carrinho.getCliente(), connection);
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    public void buscaPedidosFinalizados(int idCliente, Connection connection){
        String sql = "select c.id from carrinho c where c.cliente_id =" + idCliente + " and c.fechado = true;";
        Carrinho carrinho = new Carrinho();
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                carrinho.setId(rs.getInt("id"));
                ecommerceController.buscaItemPorIdCarrinho(carrinho, connection);
            }

            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }                                        
}
