package example;

import utils.DataSource;

public class Main {
    public static void main(String[] args) {

        DataSource ds1 = DataSource.getInstance();
        System.out.println(ds1);



        System.out.println("Hello world!");
    }
}