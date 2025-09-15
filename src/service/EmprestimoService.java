package service;

import model.Biblioteca;
import model.Livro;
import model.Usuario;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class EmprestimoService {
    private final Scanner sc = new Scanner(System.in);
    private final Biblioteca biblioteca;
    private final LivroService livroService;
    private final UsuarioService usuarioService;

    public EmprestimoService(Biblioteca biblioteca, LivroService livroService, UsuarioService usuarioService) {
        this.biblioteca = biblioteca;
        this.livroService = livroService;
        this.usuarioService = usuarioService;
    }

    public void listaEmprestimos(){
        Map<Usuario, Livro> emprestimos = biblioteca.getEmprestimos();

        emprestimos.forEach((usuario, livro) -> {
            System.out.println("Usuário: " + usuario.getNome());
            System.out.println("Livro emprestado: " + livro.getNome());
            System.out.println("---------------------");
        });
    }

    public void emprestaLivro() {
        Livro livro = buscaLivro();
        if (livro == null) {
            return;
        }
        Usuario usuario = buscaUsuario();

        if (usuario == null) {
            return;
        }

        if (!validaEmprestimo(usuario, livro)) {
            return;
        }

        realizaEmprestimo(usuario, livro);
    }

    private void realizaEmprestimo(Usuario usuario, Livro livro) {
        usuario.setPossuiLivroEmprestado(true);
        livro.setDisponivel(false);
        System.out.println("Livro emprestado com sucesso!\n");
        biblioteca.adicionarEmprestimo(usuario, livro);
    }

    private boolean validaEmprestimo(Usuario usuario, Livro livro) {
        if (usuario.isPossuiLivroEmprestado()) {
            System.out.println("O usuário já possui um livro emprestado!\n");
            return false;
        }
        if (!livro.isDisponivel()) {
            System.out.println("O livro não está disponível!\n");
            return false;
        }
        return true;
    }

    private Usuario buscaUsuario() {
        if (biblioteca.getUsuarios().isEmpty()) {
            System.out.println("Não há usuários cadastrados.\n");
            return null;
        }

        System.out.println("Usuários disponíveis para empréstimo: ");
        usuarioService.listaUsuarios();
        System.out.println("Digite o ID do usuário que receberá o livro: ");
        int idBuscado = sc.nextInt();
        Optional<Usuario> usuario = biblioteca.getUsuarios().stream()
                .filter(u -> u.getId() == idBuscado)
                .findFirst();
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            System.out.println("Usuário não encontrado!\n");
            return null;
        }
    }

    private Livro buscaLivro() {
        if (biblioteca.getLivros().isEmpty()) {
            System.out.println("Não há livros disponíveis para empréstimo.\n");
            return null;
        }
        System.out.println("Livros disponíveis para empréstimo: ");
        livroService.listaLivros();
        System.out.println("Digite o nome do livro que você quer emprestar: ");
        String livroBuscado = sc.nextLine();
        Optional<Livro> livro = biblioteca.getLivros().stream()
                .filter(l -> l.getNome().toLowerCase().contains(livroBuscado.toLowerCase()))
                .findAny();
        if (livro.isPresent()) {
            return livro.get();
        } else {
            System.out.println("Livro não encontrado!");
            return null;
        }
    }

}
