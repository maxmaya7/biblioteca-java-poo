package model;

import service.LivroService;
import service.UsuarioService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final Map<Usuario, Livro> emprestimos = new HashMap<>();

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Map<Usuario, Livro> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public void adicionarEmprestimo(Usuario usuario, Livro livro){
        this.emprestimos.put(usuario, livro);
    }



}
