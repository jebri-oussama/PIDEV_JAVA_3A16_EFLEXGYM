package gestion_user.entities;

import java.util.Date;
import java.util.Objects;

public class Adherent extends User{


    private static int id;
    private String nom;
    private String prenom;
    private String mot_de_passe;
    private String email;
    private Date date_de_naissance;
    private Sexe sexe;

    public Adherent(int anInt, String nom, String prenom, String mot_de_passe, String email, Date date_de_naissance, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.date_de_naissance = date_de_naissance;
        this.sexe = sexe;
    }
    public Adherent(String nom, String prenom, String mot_de_passe, String email, Date date_de_naissance, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.date_de_naissance = date_de_naissance;
        this.sexe = sexe;
    }
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Adherent.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adherent adherent = (Adherent) o;
        return Objects.equals(nom, adherent.nom) && Objects.equals(prenom, adherent.prenom) && Objects.equals(mot_de_passe, adherent.mot_de_passe) && Objects.equals(email, adherent.email) && Objects.equals(date_de_naissance, adherent.date_de_naissance) && sexe == adherent.sexe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, mot_de_passe, email, date_de_naissance, sexe);
    }

    @Override
    public String toString() {
        return "Adherent{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", email='" + email + '\'' +
                ", date_de_naissance=" + date_de_naissance +
                ", sexe=" + sexe +
                '}';
    }
}
