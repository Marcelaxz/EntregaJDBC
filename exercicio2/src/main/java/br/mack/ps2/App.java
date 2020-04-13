package br.mack.ps2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UsuarioDAOMySQL mysqlDAO = new UsuarioDAOMySQL();
        Menu menu = new Menu(mysqlDAO);
        menu.iniciar();
    }
}
