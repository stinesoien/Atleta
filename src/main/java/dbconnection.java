import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Stine on 25.09.2017.
 */
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
}
