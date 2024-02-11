package example;


import gestion_evenement.entities.Evenement;
import gestion_evenement.service.EvenementService;
import gestion_planing.service.PlanningService;
import gestion_user.entities.Coach;
import gestion_user.entities.Sexe;
import gestion_user.service.CoachService;
import utils.DataSource;
import gestion_reclamation.entities.Reclamation;
import gestion_reclamation.service.ReclamationService;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import static gestion_user.entities.Sexe.homme;
import gestion_produit.entities.produit;
import gestion_produit.service.produitService;







public class Main {
    public static void main(String[] args) {

/*
        DataSource ds1 = DataSource.getInstance();
        System.out.println(ds1);
        produitService ps= new produitService();
        produit p1 = new produit(1,
                "oussema" , "prot.png",
                53.5F,
                5 ,
                "twali bdan fi nharin",
                1,1
        );*/



        // ps.add(p1);
//ps.add(p2);

//ps.delete(2);

        //   ps.readAll().forEach(System.out::println);
        //ps.update(7,p1);
/*p1.setNom("llg");
p1.setDescription("ok");
        ps.update(3,p1);
*/
     //   ps.readById(5);


      //  ReclamationService R = new ReclamationService();
       /*
        Reclamation r1 = new Reclamation(3,
                "ppp", "aaa", Reclamation.Status.pending,2
        );*/
        // R.add(r1);
        // R.update(r1);
        //R.readAll().forEach(System.out::println);

        //dynamic delete
         /* int reclamationIdToDelete =5 ;
        R.delete(reclamationIdToDelete);
        System.out.println("Reclamation with ID " + reclamationIdToDelete + " deleted successfully.");
        */

        /*
        // ID of the Reclamation you want to retrieve
        int eventIdToRetrieve = 1; // Change this to the desired ID

        // Retrieve the Reclamation by ID and print it
        Reclamation retrievedReclamation = R.readById(eventIdToRetrieve);
        if (retrievedReclamation != null) {
            System.out.println("Retrieved Reclamation: " + retrievedReclamation);
        } else {
            System.out.println("No Reclamation found with ID: " + eventIdToRetrieve);
        }

*/



        /*//READ BY ID
        EvenementService evenementService = new EvenementService();
        // ID of the Evenement you want to retrieve
        int eventIdToRetrieve = 6; // Change this to the desired ID

        // Retrieve the Evenement by ID and print it
        Evenement retrievedEvenement = evenementService.readById(eventIdToRetrieve);
        if (retrievedEvenement != null) {
            System.out.println("Retrieved Evenement: " + retrievedEvenement);
        } else {
            System.out.println("No Evenement found with ID: " + eventIdToRetrieve);
        }
*/
        //EvenementService E= new EvenementService();
        /*Evenement e1 = new Evenement(1,
                "rr", Timestamp.valueOf("2024-03-09 12:30:00"), Timestamp.valueOf("2024-02-09 14:00:00"),"20"
        );*/

        //dynamic delete
        // ID of the Evenement you want to delete
        /*int eventIdToDelete = 5; // Change this to the desired ID
        E.delete(eventIdToDelete);
        System.out.println("Evenement with ID " + eventIdToDelete + " deleted successfully.");*/

        //E.add(e1);
        // E.update(e1);

        //E.readAll().forEach(System.out::println);




        // Database connection test
        /*
          DataSource ds1 = DataSource.getInstance();
          System.out.println(ds1);

            */

        //   CoachService cs = new CoachService();
        //Coach coach1 = new Coach("mamoud","mamoud","1234","mahmoud@123", Date.valueOf("2024-02-10"), male,3000,1);
        //Coach coach2 = new Coach(5,"ali","ali","1234","ali@123",  Date.valueOf("2024-02-09"), male,3000,1);
        // System.out.println(cs.readAll());
        //   cs.delete(3);
        //   System.out.println(cs.readAll());
        // cs.add(coach1);
        // cs.add(coach2);
        //cs.delete(5);
//System.out.println(cs.readAll());



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
        //   PlanningService planningService = new PlanningService();

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


    }}






