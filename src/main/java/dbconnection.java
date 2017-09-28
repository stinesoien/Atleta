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

/**
 * DatabaseKontakt.java  - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Programmet kopler seg til en database, og henter ut innholdet i tabellen Person.
 * SQL-skript for Â lage tabellen Person er gjengitt nederst i denne filen.
 *
 * Stien til databasedriveren er satt opp i CLASSPATH. Dersom driveren er en
 * zip- eller jar-fil, mÂ bÂde sti og filnavn inn i CLASSPATH.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class DatabaseKontakt {
    public static void main(String[] args) throws Exception {

    /* Hvis du bruker en annen driver, mÂ du skifte ut strengkonstanten i neste linje. */
        String databasedriver = "org.apache.derby.jdbc.ClientDriver";
        Class.forName(databasedriver);  // laster inn driverklassen

    /*
     * VÂr database heter persondata, og den kj¯rer pÂ samme maskin som
     * dette klientprogrammet. Strengkonstanten i neste linje mÂ du
     * tilpasse din situasjon.
     */
        String databasenavn
                = "jdbc:derby://localhost:1527/persondata;user=vprg;password=vprg";
        Connection forbindelse = DriverManager.getConnection(databasenavn);
        Statement setning = forbindelse.createStatement();
        ResultSet res = setning.executeQuery("select * from person");
        while (res.next()) {
            int persNr = res.getInt("persnr");
            String fornavn = res.getString("fornavn");
            String etternavn = res.getString("etternavn");
            System.out.println(persNr + ": " + fornavn + " " + etternavn);
        }
        res.close();
        setning.close();
        forbindelse.close();
    }
}

/*
SQL-skript for Â lage tabellen Person:

create table person(
 persnr    integer primary key,
 fornavn   varchar(30) not null,
 etternavn varchar(30) not null);

insert into person values (100, 'Ole', 'Hansen');
insert into person values (101, 'Anne Grethe', '≈s');
insert into person values (102, 'Jonny', 'Hansen');

Utskrift fra programmet:

100: Ole Hansen
101: Anne Grethe ≈s
102: Jonny Hansen
*/
