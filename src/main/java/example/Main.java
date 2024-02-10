package example;

import gestion_finance.entities.Abonnement;
import gestion_finance.entities.BilanFinancier;
import gestion_finance.entities.Etat;
import gestion_finance.entities.Type;
import gestion_finance.service.AbonnementService;
//import utils.DataSource;

import java.sql.Date;

import static gestion_finance.entities.Etat.*;
import static gestion_finance.entities.Type.*;

public class Main {
    public static void main(String[] args) {

        /* DataSource ds1 = DataSource.getInstance();
        System.out.println(ds1);*/
        AbonnementService as = new AbonnementService();
        /*Abonnement abonnement1 = new Abonnement(
                1, mensuel , 100.0,
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
        Abonnement abonnement3 = new Abonnement(
                3, annuel , 1200.0,
                Date.valueOf("2024-02-09"),
                Date.valueOf("2024-03-09") ,
                actif,
                3,1
        );
        Abonnement abonnement4 = new Abonnement(
                4, annuel , 1200.0,
                Date.valueOf("2024-02-09"),
                Date.valueOf("2024-03-09") ,
                actif,
                4,1
        );

       // as.add(abonnement2);
       // as.add(abonnement3);
        //as.add(abonnement4);

        System.out.println(as.readById(3));


        abonnement3.setType(mensuel);
        abonnement3.setPrix(100.0);
        as.update(abonnement3);
        as.add(abonnement2);
        as.readAll().forEach(System.out::println);
        System.out.println(as.readById(3));
        //System.out.println("L'abonnement a été ajouté avec succès !");*/

        BilanFinancier bf = new BilanFinancier(1, 0.0, 0.0);

         bf.setRevenus_abonnements(bf.recupererPrixAbonnements());
        System.out.println("Prix total des abonnements : " + bf.getRevenus_abonnements());








    }
}