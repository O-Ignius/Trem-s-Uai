package ecommerce.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection connection;

    public Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados");
        try {
            Class.forName(DRIVER_MYSQL);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
