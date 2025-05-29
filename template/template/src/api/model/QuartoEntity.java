package api.model;

public class QuartoEntity extends BaseEntity {
    private String nome;
    private String descricao;
    private double preco;

       public QuartoEntity(int id, String nome, String descricao, double preco) {
        super(id);
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public QuartoEntity() {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
