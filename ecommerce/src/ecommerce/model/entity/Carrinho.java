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
    private ArrayList<Item> itens = new ArrayList<>();
    
    public ArrayList<Item> getItens() {
        return itens;
    }

    public void addItem(Item item) {
        this.itens.add(item);
    }
}
