package gestion_planing.entities;

import java.sql.Time;
import java.util.Date;

public class planning {
    private int id;
    private String salle;
    private Date date;
    private Time heure;
    private int id_cour;
    private int id_coach;

    public planning() {
    }

    public planning(int id, String salle, Date date, Time heure, int id_cour, int id_coach) {
        this.id = id;
        this.salle = salle;
        this.date = date;
        this.heure = heure;
        this.id_cour = id_cour;
        this.id_coach = id_coach;
    }

    public int getId() {
        return id;
    }

    public String getSalle() {
        return salle;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }


    public int getId_cour() {
        return id_cour;
    }

    public int getId_coach() {
        return id_coach;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public void setId_cour(int id_cour) {
        this.id_cour = id_cour;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "planing{" +
                "id=" + id +
                ", salle='" + salle + '\'' +
                ", date=" + date +
                ", heure='" + heure + '\'' +
                ", id_cour=" + id_cour +
                ", id_coach=" + id_coach +
                '}';
    }
}
