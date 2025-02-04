package ecommerce.model.entity;

/**
 *
 * @author Andre
 */
public class ItensCarrinho {
    private Carrinho carrinho;
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    public ItensCarrinho() {
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double calcularTotal() {
        return this.quantidade * this.precoUnitario;
    }
    
    
}
