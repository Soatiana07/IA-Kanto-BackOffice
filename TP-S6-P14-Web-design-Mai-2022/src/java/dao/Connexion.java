/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Kanto
 */
public class Connexion {
    public static Connection getConnexion() throws Exception{
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://containers-us-west-82.railway.app:7243/railway","postgres","VUSKx1FRKXrYYAeQXDw4");

        } catch (Exception e) {
            throw e;
        }
        return conn;
    }
}
