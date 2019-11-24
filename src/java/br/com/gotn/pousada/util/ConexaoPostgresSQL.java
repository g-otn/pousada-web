package br.com.gotn.pousada.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgresSQL {

    private static final String DRIVER = "org.postgresql.Driver";

    private static final String DATABASE_NAME = "es3_db";
    private static final String USER = "es3_usuario";
    private static final String USER_PASSWORD = "es3";

    private static final String IP = "localhost";
    private static final String PORT = "5432";
    private static final String URL = "jdbc:postgresql://" + IP + ":" + PORT + "/" + DATABASE_NAME;

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        System.out.println("--> ConexaoPostgresSQL#getConection");

        Class.forName(DRIVER);

        Connection conexao = DriverManager.getConnection(URL, USER, USER_PASSWORD);
        
        return conexao;
    }

}
