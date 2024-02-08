package utils;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static Connection cnx;
    private static String url="jdbc:mysql://localhost:3306/gym";
    private static String login="root";
    private static String pwd="";
    private static DataSource instance;


    private DataSource() {

        try

        {
            cnx = DriverManager.getConnection(url,login,pwd);
            System.out.println("success");
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }


    public static DataSource getInstance(){
        if(instance == null)
            instance = new DataSource();
        return instance;
    }

    public static Connection getCnx() {
        return cnx;
    }

    public static void setCnx(Connection cnx) {
        DataSource.cnx = cnx;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DataSource.url = url;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        DataSource.login = login;
    }

    public static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        DataSource.pwd = pwd;
    }

    public static void setInstance(DataSource instance) {
        DataSource.instance = instance;
    }
}

