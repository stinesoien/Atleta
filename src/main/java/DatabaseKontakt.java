/**
 * Created by Stine on 25.09.2017.
 */
/*
public class dbconnection {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://mysql.stud.iie.ntnu.no:3306/g_sysu_atleta?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "g_sysu_atleta";
        String password = "jsaFruna";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class DatabaseKontakt {
    public static void main(String[] args) throws Exception {

        String databasedriver = "com.mysql.cj.jdbc.Driver";
        Class.forName(databasedriver);  // laster inn driverklassen

        String databasenavn = "jdbc:mysql://mysql.stud.iie.ntnu.no:3306/g_sysu_atleta?serverTimezone=UTC";
        String username = "g_sysu_atleta";
        String password = "jsaFruna";
        Connection forbindelse = DriverManager.getConnection(databasenavn, username, password);
        Statement setning = forbindelse.createStatement();
        ResultSet res = setning.executeQuery("select * from bruker");
        while (res.next()) {
            String fornavn = res.getString("fornavn");
            String etternavn = res.getString("etternavn");
            System.out.println(fornavn + " " + etternavn);
        }
        res.close();
        setning.close();
        forbindelse.close();
    }
}
