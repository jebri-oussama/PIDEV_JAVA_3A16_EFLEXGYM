package gestion_finance.service;

import gestion_finance.entities.Abonnement;
import utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AbonnementService implements IService<Abonnement> {

    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;


    public AbonnementService() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void add(Abonnement a) {
        String requete = "INSERT INTO Abonnement (id, type, prix, date_debut, date_fin, etat, id_adherent, id_bilan_financier) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getType().toString());
            pst.setDouble(3,a.getPrix());
            pst.setDate(4, a.getDate_debut());
            pst.setDate(5, a.getDate_fin());
            pst.setObject(6, a.getEtat().toString());
            pst.setInt(7, a.getId_adherent());
            pst.setInt(8, a.getId_bilan_financier());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


}

    @Override
    public void delete(Abonnement abonnement) {

    }

    @Override
    public void update(Abonnement abonnement) {

    }

    @Override
    public List<Abonnement> readAll() {
        return null;
    }

    @Override
    public Abonnement readById(int id) {
        return null;
    }
}
