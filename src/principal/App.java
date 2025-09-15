package principal;

import model.Biblioteca;
import service.EmprestimoService;
import service.LivroService;
import service.UsuarioService;

import java.util.*;

public class App {
    private final Scanner sc = new Scanner(System.in);
    private final Biblioteca biblioteca = new Biblioteca();
    private final UsuarioService usuarioService = new UsuarioService(biblioteca);
    private final LivroService livroService = new LivroService(biblioteca);
    private final EmprestimoService emprestimoService = new EmprestimoService(biblioteca, livroService, usuarioService);


    public void exibeMenu(){

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("""
                O que você quer fazer?
                1 - Adicionar Usuário
                2 - Adicionar Livro
                3 - Listar Usuários
                4 - Listar Livros
                5-  Emprestar Livro
                6 - Listar Empréstimos
                7 - Sair
                """);
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    usuarioService.cadastraUsuario();
                    break;
                case 2:
                    livroService.cadastraLivro();
                    break;
                case 3:
                    usuarioService.listaUsuarios();
                    break;
                case 4:
                    livroService.listaLivros();
                    break;
                case 5:
                    emprestimoService.emprestaLivro();
                    break;
                case 6:
                    emprestimoService.listaEmprestimos();
                    break;
            }
        }

    }
}
