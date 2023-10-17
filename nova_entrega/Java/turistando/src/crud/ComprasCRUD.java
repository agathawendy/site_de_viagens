package crud;

import java.util.Scanner;

import dao.ComprasDAO;
import modelos.Compras;
import modelos.Passagem;
import modelos.Usuario;

public class ComprasCRUD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ComprasDAO comprasDAO = new ComprasDAO();

        int opcao = 0, id = 0;

        String dataCompra = "";
        int idUsuario = 0;
        int idPassagem = 0;

        do {
            System.out.println("\n================================ COMPRAS ===================================\n");
            System.out.println("1-CRIAR    2-CONSULTAR    3-ATUALIZAR   4-DELETAR    5-CONSULTAR POR ID   0-SAIR");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a data da compra:");
                    dataCompra = s.nextLine();
                    System.out.println("Digite o ID do usuário:");
                    idUsuario = s.nextInt();
                    System.out.println("Digite o ID da passagem:");
                    idPassagem = s.nextInt();

                    Usuario usuario = new Usuario();
                    usuario.setId(idUsuario);

                    Passagem passagem = new Passagem();
                    passagem.setId(idPassagem);

                    Compras compra1 = new Compras(dataCompra, usuario, passagem);
                    comprasDAO.create(compra1);
                    break;

                case 2:
                    for (Compras compra : comprasDAO.read()) {
                        System.out.println(compra.toString());
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID da compra a ser atualizada:");
                    id = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite a nova data da compra:");
                    dataCompra = s.nextLine();
                    System.out.println("Digite o novo ID do usuário:");
                    idUsuario = s.nextInt();
                    System.out.println("Digite o novo ID da passagem:");
                    idPassagem = s.nextInt();

                    Usuario novoUsuario = new Usuario();
                    novoUsuario.setId(idUsuario);

                    Passagem novaPassagem = new Passagem();
                    novaPassagem.setId(idPassagem);

                    Compras compra2 = new Compras(id, dataCompra, novoUsuario, novaPassagem);
                    comprasDAO.update(compra2);
                    break;

                case 4:
                    System.out.println("Digite o ID da compra a ser deletada:");
                    id = s.nextInt();
                    s.nextLine();

                    comprasDAO.delete(id);
                    break;

                case 5:
                    System.out.println("Digite o ID da compra a ser consultada:");
                    id = s.nextInt();
                    s.nextLine();

                    Compras compra3 = comprasDAO.readById(id);
                    if (compra3 != null) {
                        System.out.println(compra3.toString());
                    } else {
                        System.out.println("Compra não encontrada.");
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
