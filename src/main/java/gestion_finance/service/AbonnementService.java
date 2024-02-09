package gestion_finance.service;

import gestion_finance.entities.Abonnement;
import gestion_finance.entities.Etat;
import gestion_finance.entities.Type;
import utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
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
            pst.setString(6, a.getEtat().toString());
            pst.setInt(7, a.getId_adherent());
            pst.setInt(8, a.getId_bilan_financier());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


}

    @Override
    public void delete(Abonnement abonnement) {
        String requete = "DELETE FROM Abonnement WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1 , abonnement.getId());
            pst.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Abonnement abonnement) {
        String requete = "UPDATE Abonnement SET type = ?, prix = ?, date_debut= ?, date_fin = ?, etat= ?, id_adherent = ?, id_bilan_financier = ? WHERE id =?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setString(1, abonnement.getType().toString());
            pst.setDouble(2, abonnement.getPrix());
            pst.setDate(3,abonnement.getDate_debut());
            pst.setDate(4,abonnement.getDate_fin());
            pst.setString(5,abonnement.getEtat().toString());
            pst.setInt(6,abonnement.getId_adherent());
            pst.setInt(7,abonnement.getId_bilan_financier());
            pst.setInt(8,abonnement.getId());
            pst.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Abonnement> readAll() {
        String requete="select * from Abonnement";
        List<Abonnement> list = new ArrayList<>();
        try {
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(requete);
            while (rs.next()) {
                Type type = Type.valueOf(rs.getString(2));
                Etat etat = Etat.valueOf(rs.getString(6));
                list.add(new Abonnement(rs.getInt(1), type, rs.getDouble(3), rs.getDate(4), rs.getDate(5), etat, rs.getInt(7), rs.getInt(8)));
            }
        }catch(SQLException e){
                throw new RuntimeException(e);


            }


        return list;
    }

    @Override
    public Abonnement readById(int id) {
        String requete = "SELECT * FROM Abonnement WHERE id = ?";
        try{
           pst = conn.prepareStatement(requete);
           pst.setInt(1, id);
           ResultSet rs = pst.executeQuery();
           if (rs.next()){
               Type type = Type.valueOf(rs.getString(2));
               Etat etat = Etat.valueOf(rs.getString(6));
               return new Abonnement(rs.getInt(1), type, rs.getDouble(3), rs.getDate(4), rs.getDate(5), etat, rs.getInt(7), rs.getInt(8));
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
        }




}
