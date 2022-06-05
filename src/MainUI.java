import javax.swing.*;
import java.sql.*;


public class MainUI extends JFrame{
    private JPanel BottomPanel;
    private JPanel MiddlePanel;
    private JComboBox<String> RaceComboBox;
    private JPanel RaceSortPanel;
    private JLabel RaceText;
    private JComboBox<String> RegionComboBox;
    private JPanel RegionSortPanel;
    private JLabel RegionText;
    private JButton SearchButton;
    private JPanel SearchPanel;
    private JLabel SepciesText;
    private JPanel SortByPanel;
    private JLabel SortByText;
    private JComboBox<String> SpeciesComboBox;
    private JPanel SpeciesSortPanel;
    public Connection connection;

    public MainUI() throws SQLException {
        createGUI();
    }

    public void createGUI() throws SQLException {
        connection = getConnection();
        SearchPanel = new JPanel();
        SortByPanel = new JPanel();
        SortByText = new JLabel();
        RegionSortPanel = new JPanel();
        RegionText = new JLabel();
        RegionComboBox = new JComboBox<>();
        SpeciesSortPanel = new JPanel();
        SepciesText = new JLabel();
        SpeciesComboBox = new JComboBox<>();
        RaceSortPanel = new JPanel();
        RaceText = new JLabel();
        RaceComboBox = new JComboBox<>();
        SearchButton = new JButton();
        MiddlePanel = new JPanel();
        BottomPanel = new JPanel();

        JScrollPane tablePanel = new JScrollPane();
        tablePanel.getViewport().add(addInitialTable());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 102));
        setPreferredSize(new java.awt.Dimension(1200, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        SearchPanel.setBackground(new java.awt.Color(102, 102, 0));

        SortByPanel.setPreferredSize(new java.awt.Dimension(80, 40));

        SortByText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SortByText.setText("SORT BY");
        SortByPanel.add(SortByText);

        SearchPanel.add(SortByPanel);
        RegionSortPanel.setPreferredSize(new java.awt.Dimension(180, 40));

        RegionText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegionText.setText("Region:");
        RegionSortPanel.add(RegionText);

        RegionComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "All", "Bandle City", "Bilgewater", "Blessed Isles", "Demacia", "Freljord", "Ionia", "Ixtal", "Noxus", "Piltover", "Runeterra", "Shadow Isles", "Shurima", "Targon", "Void", "Zaun" }));
        RegionSortPanel.add(RegionComboBox);

        SearchPanel.add(RegionSortPanel);

        SpeciesSortPanel.setPreferredSize(new java.awt.Dimension(180, 40));

        SepciesText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SepciesText.setText("Species:");
        SpeciesSortPanel.add(SepciesText);

        SpeciesComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Ascended", "Celestial", "Demon", "Other", "Sapient", "Spirit", "Undead" }));
        SpeciesSortPanel.add(SpeciesComboBox);

        SearchPanel.add(SpeciesSortPanel);

        RaceSortPanel.setPreferredSize(new java.awt.Dimension(180, 40));

        RaceText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RaceText.setText("Race:");
        RaceSortPanel.add(RaceText);

        RaceComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Aspect Host", "Baccai", "Brackern", "Cat", "Celestial", "Darkin", "God-Warrior", "Golem", "Human", "Minotaur", "Plague Rat", "Revenant", "Spirit", "Spirit God", "Terrestrial Dragon", "Unknown", "Vastayan", "Voidborn", "Wraith", "Yordle", " " }));
        RaceSortPanel.add(RaceComboBox);

        SearchPanel.add(RaceSortPanel);

        SearchButton.setText("Search");
        SearchPanel.add(SearchButton);

        getContentPane().add(SearchPanel);

        MiddlePanel.setBackground(new java.awt.Color(204, 153, 0));

        GroupLayout MiddlePanelLayout = new GroupLayout(MiddlePanel);
        MiddlePanel.setLayout(MiddlePanelLayout);
        MiddlePanelLayout.setHorizontalGroup(
                MiddlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 801, Short.MAX_VALUE)
        );
        MiddlePanelLayout.setVerticalGroup(
                MiddlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 161, Short.MAX_VALUE)
        );
        getContentPane().add(MiddlePanel);

        BottomPanel.setBackground(new java.awt.Color(204, 51, 0));

        GroupLayout BottomPanelLayout = new GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
                BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 801, Short.MAX_VALUE)
        );
        BottomPanelLayout.setVerticalGroup(
                BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 333, Short.MAX_VALUE)
        );

        //getContentPane().add(BottomPanel);
        getContentPane().add(tablePanel);
        pack();
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

    /**
     * Returns a connection to the database.
     */
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/tcss445project";
        String user = "root";
        String password = "Tcss445";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch(final SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
