package model;

public class Usuario {
    private int id;
    private String nome;
    private boolean possuiLivroEmprestado;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.setPossuiLivroEmprestado(false);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPossuiLivroEmprestado() {
        return possuiLivroEmprestado;
    }

    public void setPossuiLivroEmprestado(boolean possuiLivroEmprestado) {
        this.possuiLivroEmprestado = possuiLivroEmprestado;
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "id = " + id +
                ", nome = " + nome;
    }
}
