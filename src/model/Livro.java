package model;

public class Livro {
    private int id;
    private String nome;
    private String autor;
    private String genero;
    private int numeroDePaginas;
    private int anoDePublicacao;
    private boolean disponivel;


    public Livro(int id, String nome, String autor, String genero, int numeroDePaginas, int anoDePublicacao) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.numeroDePaginas = numeroDePaginas;
        this.anoDePublicacao = anoDePublicacao;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro: " +
                "id = " + id +
                ", nome = " + nome +
                ", autor = " + autor +
                ", genero = " + genero +
                ", numeroDePaginas = " + numeroDePaginas +
                ", anoDePublicacao = " + anoDePublicacao +
                ", disponivel = " + disponivel;
    }
}
