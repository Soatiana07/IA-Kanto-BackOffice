/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Contenu;
import model.V_contenu;
/**
 *
 * @author Kanto
 */
public class ContenuDAO {

    Connexion conn = new Connexion();

    public ArrayList<Contenu> listeContenu(int limit, int offset) throws Exception {
        ArrayList<Contenu> list = null;
        Connection connex = null;
        Statement stmt = null;
        ResultSet req = null;
        String sql = null;
        try {
            connex = conn.getConnexion();
            stmt = connex.createStatement();
            sql = "select * from contenu limit " + limit + " offset " + offset;
            req = stmt.executeQuery(sql);
            list = new ArrayList<>();
            while (req.next()) {
                Contenu c = new Contenu();
                c.setId(req.getInt("id"));
                c.setDate(req.getDate("date"));
                c.setDescription(req.getString("description"));
                c.setIdcible(req.getInt("idcible"));
                c.setIdtype(req.getInt("idtype"));
                c.setTitre(req.getString("titre"));
                list.add(c);
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

    public void modifContenu(Contenu c) throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        String sql = "update contenu set idtype=?, idcible=? ,date=?, titre=?, description=? where id=? ";
        try {
            con = conn.getConnexion();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getIdtype());
            stmt.setInt(2, c.getIdcible());
            stmt.setDate(3, c.getDate());
            stmt.setString(4, c.getTitre());
            stmt.setString(5, c.getDescription());
            stmt.setInt(6, c.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {

            stmt.close();
            con.close();
        }

    }

    public void deleteContenu(int id) throws Exception {
        Connection con = null;
        Statement stmt = null;

        String sql = "delete from contenu where id=" + id;
        try {
            con = conn.getConnexion();
            stmt = con.createStatement();
            //stmt.setInt(1, id);
            stmt.executeUpdate(sql);
            //System.out.println(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {

            stmt.close();
            con.close();
        }
    }
    
    public ArrayList<Contenu> listeContenById(int id) throws Exception {
        ArrayList<Contenu> list = null;
        Connection connex = null;
        Statement stmt = null;
        ResultSet req = null;
        String sql = null;
        try {
            connex = conn.getConnexion();
            stmt = connex.createStatement();
            sql = "select * from contenu where id="+ id;
            req = stmt.executeQuery(sql);
            list = new ArrayList<>();
            while (req.next()) {
                Contenu c = new Contenu();
                c.setId(req.getInt("id"));
                c.setDate(req.getDate("date"));
                c.setDescription(req.getString("description"));
                c.setIdcible(req.getInt("idcible"));
                c.setIdtype(req.getInt("idtype"));
                c.setTitre(req.getString("titre"));
                list.add(c);
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
    
    public ArrayList<V_contenu> listeViewContenu(int limit, int offset) throws Exception {
        ArrayList<V_contenu> list = null;
        Connection connex = null;
        Statement stmt = null;
        ResultSet req = null;
        String sql = null;
        try {
            connex = conn.getConnexion();
            stmt = connex.createStatement();
            sql = "select * from v_contenu limit " + limit + " offset " + offset;
            req = stmt.executeQuery(sql);
            list = new ArrayList<>();
            while (req.next()) {
                V_contenu c = new V_contenu();
                c.setId(req.getInt("id"));
                c.setDate(req.getDate("date"));
                c.setDescription(req.getString("description"));
                c.setIdcible(req.getInt("idcible"));
                c.setIdtype(req.getInt("idtype"));
                c.setTitre(req.getString("titre"));
                c.setCible(req.getString("cible"));
                c.setNom(req.getString("nom"));
                c.setType(req.getString("type"));
                list.add(c);
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
