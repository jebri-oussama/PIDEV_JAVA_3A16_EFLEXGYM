package example;

import gestion_finance.entities.Abonnement;
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

        /*as.add(abonnement1);*/
        as.add(abonnement2);
        //as.delete(abonnement1);
        as.readAll().forEach(System.out::println);
        //System.out.println("L'abonnement a été ajouté avec succès !");





    }
}