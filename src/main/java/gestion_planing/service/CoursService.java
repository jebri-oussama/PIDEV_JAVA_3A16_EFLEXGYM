package gestion_planing.service;


import gestion_planing.entities.cours;
import utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CoursService implements IntService<cours> {
    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;

    public CoursService() {
        conn= DataSource.getInstance().getCnx();
    }
    public void add(cours c){
        String requete = "INSERT INTO cours (id, nom, type, duree) VALUES (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.setString(2, c.getNom());
            pst.setString(3,c.getType().toString());
            pst.setInt(4, c.getDuree());

            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(cours c) {
        String requete = "DELETE FROM cours WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1 ,c.getId() );
            pst.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
    public void update(cours c) {
        String requete = "UPDATE cours SET nom = ?, typre = ?, duree= ? WHERE id =?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getType().toString());
            pst.setInt(3,c.getDuree());
            pst.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
    public List<cours> readAll() {
        return null;
    }

    @Override
    public cours readById(int id) {
        return null;
    }

}
