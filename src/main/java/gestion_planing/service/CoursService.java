package gestion_planing.service;


import gestion_evenement.entities.Evenement;
import gestion_finance.entities.Abonnement;
import gestion_finance.entities.Etat;
import gestion_finance.entities.Type;
import gestion_planing.entities.cours;
import utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
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
        String requete = "UPDATE cours SET nom = ?, type = ?, duree = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.setString(2, c.getType().toString()); // Assuming getType() returns a String representation of the enum
            pst.setInt(3, c.getDuree());
            pst.setInt(4, c.getId()); // Assuming getId() returns the ID of the course
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<cours> readAll() {
        String query = "SELECT * FROM cours";
        List<cours> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String typeString = rs.getString("type"); // Assuming type is stored as a string in the database
                Type type = Type.valueOf(typeString); // Assuming TypeEnum is the enum type corresponding to your 'type' column
                int duree = rs.getInt("duree");

                cours cours = new cours(id, nom, type, duree);
                list.add(cours);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public cours readById(int id) {
        String requete = "SELECT * FROM cours WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nom");
                String typeString = rs.getString("type"); // Assuming type is stored as a string in the database
                Type type = Type.valueOf(typeString); // Assuming TypeEnum is the enum type corresponding to your 'type' column
                int duree = rs.getInt("duree");

                return new cours(id, nom, type, duree);
            } else {
                return null; // Course with the given ID not found//
                 }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
