/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce.model.entity;
import java.util.ArrayList;
/**
 *
 * @author Andre
 */
public class Carrinho {
    private int id;
    boolean fechado;
    private Cliente cliente;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isFechado() {
        return fechado;
    }
    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
