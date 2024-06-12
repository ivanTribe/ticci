public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
    private String codigo;

    public Produto(String nome, String descricao, double preco, int quantidade, String codigo) throws IllegalArgumentException {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigo = codigo;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws IllegalArgumentException {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws IllegalArgumentException {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void exibir2(){
    System.out.println("<--------------------------------->");
        System.out.println("Titulo do livro: " + nome);
        System.out.println("Descrição do livro: " + descricao);
        System.out.println("Preço do livro: " + preco);
        System.out.println("Quantidade disponivel: " + quantidade);
        System.out.println("Codigo do livro: " + codigo);
        System.out.println("<--------------------------------->");
        }
}
