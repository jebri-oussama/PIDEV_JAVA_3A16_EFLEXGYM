package gestion_produit.service;
import utils.DataSource;
import gestion_produit.entities.produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class produitService implements  IService<produit> {


    private Connection conn;
    private Statement ste;
    private PreparedStatement pst;

    public produitService() {
        conn = DataSource.getInstance().getCnx();
    }

    public void add(produit p) {
        String requete = "INSERT INTO produit (id, nom, image, prix, quantite, description, id_admin, id_bilan_financier) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getNom().toString());
            pst.setString(3, p.getImage().toString());
            pst.setFloat(4, p.getPrix());
            pst.setInt(5, p.getQuantite());
            pst.setString(6, p.getDescription().toString());
            pst.setInt(7, p.getId_admin());
            pst.setInt(8, p.getId_bilan_financier());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    public void delete(int id) {
        String requete = "DELETE FROM produit WHERE id = ?";
        try{
            pst = conn.prepareStatement(requete);
            pst.setInt(1 , id);
            int test= pst.executeUpdate();
            if (test == 0) {
                System.out.println("N'y a aucun produit avec ce id: " + id);
            } else {
                System.out.println("produit trouvé " + id + " a été supprimé.");
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int ID,produit produit) {
        String requete = "UPDATE produit SET nom = ?, image = ?, prix= ?, quantite = ?, description= ?, id_admin = ?, id_bilan_financier = ? WHERE id =?";
        try {
            pst = conn.prepareStatement(requete);
            pst.setString(1, produit.getNom().toString());
            pst.setString(2, produit.getImage());
            pst.setFloat(3, produit.getPrix());
            pst.setInt(4, produit.getQuantite());
            pst.setString(5, produit.getDescription().toString());
            pst.setInt(6, produit.getId_admin());
            pst.setInt(7, produit.getId_bilan_financier());
            pst.setInt(8, ID);



            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<produit> readAll() {
        String requete = "select * from produit";
        List<produit> list = new ArrayList<>();
        try {
            ste = conn.createStatement();
            ResultSet rs = ste.executeQuery(requete);
            while (rs.next()) {

                list.add(new produit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return list;
    }

    @Override
    public produit readById(int id) {
        String requete = "SELECT * FROM produit WHERE id = ?";
        try {
            pst = conn.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // Log the retrieved values for debugging
                System.out.println("Retrieved ID: " + rs.getInt(1));
                System.out.println("Retrieved Name: " + rs.getString(2));
                // Log other values similarly

                // Construct and return the produit object
                return new produit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}


