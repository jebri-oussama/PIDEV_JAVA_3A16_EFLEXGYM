package gestion_user.entities;

import java.util.Date;
import java.util.Objects;

public class Coach extends User{
    private static int id;
    private String nom;
    private String prenom;
    private String mot_de_passe;
    private String email;
    private Date date_de_naissance;
    private sexe sexe;

    public Coach(String nom, String prenom, String mot_de_passe, String email, Date date_de_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.date_de_naissance = date_de_naissance;
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

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public gestion_user.entities.sexe getSexe() {
        return sexe;
    }

    public void setSexe(gestion_user.entities.sexe sexe) {
        this.sexe = sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(nom, coach.nom) && Objects.equals(prenom, coach.prenom) && Objects.equals(mot_de_passe, coach.mot_de_passe) && Objects.equals(email, coach.email) && Objects.equals(date_de_naissance, coach.date_de_naissance) && sexe == coach.sexe;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, mot_de_passe, email, date_de_naissance, sexe);
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
                '}';
    }
}
