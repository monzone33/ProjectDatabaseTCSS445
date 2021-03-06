import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.*;


public class MainUI extends JFrame{
    private JPanel BottomPanel;
    private JPanel SearchResultPanel;
    private JScrollPane SearchResultScrollPane;
    private JComboBox<String> RaceComboBox;
    private JPanel RaceSortPanel;
    private JLabel RaceText;
    private JComboBox<String> RegionComboBox;
    private JPanel RegionSortPanel;
    private JLabel RegionText;
    private JButton SearchButton;
    private JButton itemsButton;
    private JButton runesButton;
    private JButton championButton;
    private JPanel SearchPanel;
    private JLabel SpeciesText;
    private JPanel SearchByPanel;
    private JLabel SearchByText;
    private JComboBox<String> SpeciesComboBox;
    private JPanel SpeciesSortPanel;
    private JScrollPane tablePanel;
    public Connection connection;

    public MainUI() throws SQLException {
        createGUI();
    }

    private void initComponents(){
        SearchPanel = new JPanel();
        SearchByPanel = new JPanel();
        SearchByText = new JLabel();
        RegionSortPanel = new JPanel();
        RegionText = new JLabel();
        RegionComboBox = new JComboBox<>();
        SpeciesSortPanel = new JPanel();
        SpeciesText = new JLabel();
        SpeciesComboBox = new JComboBox<>();
        RaceSortPanel = new JPanel();
        RaceText = new JLabel();
        RaceComboBox = new JComboBox<>();
        SearchButton = new JButton();
        itemsButton = new JButton();
        runesButton = new JButton();
        championButton = new JButton();
        BottomPanel = new JPanel();
        SearchResultScrollPane = new JScrollPane();
        SearchResultPanel = new JPanel();
    }

    private void mainFrameSetup(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 102));
        setPreferredSize(new java.awt.Dimension(1200, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    private void searchPanelSetup(){
        SearchPanel.setBackground(new java.awt.Color(102, 102, 0));

        SearchByPanel.setPreferredSize(new java.awt.Dimension(80, 40));

        SearchByText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SearchByText.setText("Search by");
        SearchByPanel.add(SearchByText);

        SearchPanel.add(SearchByPanel);
        RegionSortPanel.setPreferredSize(new java.awt.Dimension(180, 40));

        RegionText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RegionText.setText("Region:");
        RegionSortPanel.add(RegionText);

        RegionComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "All", "Bandle City", "Bilgewater", "Blessed Isles", "Demacia", "Freljord", "Ionia", "Ixtal",
                "Noxus", "Piltover", "Runeterra", "Shadow Isles", "Shurima", "Targon", "Void", "Zaun" }));
        RegionSortPanel.add(RegionComboBox);

        SearchPanel.add(RegionSortPanel);

        SpeciesSortPanel.setPreferredSize(new java.awt.Dimension(180, 40));

        SpeciesText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SpeciesText.setText("Species:");
        SpeciesSortPanel.add(SpeciesText);

        SpeciesComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "All","Ascended", "Celestial", "Demon", "Other", "Sapient", "Spirit", "Undead" }));
        SpeciesSortPanel.add(SpeciesComboBox);

        SearchPanel.add(SpeciesSortPanel);

        RaceSortPanel.setPreferredSize(new java.awt.Dimension(180, 40));

        RaceText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RaceText.setText("Race:");
        RaceSortPanel.add(RaceText);

        RaceComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "All","Aspect Host", "Baccai", "Brackern", "Cat", "Celestial", "Darkin",
                "God-Warrior", "Golem", "Human", "Minotaur", "Plague Rat", "Revenant", "Spirit", "Spirit God", "Terrestrial Dragon", "Unknown",
                "Vastayan", "Voidborn", "Wraith", "Yordle" }));
        RaceSortPanel.add(RaceComboBox);

        SearchPanel.add(RaceSortPanel);

        SearchButton.setText("Search");

        SearchButton.addActionListener(evt -> {
            try {
                SearchButtonActionPerformed();
            } catch(SQLException throwable) {
                throwable.printStackTrace();
            }
        });

        itemsButton.setText("Items");

        itemsButton.addActionListener(evt -> {
            try {
                itemsButton();
            } catch(SQLException throwable) {
                throwable.printStackTrace();
            }
        });
        runesButton.setText("Runes");

        runesButton.addActionListener(evt -> {
            try {
                runeButton();
            } catch(SQLException throwable) {
                throwable.printStackTrace();
            }
        });

        championButton.setText("ChampionStats");
        championButton.addActionListener(evt -> {
            try {
                getContentPane().remove(tablePanel);
                tablePanel = new JScrollPane(addInitialTable(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                getContentPane().add(tablePanel);
                pack();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        SearchPanel.add(SearchButton);
        SearchPanel.add(itemsButton);
        SearchPanel.add(runesButton);
        SearchPanel.add(championButton);
    }

    private void searchResultSetup() throws SQLException {
        //SearchResultScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SearchResultPanel.setBackground(new java.awt.Color(204, 153, 0));
        SearchResultPanel.setLayout(new java.awt.GridLayout(12, 5, 5, 5));
        SearchResultScrollPane.setViewportView(SearchResultPanel);

        getContentPane().add(SearchResultScrollPane);

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

        tablePanel = new JScrollPane();
        tablePanel.getViewport().add(addInitialTable());
    }

    public void createGUI() throws SQLException {
        connection = getConnection();
        initComponents();
        mainFrameSetup();
        searchPanelSetup();
        getContentPane().add(SearchPanel);
        searchResultSetup();
        getContentPane().add(tablePanel);
        pack();
    }

    private void SearchButtonActionPerformed() throws SQLException {
        System.out.println(RegionComboBox.getSelectedItem());
        System.out.println(SpeciesComboBox.getSelectedItem());
        System.out.println(RaceComboBox.getSelectedItem());
        System.out.println("Update table");
        SearchResultPanel.removeAll();
        championSearch();
        SearchResultScrollPane.setViewportView(SearchResultPanel);
        pack();
    }


    private void ChampionButtonPressed(String ChampName, Connection connection) throws SQLException {
        System.out.println(ChampName);
        new ChampionUI(ChampName, connection).setVisible(true);
    }

    private void championSearch() throws SQLException {
        String query = "SELECT NAME FROM lore";

        if (!RegionComboBox.getSelectedItem().equals("All")) {
            query += " WHERE REGION = " + "'"+ RegionComboBox.getSelectedItem()+ "'";
        }
        if (!SpeciesComboBox.getSelectedItem().equals("All")){
            if (query.endsWith("lore")){
                query += " WHERE SPECIES = " + "'"+ SpeciesComboBox.getSelectedItem()+ "'";
            } else {
                query += " AND SPECIES = " + "'"+ SpeciesComboBox.getSelectedItem()+ "'";
            }
        }
        if (!RaceComboBox.getSelectedItem().equals("All")){
            if (query.endsWith("lore")) {
                query += " WHERE RACE = " + "'" + RaceComboBox.getSelectedItem()+ "'";
            } else {
                query += " AND RACE = " + "'" + RaceComboBox.getSelectedItem()+ "'";
            }
        }
        System.out.println(query);
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        SearchResultPanel.removeAll();
        while (result.next()) {
            JButton button = new JButton();
            button.setText(result.getString(1));
            SearchResultPanel.add(button);

            button.addActionListener(evt -> {
                try {
                    ChampionButtonPressed(button.getText(), connection);
                } catch(SQLException throwable) {
                    throwable.printStackTrace();
                }
            });
        }

    }

    private JTable addInitialTable() throws SQLException {
        String columns[] = {"Name", "HP", "HP+", "HPREGEN", "HPREGEN+", "MANA", "MANA+", "MANAREG", "MANAREG+",
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

    public void itemsButton() throws SQLException {
        String[] columns = {"NAME", "GRADE", "Cost", "HEALTH", "MANA", "HPHREGEN",
                            "MANARE", "ABILITYHASTE", "ATTACKDAMAGE", "ATTACKSPEED",
                            "CRITICALCHANCE", "LIFESTEAL", "OMNIVAMP", "LETHALITY", "ARMORPENETRATION",
                            "ABILITYPOWER", "MAGICPENETRATION", "ARMOR", "MAGICRESIST", "MOVEMENTSPEED"};
        String[][] itemRows = new String[206][20];
        String query = "SELECT * FROM ITEM_STATS";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        int row = 0;
        while (result.next()) {
            itemRows[row][0] = result.getString(1);
            itemRows[row][1] = "" + result.getString(2);
            itemRows[row][2] = "" + result.getInt(3);
            itemRows[row][3] = "" + result.getInt(4);
            itemRows[row][4] = "" + result.getInt(5);
            itemRows[row][5] = "" + result.getDouble(6);
            itemRows[row][6] = "" + result.getDouble(7);
            itemRows[row][7] = "" + result.getDouble(8);
            itemRows[row][8] = "" + result.getInt(9);
            itemRows[row][9] = "" + result.getDouble(10);
            itemRows[row][10] = "" + result.getDouble(11);
            itemRows[row][11] = "" + result.getDouble(12);
            itemRows[row][12] = "" + result.getDouble(13);
            itemRows[row][13] = "" + result.getDouble(14);
            itemRows[row][14] = "" + result.getDouble(15);
            itemRows[row][15] = "" + result.getInt(16);
            itemRows[row][16] = "" + result.getDouble(17);
            itemRows[row][17] = "" + result.getInt(18);
            itemRows[row][18] = "" + result.getInt(19);
            itemRows[row][19] = "" + result.getDouble(19);
            row++;
        }
        JTable itemsTable = new JTable(itemRows, columns) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
            }
        };
        getContentPane().remove(tablePanel);
        itemsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablePanel = new JScrollPane(itemsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(tablePanel);
        pack();
    }

    public void runeButton()throws SQLException{
        String[] columns = {" ", "PATH", "KEYSTONE", "SHARD", "COOLDOWN", "DAMAGE", "PERCENTDAMAGE", "LETHALITY", "MAGICPENETRATION", "SHIELDING",
                "PERCENTSHIELDING", "ATTACKSPEED", "TENACITY", "LIFESTEAL", "ABILITYHASTE", "ITEMHASTE", "SPELLHASTE", "RANGE", "HEAL", "PERCENTHEAL",
                "MOVEMENTSPEED", "PERCENTMOVEMENTSPEED", "ATTACKDAMAGE", "ABILITYPOWER", "HEALTH", "PERCENTHEALTH", "MANA", "PERCENTMANA", "ARMOR", "MAGICRESIST"};

        String[][] runeRows = new String[63][30];
        String query = "SELECT * FROM RUNES";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);
        int row = 0;
        while (result.next()) {
            runeRows[row][0] = result.getString(1);
            runeRows[row][1] = result.getString(2);
            runeRows[row][2] = result.getString(3);
            runeRows[row][3] = result.getString(4);
            runeRows[row][4] = result.getString(5);
            runeRows[row][5] = result.getString(6);
            runeRows[row][6] = result.getString(7);
            runeRows[row][7] = result.getString(8);
            runeRows[row][8] = result.getString(9);
            runeRows[row][9] = result.getString(10);
            runeRows[row][10] = result.getString(11);
            runeRows[row][11] = result.getString(12);
            runeRows[row][12] = result.getString(13);
            runeRows[row][13] = result.getString(14);
            runeRows[row][14] = result.getString(15);
            runeRows[row][15] = result.getString(16);
            runeRows[row][16] = result.getString(17);
            runeRows[row][17] = result.getString(18);
            runeRows[row][18] = result.getString(19);
            runeRows[row][19] = result.getString(20);
            runeRows[row][20] = result.getString(21);
            runeRows[row][21] = result.getString(22);
            runeRows[row][22] = result.getString(23);
            runeRows[row][23] = result.getString(24);
            runeRows[row][24] = result.getString(25);
            runeRows[row][25] = result.getString(26);
            runeRows[row][26] = result.getString(27);
            runeRows[row][27] = result.getString(28);
            runeRows[row][28] = result.getString(29);
            runeRows[row][29] = result.getString(30);
            row++;
        }

        JTable runesTable = new JTable(runeRows, columns) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                return component;
            }
        };
        getContentPane().remove(tablePanel);
        runesTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablePanel = new JScrollPane(runesTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(tablePanel);
        pack();
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
