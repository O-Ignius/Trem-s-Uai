package ecommerce.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Carrinho {
    private int id;
    private Cliente cliente;
    private Date dataCriacao;
    private List<ItensCarrinho> itens = new ArrayList<>();
    public Carrinho() {
        this.dataCriacao = new Date(); // Define a data de criação ao instanciar
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public void setItens(List<ItensCarrinho> itens) {
        this.itens = itens;
    }
    
    public List<ItensCarrinho> getItens() {
        return itens;
    }
    
    
}
