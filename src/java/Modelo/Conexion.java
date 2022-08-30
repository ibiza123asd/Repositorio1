/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Brandon
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/prueba?zeroDateTimeBehavior=convertToNull";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static Connection getConection() {
        Connection con = null;
        System.out.println("Entrando al getConection");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Entrando a la conexion");
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (con == null) {
                System.out.println("No se establecio nada");
            }
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error 1");

        } catch (SQLException ex) {
            System.out.println("Error sql");
        }
        return con;
    }
}
