/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kanto
 */
public class AdminDAO {
    Connexion conn = new Connexion();

    public int loginAdmin(String nom, String mdp) throws SQLException, Exception {
        Connection connex = null;
        Statement stmt = null;
        ResultSet req = null;
        int nombre = 0;
        try {
            connex = conn.getConnexion();
            stmt = connex.createStatement();
            String sql = " select  count(*) from admin where nom='" + nom + "' and mdp='" + mdp + "';";
            req = stmt.executeQuery(sql);
            while (req.next()) {
                nombre = stmt.getResultSet().getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            stmt.close();
            connex.close();
        }
        return nombre;
    }
    
     public int login(String nom, String mdp) throws SQLException, Exception {
        Connection connex = null;
        Statement stmt = null;
        ResultSet req = null;
        int nombre = 0;
        try {
            connex = conn.getConnexion();
            stmt = connex.createStatement();
            String sql = " select  count(*) from admin where nom='" + nom + "' and mdp='" + mdp + "';";
            req = stmt.executeQuery(sql);
            while (req.next()) {
                nombre = stmt.getResultSet().getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            stmt.close();
            connex.close();
        }
        return nombre;
    }

    public int getIdAdmin(String nom, String mdp) throws SQLException, Exception {
        Connection connex = null;
        Statement stmt = null;
        ResultSet req = null;
        int nombre = 0;
        try {
            connex = conn.getConnexion();
            stmt = connex.createStatement();
            String sql = " select  id from admin where nom='" + nom + "' and mdp='" + mdp + "';";
            req = stmt.executeQuery(sql);
            while (req.next()) {
                nombre = stmt.getResultSet().getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            stmt.close();
            connex.close();
        }
        return nombre;
    }
}
