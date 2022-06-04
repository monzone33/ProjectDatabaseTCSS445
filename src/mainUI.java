import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class mainUI {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/project";

        //if you created a separate account, use that, otherwise use root
        String user = "root";
        String password = "123456";

        //quickly grab everything from Customers table and display to show everything worked
        String query = "SELECT * FROM Lore";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();        // Allows us to do things such as execute things.
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(mainUI.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
