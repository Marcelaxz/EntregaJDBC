package br.mack.ps2;
import java.util.*;

public class Menu {
    UsuarioDAO dao;
    Scanner in;

    public Menu(UsuarioDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println("\n----- Menu ------");
            System.out.println("\t1. Deletar Registro");
            System.out.println("\t2. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1:
                    this.delete();
                    break;
                case 2:
                    System.out.println("Operação finalizada");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (opc != 2);
    }

    private void read() {
        System.out.println("\n ----- Usuários Registrados -----");
        dao.read();
    }

    private void delete() {
        while(true) {
            read();
            System.out.println("\nPara cancelar a operação, digite 1: ");
            int cnl = in.nextInt();
            if (cnl == 1) {
                break;
            }
            System.out.print("\nPara remover, digite o número da conta do usuário: ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc <= 0) {
                System.out.println("Esta opção não é válida!");
            } else {
                if (dao.delete(opc)) {
                    System.out.println("Usuário " + opc +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falha ao tentar remover");
                }
            }

        }
    }
}
