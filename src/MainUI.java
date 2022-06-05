import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MainUI {
    public JFrame myFrame;
    public JPanel panel;
    public Connection connection;

    public void createGUI() throws SQLException {
        connection = getConnection();
        myFrame = new JFrame("League of Legends Database");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(800, 600);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JPanel buttons = new JPanel();
        JScrollPane tablePanel = new JScrollPane();
        JButton basicsButton = new JButton("Basics");
        JButton loreButton = new JButton("Lore");
        JButton itemsButton = new JButton("Items");
        JButton runesButton = new JButton("Runes");
        tablePanel.getViewport().add(addInitialTable());

        basicsButton.setBounds(10, 20, 100, 20);
        basicsButton.setBackground(Color.GREEN);
        loreButton.setBounds(10, 60, 100, 20);
        loreButton.setBackground(Color.GREEN);
        itemsButton.setBounds(10, 100, 100, 20);
        itemsButton.setBackground(Color.GREEN);
        runesButton.setBounds(10, 140, 100, 20);
        runesButton.setBackground(Color.GREEN);
        buttons.add(basicsButton);
        buttons.add(loreButton);
        buttons.add(itemsButton);
        buttons.add(runesButton);

        panel.add(tablePanel);
        myFrame.add(panel);
        myFrame.setLocationRelativeTo(null);        // Positions Frame in Center.
        myFrame.setResizable(true);
        myFrame.setVisible(true);
    }

    private JTable addInitialTable() throws SQLException {
        String columns[] = {"Name", "HP", "HP+", "HPREGEN", "HPREGEN+", "MANA", "MANA+", "MANAREGEN", "MANAREGEN+",
                            "AD", "AD+", "AS", "AS+", "ARMOR", "ARMOR+", "MR", "MR+", "MS", "RANGE"};
        String[][] championRows = new String[159][159];
        String query = "SELECT * FROM CHAMPIONSTATS";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        int row = 0;
        while (result.next()) {
            championRows[row][0] = result.getString(1);
            championRows[row][1] = "" + result.getInt(2);
            championRows[row][2] = "" + result.getInt(3);
            championRows[row][3] = "" + result.getDouble(4);
            championRows[row][4] = "" + result.getDouble(5);
            championRows[row][5] = "" + result.getDouble(6);
            championRows[row][6] = "" + result.getDouble(7);
            championRows[row][7] = "" + result.getDouble(8);
            championRows[row][8] = "" + result.getDouble(9);
            championRows[row][9] = "" + result.getInt(10);
            championRows[row][10] = "" + result.getDouble(11);
            championRows[row][11] = "" + result.getDouble(12);
            championRows[row][12] = "" + result.getDouble(13);
            championRows[row][13] = "" + result.getInt(14);
            championRows[row][14] = "" + result.getDouble(15);
            championRows[row][15] = "" + result.getDouble(16);
            championRows[row][16] = "" + result.getDouble(17);
            championRows[row][17] = "" + result.getDouble(18);
            championRows[row][18] = "" + result.getInt(19);
            row++;
        }
        return new JTable(championRows, columns);
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "123456";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch(final SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
