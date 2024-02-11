package example;

import gestion_finance.entities.Abonnement;
import gestion_finance.entities.Etat;
import gestion_finance.entities.Type;
import gestion_finance.service.AbonnementService;
import gestion_planing.entities.planning;
import gestion_planing.service.PlanningService;
import utils.DataSource;

import java.sql.Date;
import java.sql.Time;

import static gestion_finance.entities.Etat.*;
import static gestion_finance.entities.Type.*;

public class Main {
    public static void main(String[] args) {

       /* DataSource ds1 = DataSource.getInstance();
        System.out.println(ds1);*/
        /*AbonnementService as = new AbonnementService();
        Abonnement abonnement1 = new Abonnement(
                2, mensuel , 100.0,
                Date.valueOf("2024-02-09"),
                Date.valueOf("2024-03-09") ,
               actif,
                1,1
        );
        Abonnement abonnement2 = new Abonnement(
                2, mensuel , 100.0,
                Date.valueOf("2024-02-09"),
                Date.valueOf("2024-03-09") ,
                actif,
                2,1
        );*/

        /*as.add(abonnement1);
        as.add(abonnement2);*/
        /*as.delete(abonnement1);
        as.readAll().forEach(System.out::println);*/
        //System.out.println("L'abonnement a été ajouté avec succès !");
        PlanningService planningService = new PlanningService();

        /*// Créer un objet planning pour tester le delete
        planning planningToDelete = new planning();
        planningToDelete.setId(1); // Remplacez 1 par l'ID de l'objet que vous voulez supprimer
        planningService.delete(planningToDelete);
        System.out.println("Planning supprimé avec succès !");*/

        // Créer un objet planning pour tester l'update
        PlanningService PS = new PlanningService();
        planning p = new planning(
                2, "s2" ,
                Date.valueOf("2024-02-10"),
                Time.valueOf("14:00:00") ,
               1,2
        );
        PS.add(p);
        System.out.println("Planning mis à jour avec succès !");




    }
}