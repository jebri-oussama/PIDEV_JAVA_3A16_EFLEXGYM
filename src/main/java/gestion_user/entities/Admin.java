package gestion_user.entities;

import java.util.Objects;

public class Admin {
    private static int id;
    private String nom;
    private String prenom;
    private String mot_de_passe;
    private String email;

    public Admin(String nom, String prenom, String mot_de_passe, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Admin.id = id;
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

    @Override
    public String toString() {
        return "Admin{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(nom, admin.nom) && Objects.equals(prenom, admin.prenom) && Objects.equals(mot_de_passe, admin.mot_de_passe) && Objects.equals(email, admin.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, mot_de_passe, email);
    }
}
