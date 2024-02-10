package gestion_user.entities;

import java.sql.Date;

public class Coach extends User{
    private static int id;
    private int id_bilan_financier;
    private String nom;
    private String prenom;
    private String mot_de_passe;
    private String email;
    private Date date_de_naissance;
    private Sexe sexe;
    private double salaire;


    public Coach(int anInt, String nom, String prenom, String mot_de_passe, String email, Date date_de_naissance, Sexe sexe, double salaire, int id_bilan_financier) {
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.date_de_naissance = date_de_naissance;
        this.sexe = sexe;
        this.salaire = salaire;
        this.id_bilan_financier=id_bilan_financier;

    }

    public Coach(String nom, String prenom, String mot_de_passe, String email, Date date_de_naissance, Sexe sexe, double salaire, int id_bilan_financier) {
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.date_de_naissance = date_de_naissance;
        this.sexe = sexe;
        this.salaire = salaire;
        this.id_bilan_financier=id_bilan_financier;


    }
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Coach.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public int getId_bilan_financier() {
        return id_bilan_financier;
    }

    public void setId_bilan_financier(int id_bilan_financier) {
        this.id_bilan_financier = id_bilan_financier;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", email='" + email + '\'' +
                ", date_de_naissance=" + date_de_naissance +
                ", sexe=" + sexe +
                ", salaire=" + salaire +
                ", id_bilan_financier=" + id_bilan_financier +
                '}';
    }
}
