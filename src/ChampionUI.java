import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class ChampionUI extends JFrame {
    private JPanel ADPanel;
    private JLabel ADLabel;
    private JLabel ADText;
    private JLabel ArmorLabel;
    private JPanel ArmorPanel;
    private JLabel ArmorText;
    private JLabel AttackSpeedLabel;
    private JPanel AttackSpeedPanel;
    private JLabel AttackSpeedText;
    private JPanel BottomPanel;
    private JLabel HpLabel;
    private JPanel HpPanel;
    private JLabel HpRegenLabel;
    private JPanel HpRegenPanel;
    private JLabel HpRegenText;
    private JLabel HpText;
    private JLabel RangeText;
    private JLabel MRLabel;
    private JPanel MRPanel;
    private JLabel MRText;
    private JLabel MSLabel;
    private JPanel MSPanel;
    private JLabel MSText;
    private JPanel MiddlePanel;
    private JLabel NameLabel;
    private JLabel NameText;
    private JLabel RangeLabel;
    private JPanel RangePanel;
    private JLabel ResourceLabel;
    private JPanel ResourcePanel;
    private JLabel ResourcePanelText;
    private JLabel ResourceRegenLabel;
    private JPanel ResourceRegenPanel;
    private JLabel ResourceRegenText;
    private JComboBox<String> LevelComboBox;
    private JLabel LevelLabel;
    private JPanel LevelPanel;
    private JButton UpdateButton;
    private JPanel StatsPanel;
    private JPanel TopPanel;
    private final String championName;
    private final Connection connection;

    public ChampionUI(String championName, Connection connection) throws SQLException {
        this.championName = championName;
        this.connection = connection;
        initComponents();
    }

    private void setUpName() throws SQLException {
        NameLabel = new JLabel();
        NameText = new JLabel();

        NameLabel.setText("Name:");
        String query = "SELECT NAME FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);

        while (result.next()) {
            NameText.setText(result.getString(1));
        }

        TopPanel.add(NameLabel);
        TopPanel.add(NameText);
        getContentPane().add(TopPanel);

    }

    private void setUpLevel(String championName){
        LevelPanel = new JPanel();
        LevelLabel = new JLabel();
        LevelComboBox = new JComboBox<>();
        UpdateButton = new JButton();

        LevelLabel.setText("Level:");
        LevelPanel.add(LevelLabel);

        LevelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18" }));
        LevelPanel.add(LevelComboBox);

        UpdateButton.setText("Update");
        LevelPanel.add(UpdateButton);

        UpdateButton.addActionListener(evt -> {
            try {
                updateChampionLevel((String) Objects.requireNonNull(LevelComboBox.getSelectedItem()),
                        championName);
            } catch(SQLException throwable) {
                throwable.printStackTrace();
            }
        });

        getContentPane().add(LevelPanel);
    }

    private void updateChampionLevel(String level, String championName) throws SQLException {
        System.out.println("Update level " + level);

        setUpStatsLabel();

        if (level.equals("1")) return;

        String query = "SELECT HPPLUS, HPREGENPLUS, MANAPLUS, " +
                "MANAREGENPLUS, ADPLUS, ASNPLUS, ARMORPLUS, MRPLUS " +
                "FROM tcss445project.championstats WHERE NAME = " +"'"+championName +"'";

        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);

        while (result.next()) {
            HpText.setText(String.valueOf(Integer.parseInt(HpText.getText()) +
                    (result.getInt(1)) *Integer.parseInt(level)));

            HpRegenText.setText(String.format("%.2f", (Double.parseDouble(HpRegenText.getText()) +
                    (result.getDouble(2)) * Integer.parseInt(level))));

            ResourcePanelText.setText(String.format("%.2f", (Double.parseDouble(ResourcePanelText.getText()) +
                    (result.getDouble(3)) * Integer.parseInt(level))));

            ResourceRegenText.setText(String.format("%.2f", (Double.parseDouble(ResourceRegenText.getText()) +
                    (result.getDouble(4)) * Integer.parseInt(level))));

            ADText.setText(String.format("%.2f", (Double.parseDouble(ADText.getText()) +
                    (result.getDouble(5)) * Integer.parseInt(level))));

            AttackSpeedText.setText(String.format("%.2f", (Double.parseDouble(AttackSpeedText.getText()) +
                    (result.getDouble(6)) * Integer.parseInt(level))));

            ArmorText.setText(String.format("%.2f", (Double.parseDouble(ArmorText.getText()) +
                    (result.getDouble(7)) * Integer.parseInt(level))));

            MRText.setText(String.format("%.2f", (Double.parseDouble(MRText.getText()) +
                    (result.getDouble(8)) * Integer.parseInt(level))));
        }

    }

    private void setUpStatsLabel() throws SQLException {
        String query = "SELECT HP, HPREGEN, MANA, MANAREGEN, " +
                "AD, ASN, ARMOR, MR FROM tcss445project.championstats";

        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);

        while (result.next()) {
            HpText.setText(String.valueOf(result.getInt(1)));
            HpRegenText.setText(String.valueOf(result.getDouble(2)));
            ResourcePanelText.setText(String.valueOf(result.getDouble(3)));
            ResourceRegenText.setText(String.valueOf(result.getDouble(4)));
            ADText.setText(String.valueOf(result.getInt(5)));
            AttackSpeedText.setText(String.valueOf(result.getDouble(6)));
            ArmorText.setText(String.valueOf(result.getInt(7)));
            MRText.setText(String.valueOf(result.getDouble(8)));
        }

    }

    private void setUpAllStats(String championName) throws SQLException {
        HpPanel = new JPanel();
        HpLabel = new JLabel();
        HpText = new JLabel();
        HpRegenPanel = new JPanel();
        HpRegenLabel = new JLabel();
        HpRegenText = new JLabel();
        ResourcePanel = new JPanel();
        ResourceLabel = new JLabel();
        ResourcePanelText = new JLabel();
        ResourceRegenPanel = new JPanel();
        ResourceRegenLabel = new JLabel();
        ResourceRegenText = new JLabel();
        ADPanel = new JPanel();
        ADLabel = new JLabel();
        ADText = new JLabel();
        AttackSpeedPanel = new JPanel();
        AttackSpeedLabel = new JLabel();
        AttackSpeedText = new JLabel();
        ArmorPanel = new JPanel();
        ArmorLabel = new JLabel();
        ArmorText = new JLabel();
        MRPanel = new JPanel();
        MRLabel = new JLabel();
        MRText = new JLabel();
        MSPanel = new JPanel();
        MSLabel = new JLabel();
        MSText = new JLabel();
        RangePanel = new JPanel();
        RangeLabel = new JLabel();
        RangeText = new JLabel();

        setUpStatsLabel();
        HpLabel.setText("Health:");
        HpRegenLabel.setText("Health Regen:");
        ResourceLabel.setText("Resource:");
        ResourceRegenLabel.setText("Resource Regen:");
        ADLabel.setText("AD:");
        AttackSpeedLabel.setText("Attack Speed:");
        ArmorLabel.setText("Armor:");
        MRLabel.setText("Magic resist:");
        MSLabel.setText("Movement Speed:");
        RangeLabel.setText("Range:");

        String query = "SELECT MS, RANGEN " +
                "FROM tcss445project.championstats WHERE NAME = " +"'" + championName +"'";

        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);

        while (result.next()) {
            MSText.setText(String.valueOf(result.getDouble(1)));
            RangeText.setText(String.valueOf(result.getInt(2)));
        }

        HpPanel.add(HpLabel);
        HpPanel.add(HpText);
        StatsPanel.add(HpPanel);
        HpRegenPanel.add(HpRegenLabel);
        HpRegenPanel.add(HpRegenText);
        StatsPanel.add(HpRegenPanel);
        ResourcePanel.add(ResourceLabel);
        ResourcePanel.add(ResourcePanelText);
        StatsPanel.add(ResourcePanel);
        ResourceRegenPanel.add(ResourceRegenLabel);
        ResourceRegenPanel.add(ResourceRegenText);
        StatsPanel.add(ResourceRegenPanel);
        ADPanel.add(ADLabel);
        ADPanel.add(ADText);
        StatsPanel.add(ADPanel);
        AttackSpeedPanel.add(AttackSpeedLabel);
        AttackSpeedPanel.add(AttackSpeedText);
        StatsPanel.add(AttackSpeedPanel);
        ArmorPanel.add(AttackSpeedLabel);
        ArmorPanel.add(ArmorText);
        StatsPanel.add(ArmorPanel);
        MRPanel.add(MRLabel);
        MRPanel.add(MRText);
        StatsPanel.add(MRPanel);
        MSPanel.add(MSLabel);
        MSPanel.add(MSText);
        StatsPanel.add(MSPanel);
        RangePanel.add(RangeLabel);
        RangePanel.add(RangeText);
        StatsPanel.add(RangePanel);
    }

    private void initComponents() throws SQLException {

        TopPanel = new JPanel();
        MiddlePanel = new JPanel();
        StatsPanel = new JPanel();


        BottomPanel = new JPanel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setPreferredSize(new java.awt.Dimension(450, 650));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setUpName();
        setUpLevel(championName);

        MiddlePanel.setBackground(new java.awt.Color(204, 204, 255));
        MiddlePanel.setLayout(new java.awt.BorderLayout());

        StatsPanel.setBackground(new java.awt.Color(102, 102, 255));
        StatsPanel.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        setUpAllStats(championName);


        MiddlePanel.add(StatsPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(MiddlePanel);

        GroupLayout BottomPanelLayout = new GroupLayout(BottomPanel);
        BottomPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
                BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 410, Short.MAX_VALUE)
        );
        BottomPanelLayout.setVerticalGroup(
                BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 188, Short.MAX_VALUE)
        );

        getContentPane().add(BottomPanel);

        pack();
    }


}
