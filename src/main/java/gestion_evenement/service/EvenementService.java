package gestion_evenement.service;

import gestion_evenement.entities.Evenement;
import utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvenementService implements IService<Evenement> {

    private Connection conn;
    private PreparedStatement pst;

    public EvenementService() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void add(Evenement e) {
        String query = "INSERT INTO Evenement (type, date_debut, date_fin, duree) VALUES (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, e.getType());
            pst.setTimestamp(2, new java.sql.Timestamp(e.getDate_debut().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(e.getDate_fin().getTime()));
            pst.setString(4, e.getDuree());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(Evenement evenement) {
        String query = "DELETE FROM Evenement WHERE id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, evenement.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Evenement evenement) {
        String query = "UPDATE Evenement SET type = ?, date_debut = ?, date_fin = ?, duree = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, evenement.getType());
            pst.setTimestamp(2, new java.sql.Timestamp(evenement.getDate_debut().getTime()));
            pst.setTimestamp(3, new java.sql.Timestamp(evenement.getDate_fin().getTime()));
            pst.setString(4, evenement.getDuree());
            pst.setInt(5, evenement.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Evenement> readAll() {
        String query = "SELECT * FROM Evenement";
        List<Evenement> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Evenement(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getTimestamp("date_debut"),
                        rs.getTimestamp("date_fin"),
                        rs.getString("duree")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Evenement readById(int id) {
        String query = "SELECT * FROM Evenement WHERE id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Evenement(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getTimestamp("date_debut"),
                        rs.getTimestamp("date_fin"),
                        rs.getString("duree")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
