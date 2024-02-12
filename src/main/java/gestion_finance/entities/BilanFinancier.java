package gestion_finance.entities;

import utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BilanFinancier {
    private Connection conn;
    private int id;
    private double salaires_coachs;
    private double prix_location;
    private double profit;
    private double revenus_abonnements;
    private double revenus_produits;
    private double depenses;

    private PreparedStatement pst;

    public BilanFinancier( int id, double prix_location, double depenses) {
        this.conn =   DataSource.getInstance().getCnx();
        this.id=id;
        this.prix_location = prix_location;
        this.depenses=depenses;

    }

    public BilanFinancier(int id, double revenus_abonnements, double revenus_produits, double salaires_coachs, double prix_location, double depenses, double profit) {
        this.conn =   DataSource.getInstance().getCnx();
        this.id = id;
        this.revenus_abonnements = revenus_abonnements;
        this.revenus_produits = revenus_produits;
        this.salaires_coachs = salaires_coachs;
        this.prix_location = prix_location;
        this.depenses = depenses;
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double calculerProfit() {
        return revenus_abonnements + revenus_produits -salaires_coachs - depenses - prix_location;
    }

   public double recupererSalairesCoachs() {
        double salairesCoachs = 0;
        String requete = "SELECT SUM(salaire) AS salaires_coachs FROM coach WHERE id_bilan_financier = ?";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, getId());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                salairesCoachs += rs.getDouble("salaires_coachs");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salairesCoachs;
    }



    public double recupererRevenusProduits() {
        double prixTotalProduits = 0;
        String requete = "SELECT SUM(quantite * prix) AS revenus_produits FROM Produit WHERE id_bilan_financier = ?";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, getId());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                prixTotalProduits += rs.getDouble("revenus_produits");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prixTotalProduits;
    }




    public double recupererRevenuAbonnements() {
        double prixTotalAbonnements = 0;

        String requete =  "SELECT SUM(prix) AS revenus_abonnements FROM Abonnement WHERE id_bilan_financier = ?";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, getId());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                prixTotalAbonnements += rs.getDouble("revenus_abonnements");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prixTotalAbonnements;
    }



    public BilanFinancier() {
        this.conn = DataSource.getInstance().getCnx();
    }

    public Connection getConn() {
        return conn;
    }

    public void setCnx(Connection conn) {
        this.conn = conn;
    }

    public double getRevenus_abonnements() {
        return revenus_abonnements;
    }

    public void setRevenus_abonnements(double revenus_abonnements) {
        this.revenus_abonnements = revenus_abonnements;
    }

    public double getRevenus_produits() {
        return revenus_produits;
    }

    public void setRevenus_produits(double revenus_produits) {
        this.revenus_produits = revenus_produits;
    }

    public double getSalaires_coachs() {
        return salaires_coachs;
    }

    public void setSalaires_coachs(double salaires_coachs) {
        this.salaires_coachs = salaires_coachs;
    }

    public double getPrix_location() {
        return prix_location;
    }

    public void setPrix_location(double prix_location) {
        this.prix_location = prix_location;
    }

    public double getDepenses() {
        return depenses;
    }

    public void setDepenses(double depenses) {
        this.depenses = depenses;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "BilanFinancier{" +
                "id=" + id +
                ", salaires_coachs=" + salaires_coachs +
                ", prix_location=" + prix_location +
                ", profit=" + profit +
                ", revenus_abonnements=" + revenus_abonnements +
                ", revenus_produits=" + revenus_produits +
                ", depenses=" + depenses +
                '}';
    }
}
