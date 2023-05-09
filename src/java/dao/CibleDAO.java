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
import java.util.ArrayList;
import model.Cible;

/**
 *
 * @author Kanto
 */
public class CibleDAO {
    Connexion conn = new Connexion();

    public ArrayList<Cible> listeCible() throws Exception {
        ArrayList<Cible> list = null;
        Connection connex = null;
        Statement stmt = null;
        ResultSet req = null;
        String sql = null;
        try {
            connex = conn.getConnexion();
            stmt = connex.createStatement();
            sql = "select * from cible";
            req = stmt.executeQuery(sql);
            list = new ArrayList<>();
            while (req.next()) {
                Cible m = new Cible();
                m.setId(req.getInt("id"));
                m.setCible(req.getString("cible"));
                list.add(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            stmt.close();
            connex.close();
        }
        return list;
    }
}
