package gestion_planing.service;


import gestion_evenement.entities.Evenement;
import gestion_finance.entities.Abonnement;
import gestion_finance.entities.Etat;
import gestion_finance.entities.Type;
import gestion_planing.entities.TypeCours;
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
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(query);
            while (rs.next()) {
                TypeCours type = TypeCours.valueOf(rs.getString(3));
                list.add(new cours(rs.getInt(1), rs.getString(2), type, rs.getInt(4)));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);


        }


        return list;
    }

    public cours readById(int id) {
        String requete = "SELECT * FROM cours WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                TypeCours type = TypeCours.valueOf(rs.getString(3));
                return new cours(rs.getInt(rs.getInt(1)), rs.getString(2), type, rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



}
