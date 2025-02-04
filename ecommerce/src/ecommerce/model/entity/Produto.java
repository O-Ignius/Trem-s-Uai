    package ecommerce.model.entity;

    /**
     *
     * @author Andre
     */
    public class Produto {
        private int id;
        private String nome;
        private String descricao;
        private double valorAtual; 
        private double custoAtual;
        private int estoque;
        private Vendedor vendedor;

        public Produto() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getValorAtual() {
            return valorAtual;
        }

        public void setValorAtual(double valorAtual) {
            this.valorAtual = valorAtual;
        }

        public double getCustoAtual() {
            return custoAtual;
        }

        public void setCustoAtual(double custoAtual) {
            this.custoAtual = custoAtual;
        }

        public int getEstoque() {
            return estoque;
        }

        public void setEstoque(int estoque) {
            this.estoque = estoque;
        }

        public Vendedor getVendedor() {
            return vendedor;
        }

        public void setVendedor(Vendedor vendedor) {
            this.vendedor = vendedor;
        }
    }
