package br.mack.ps2;
import java.sql.*;
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
            System.out.println("\t1. Adicionar Registro");
            System.out.println("\t2. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    System.out.println("Operação finalizada");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 2);
    }

    private void create() {
        Usuario usuario = new Usuario();

        System.out.println("\n----- Conta Bancária -----");

        System.out.print("\nInforme o número da conta: ");
        usuario.setN_conta(in.nextInt());
        in.nextLine();

        System.out.print("Informe o saldo: ");
        usuario.setSaldo(in.nextDouble());

        if (dao.create(usuario)) {
            System.out.println("Dados adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar os dados");
        }
    }
}
