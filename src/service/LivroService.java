package service;

import model.Biblioteca;
import model.Livro;

import java.util.List;
import java.util.Scanner;

public class LivroService {
    private final Scanner sc = new Scanner(System.in);
    private final Biblioteca biblioteca;

    public LivroService(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void cadastraLivro() {
        System.out.println("Digite o ID do livro a ser adicionado: ");
        int idLivro = sc.nextInt();

        boolean idCadastrado = biblioteca.getLivros().stream()
                        .anyMatch(l -> l.getId() == idLivro);
        if (idCadastrado){
            System.out.println("Já existe um livro com esse ID!\n");
            return;
        }

        sc.nextLine();
        System.out.println("Digite o nome completo do livro a ser adicionado: ");
        String nomeLivro = sc.nextLine();
        System.out.println("Digite o nome do autor do livro:");
        String autorLivro = sc.nextLine();
        System.out.println("Digite o gênero do livro: ");
        String generoLivro = sc.nextLine();
        System.out.println("Digite o número de páginas do livro: ");
        int numeroPaginas = sc.nextInt();
        System.out.println("Digite o ano de publicação do livro: ");
        int anoPublicacao = sc.nextInt();

        Livro livro = new Livro(idLivro, nomeLivro, autorLivro, generoLivro, numeroPaginas, anoPublicacao);
        biblioteca.adicionarLivro(livro);

        System.out.println("Livro cadastrado com sucesso!\n");
    }

    public void listaLivros() {
        List<Livro> livros = biblioteca.getLivros();
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados!\n");
            return;
        }
        System.out.println("Livros cadastrados: ");
        for (Livro livro : livros) {
            System.out.println("ID: " + livro.getId());
            System.out.println("Nome: " + livro.getNome());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Gênero: " + livro.getGenero());
            System.out.println("Páginas: " + livro.getNumeroDePaginas());
            System.out.println("Ano: " + livro.getAnoDePublicacao());
            System.out.println("--------------------------");
        }

    }
}
