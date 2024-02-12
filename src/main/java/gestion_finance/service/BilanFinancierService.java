package gestion_finance.service;

import gestion_finance.entities.Abonnement;
import gestion_finance.entities.BilanFinancier;
import gestion_finance.entities.Etat;
import gestion_finance.entities.Type;
import utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BilanFinancierService implements IService<BilanFinancier> {

    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;


    public BilanFinancierService() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void add(BilanFinancier bf) {
        String requete = "INSERT INTO bilan_financier(id,salaires_coachs, prix_location, profit, revenus_abonnements,revenus_produits, depenses) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, bf.getId());
            pst.setDouble(2, bf.getSalaires_coachs());
            pst.setDouble(3,bf.getPrix_location());
            pst.setDouble(4, bf.getProfit());
            pst.setDouble(5, bf.getRevenus_abonnements());
            pst.setDouble(6, bf.getRevenus_produits());
            pst.setDouble(7, bf.getDepenses());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(BilanFinancier bf) {
        String requete = "DELETE FROM bilan_financier WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1 , bf.getId());
            pst.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(BilanFinancier bf) {
        String requete = "UPDATE bilan_financier SET salaires_coachs = ?, prix_location = ?, profit= ?, revenus_abonnements = ?, revenus_produits= ?, depenses = ? WHERE id =?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setDouble(1, bf.getSalaires_coachs());
            pst.setDouble(2, bf.getPrix_location());
            pst.setDouble(3,bf.getProfit());
            pst.setDouble(4,bf.getRevenus_abonnements());
            pst.setDouble(5,bf.getRevenus_produits());
            pst.setDouble(6,bf.getDepenses());
            pst.setInt(7,bf.getId());
            pst.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<BilanFinancier> readAll() {
        String requete="select * from bilan_financier";
        List<BilanFinancier> list = new ArrayList<>();
        try {
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(requete);
            while (rs.next()) {
                list.add(new BilanFinancier(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7)));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);


        }
        return list;
    }

    @Override
    public BilanFinancier readById(int id) {
        String requete = "SELECT * FROM bilan_financier WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){

                return new BilanFinancier(rs.getInt(1),  rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6),rs.getDouble(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
