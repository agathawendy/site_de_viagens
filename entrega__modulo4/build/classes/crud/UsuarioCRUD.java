package crud;

import java.util.Scanner;

import dao.UsuarioDAO;
import modelos.Usuario;

public class UsuarioCRUD {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        int opcao = 0, id = 0;

        String nome = "", email = "", senha = "";

        do {

            System.out.println("\n================================ USUARIO ===================================\n");
            System.out.println("1-CRIAR    2-CONSULTAR    3-ATUALIZAR   4-DELETAR    5-CONSULTAR POR ID   0-SAIR");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    nome = s.nextLine();
                    System.out.println("Digite o email:");
                    email = s.nextLine();
                    System.out.println("Digite a senha:");
                    senha = s.nextLine();

                    Usuario usuario1 = new Usuario(nome, email, senha);
                    usuarioDAO.create(usuario1);
                    break;

                case 2:
                    for (Usuario u : usuarioDAO.read()) {
                        System.out.println(u.toString());
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID do usuário a ser atualizado:");
                    id = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite o nome:");
                    nome = s.nextLine();
                    System.out.println("Digite o email:");
                    email = s.nextLine();
                    System.out.println("Digite a senha:");
                    senha = s.nextLine();

                    Usuario usuario2 = new Usuario(id, nome, email, senha);
                    usuarioDAO.update(usuario2);
                    break;

                case 4:
                    System.out.println("Digite o ID do usuário a ser deletado:");
                    id = s.nextInt();
                    s.nextLine();

                    usuarioDAO.delete(id);
                    break;

                case 5:
                    System.out.println("Digite o ID do usuário a ser consultado:");
                    id = s.nextInt();
                    s.nextLine();

                    Usuario usuario3 = usuarioDAO.readById(id);
                    if (usuario3 != null) {
                        System.out.println(usuario3.toString());
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        System.out.println("Até mais!");

        
        s.close();
    }
}
