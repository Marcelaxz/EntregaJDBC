package br.mack.ps2;
import java.sql.*;

public class UsuarioDAOMySQL  implements UsuarioDAO{
    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Usuario usuario) {
        String createSQL = "INSERT INTO contas VALUES (?, ?)";


        Connection conexao = mysql.getConnection();

        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setInt(1, usuario.getN_conta());
            stm.setDouble(2, usuario.getSaldo());

            int registros = stm.executeUpdate();

           return  registros > 0 ? true : false;

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
}
