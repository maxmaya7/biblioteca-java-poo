package service;

import model.Biblioteca;
import model.Usuario;

import java.util.List;
import java.util.Scanner;

public class UsuarioService {
    private final Scanner sc = new Scanner(System.in);
    private final Biblioteca biblioteca;

    public UsuarioService(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void cadastraUsuario(){
        System.out.println("Digite o ID do usuário a ser adicionado: ");
        int idUsuario = sc.nextInt();

        boolean idCadastrado = biblioteca.getUsuarios().stream()
                        .anyMatch(u -> u.getId() == idUsuario);
        if (idCadastrado){
            System.out.println("Já existe um usuário com esse ID!\n");
            return;
        }

        sc.nextLine();
        System.out.println("Digite o nome completo do usuário a ser adicionado: ");
        String nomeUsuario = sc.nextLine();
        Usuario usuario = new Usuario(idUsuario, nomeUsuario);
        biblioteca.adicionarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso!\n");
    }

    public void listaUsuarios(){
        List<Usuario> lista = biblioteca.getUsuarios();
        if (lista.isEmpty()){
            System.out.println("Não há usuários cadastrados!\n");
            return;
        }
        System.out.println("Usuários cadastrados: ");
        for (Usuario usuario : lista) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("--------------");
        }

    }
}
