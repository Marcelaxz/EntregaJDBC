package br.mack.ps2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOMySQL implements UsuarioDAO {
    String deleteSQL = "DELETE FROM contas WHERE n_conta=?";
    private String readSQL = "SELECT * FROM contas";
    final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean delete(int opc) {

        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setInt(1, opc);

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void read() {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                int n_conta = rs.getInt("n_conta");
                Double saldo = rs.getDouble("saldo");
                System.out.println("\nNúmero da Conta: " + n_conta + "\nSaldo: " + saldo);
            }
            rs.close();
            conexao.close();

        }  catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}







