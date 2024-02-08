package gestion_finance.entities;



import java.util.Date;

public class Abonnement  {

    private static int id;
    private Type type;
    private double prix;
    private Date date_debut;
    private Date date_fin;
    private Etat etat;

    public Abonnement(Type type, double prix, Date date_debut, Date date_fin, Etat etat) {
        this.type = type;
        this.prix = prix;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat = etat;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Abonnement.id = id;
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

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
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
