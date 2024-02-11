package gestion_planing.service;

import gestion_finance.entities.Type;
import gestion_planing.entities.cours;
import gestion_planing.entities.planning;
import utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanningService implements IntService<planning>{
    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;
    public PlanningService() {
        conn= DataSource.getInstance().getCnx();
    }
    public void add(planning p){
        String requete = "INSERT INTO planning (id, salle, nb_place_max ,date, heure , id_cour , id_coach) VALUES (?, ?,? ,?, ? ,? ,?)";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getSalle());
            pst.setInt(3,p.getNb_place_max());
            pst.setDate(4,p.getDate());
            pst.setTime(5,p.getHeure());
            pst.setInt(6, p.getId_cour());
            pst.setInt(7, p.getId_coach());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void delete(planning p) {
        String requete = "DELETE FROM planning WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1 , p.getId());
            pst.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void update(planning p) {
        String requete = "UPDATE planning SET salle = ?, nb_place_max = ?, date = ?, heure = ?, id_cour = ?, id_coach = ? WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setString(1, p.getSalle());
            pst.setInt(2, p.getNb_place_max());
            pst.setDate(3, p.getDate());
            pst.setTime(4, p.getHeure());
            pst.setInt(5, p.getId_cour());
            pst.setInt(6, p.getId_coach());
            pst.setInt(7, p.getId());
            pst.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<planning> readAll() {
        String query = "SELECT * FROM planning";
        List<planning> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String salle = rs.getString("salle");
                int nb_place_max = rs.getInt("nb_place_max");
                Date date = rs.getDate("date");
                Time heure = rs.getTime("heure");
                int id_cour = rs.getInt("id_cour");
                int id_coach = rs.getInt("id_coach");

                planning planning = new planning(id, salle ,nb_place_max , date , heure , id_cour , id_coach);
                list.add(planning);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public planning readById(int id) {
        String requete = "SELECT * FROM planning WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String salle = rs.getString("salle");
                int nb_place_max = rs.getInt("nb_place_max");
                Date date = rs.getDate("date");
                Time heure = rs.getTime("heure");
                int id_cour = rs.getInt("id_cour");
                int id_coach = rs.getInt("id_coach");

                return new planning(id, salle ,nb_place_max , date , heure , id_cour , id_coach);
            } else {
                return null; // Course with the given ID not found//
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
