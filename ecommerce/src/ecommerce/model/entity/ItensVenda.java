package ecommerce.model.entity;

/**
 *
 * @author Andre
 */
public class ItensVenda {
    private Produto produto;
    private Venda venda;
    private int quantidade;
    private double precoPraticado;

    public ItensVenda() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoPraticado() {
        return precoPraticado;
    }

    public void setPrecoPraticado(double precoPraticado) {
        this.precoPraticado = precoPraticado;
    }
}
