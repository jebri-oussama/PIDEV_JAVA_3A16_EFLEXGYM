package gestion_reclamation.service;


import gestion_reclamation.entities.Reclamation;
import utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//
public class ReclamationService implements IService<Reclamation> {

    private Connection conn;
    private PreparedStatement pst;

    public ReclamationService() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void add(Reclamation r) {
        String query = "INSERT INTO Reclamation (type, description, status, id_adherent) VALUES (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, r.getType());
            pst.setString(2, r.getDescription());
            pst.setString(3, r.getStatus().name());
            pst.setInt(4, r.getId_adherent());
            pst.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Reclamation WHERE id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(Reclamation reclamation) {
        String query = "UPDATE Reclamation SET type = ?, description = ?, status = ?, id_adherent = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, reclamation.getType());
            pst.setString(2, reclamation.getDescription());
            pst.setString(3, reclamation.getStatus().name());
            pst.setInt(4, reclamation.getId_adherent());
            pst.setInt(5, reclamation.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reclamation> readAll() {
        String query = "SELECT * FROM Reclamation";
        List<Reclamation> list = new ArrayList<>();
        try {
            pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Reclamation(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("description"),
                        Reclamation.Status.valueOf(rs.getString("status")),
                        rs.getInt("id_adherent")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    @Override
    public Reclamation readById(int id) {
        String query = "SELECT * FROM Reclamation WHERE id = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Reclamation(
                        rs.getInt("id"),
                        rs.getString("type"),
                        rs.getString("description"),
                        Reclamation.Status.valueOf(rs.getString("status")),
                        rs.getInt("id_adherent")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
