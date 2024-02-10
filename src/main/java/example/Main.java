package example;

import gestion_finance.entities.Abonnement;
import gestion_finance.entities.BilanFinancier;
import gestion_finance.service.AbonnementService;
import gestion_planing.service.PlanningService;
import gestion_user.entities.Coach;
import gestion_user.entities.Sexe;
import gestion_user.service.CoachService;
import utils.DataSource;

import java.sql.Date;

import static gestion_finance.entities.Etat.actif;
import static gestion_finance.entities.Type.annuel;
import static gestion_finance.entities.Type.mensuel;


public class Main {
    public static void main(String[] args) {

        DataSource ds1 = DataSource.getInstance();
        System.out.println(ds1);

       /* CoachService cs = new CoachService();
       //Coach coach1 = new Coach("mamoud","mamoud","1234","mahmoud@123", Date.valueOf("2024-02-10"), male,3000,1);
        //Coach coach2 = new Coach(5,"ali","ali","1234","ali@123",  Date.valueOf("2024-02-09"), male,3000,1);
       // System.out.println(cs.readAll());
        cs.delete(3);
        System.out.println(cs.readAll());
       // cs.add(coach1);
        // cs.add(coach2);
        //cs.delete(5);
//System.out.println(cs.readAll());
*/


       /* DataSource ds1 = DataSource.getInstance();
        System.out.println(ds1);*/
        AbonnementService as = new AbonnementService();
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
        );

        /*as.add(abonnement1);
        as.add(abonnement2);*/
        /*as.delete(abonnement1);
        as.readAll().forEach(System.out::println);*/
        //System.out.println("L'abonnement a été ajouté avec succès !");



        Abonnement abonnement3 = new Abonnement(
                3, mensuel , 100.0,
                Date.valueOf("2024-02-09"),
                Date.valueOf("2024-03-09") ,
                actif,
                3,1
        );

        Abonnement abonnement4 = new Abonnement(
                4, annuel , 100.0,
                Date.valueOf("2024-02-09"),
                Date.valueOf("2025-02-09") ,
                actif,
                4,1
        );

        Abonnement abonnement5 = new Abonnement(
                5, mensuel , 100.0,
                Date.valueOf("2024-02-09"),
                Date.valueOf("2024-03-09") ,
                actif,
                5,1
        );

       /* abonnement5.setType(annuel);
        abonnement5.setPrix(1200);

        as.update(abonnement5);
        as.delete(abonnement5);*/

        BilanFinancier bf = new BilanFinancier(1, 0.0 , 0.0);

        bf.setRevenus_abonnements(bf.recupererPrixAbonnements());
        System.out.println("Prix total des abonnements : " +bf.getRevenus_abonnements());




        PlanningService planningService = new PlanningService();








        /*// Créer un objet planning pour tester le delete
        planning planningToDelete = new planning();
        planningToDelete.setId(1); // Remplacez 1 par l'ID de l'objet que vous voulez supprimer
        planningService.delete(planningToDelete);
        System.out.println("Planning supprimé avec succès !");*/

        // Créer un objet planning pour tester l'update
    /*    PlanningService PS = new PlanningService();
        planning p = new planning(
                1, "s2" ,
                Date.valueOf("2024-02-10"),
                Time.valueOf("14:00:00") ,
               1,
                1
        );
        PS.update(p);
        System.out.println("Planning mis à jour avec succès !");*/




    }
}