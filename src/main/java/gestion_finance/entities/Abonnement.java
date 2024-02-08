package gestion_finance.entities;



import java.sql.Date;

public class Abonnement  {

    private int id;
    private Type type;
    private double prix;
    private Date date_debut;
    private Date date_fin;
    private Etat etat;
    private int id_adherent;
    private int id_bilan_financier;

    public Abonnement(int id , Type type, double prix, Date date_debut, Date date_fin, Etat etat , int id_adherent ,int id_bilan_financier) {
        this.type = type;
        this.prix = prix;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat = etat;
        this.id_adherent = id_adherent;
        this.id_bilan_financier = id_bilan_financier;
        this.id=id;

    }

    public int getId_bilan_financier() {
        return id_bilan_financier;
    }

    public void setId_bilan_financier(int id_bilan_financier) {
        this.id_bilan_financier = id_bilan_financier;
    }

    public int getId_adherent() {
        return id_adherent;
    }

    public void setId_adherent(int id_adherent) {
        this.id_adherent = id_adherent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public java.sql.Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public java.sql.Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "type=" + type +
                ", prix=" + prix +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", etat=" + etat +
                '}';
    }
}
