package gestion_planing.entities;

import java.sql.Time;
import java.util.Date;

public class planning {
    private int id;
    private String salle;
    private int nb_place_max;
    private Date date;
    private Time heure;
    private int id_cour;
    private int id_coach;

    public planning() {
    }

    public planning(int id, String salle, int nb_place_max, Date date, Time heure, int id_cour, int id_coach) {
        this.id = id;
        this.salle = salle;
        this.nb_place_max = nb_place_max;
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

    public int getNb_place_max() {
        return nb_place_max;
    }

    public void setNb_place_max(int nb_place_max) {
        this.nb_place_max = nb_place_max;
    }

    @Override
    public String toString() {
        return "planning{" +
                "id=" + id +
                ", salle='" + salle + '\'' +
                ", nb_place_max=" + nb_place_max +
                ", date=" + date +
                ", heure=" + heure +
                ", id_cour=" + id_cour +
                ", id_coach=" + id_coach +
                '}';
    }
}
