import javax.swing.*;
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
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(Color.BLACK);
        JButton basicsButton = new JButton("Basics");
        JButton loreButton = new JButton("Lore");
        JButton itemsButton = new JButton("Items");
        JButton runesButton = new JButton("Runes");

        basicsButton.setBounds(10, 20, 100, 20);
        basicsButton.setBackground(Color.GREEN);
        loreButton.setBounds(10, 60, 100, 20);
        loreButton.setBackground(Color.GREEN);
        itemsButton.setBounds(10, 100, 100, 20);
        itemsButton.setBackground(Color.GREEN);
        runesButton.setBounds(10, 140, 100, 20);
        runesButton.setBackground(Color.GREEN);
        panel.setLayout(null);
        panel.add(basicsButton);
        panel.add(loreButton);
        panel.add(itemsButton);
        panel.add(runesButton);
        addInitialTable();
        myFrame.add(panel);
        myFrame.setLocationRelativeTo(null);        // Positions Frame in Center.
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }

    private void addInitialTable() throws SQLException {
    }

    /**
     * Returns a connection to the database.
     * @return
     */
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
