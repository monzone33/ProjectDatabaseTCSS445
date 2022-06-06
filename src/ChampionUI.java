import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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

    private void setUpLevel(){
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

        UpdateButton.addActionListener(evt -> updateChampionLevel((String) LevelComboBox.getSelectedItem()));

        getContentPane().add(LevelPanel);
    }

    private void updateChampionLevel(String level){
        System.out.println("Update level " + level);
    }

    private void setUpStatsLabel(String stats) throws SQLException {
        if(stats.equals("HP")) {
            HpPanel = new JPanel();
            HpLabel = new JLabel();
            HpText = new JLabel();
            HpLabel.setText("Health:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                HpText.setText(String.valueOf(result.getInt(1)));
            }
            HpPanel.add(HpLabel);
            HpPanel.add(HpText);
            StatsPanel.add(HpPanel);
        }
        if(stats.equals("HPREGEN")) {
            HpRegenPanel = new JPanel();
            HpRegenLabel = new JLabel();
            HpRegenText = new JLabel();

            HpRegenLabel.setText("HpRegen:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                HpRegenText.setText(String.valueOf(result.getDouble(1)));
            }
            HpRegenPanel.add(HpRegenLabel);
            HpRegenPanel.add(HpRegenText);
            StatsPanel.add(HpRegenPanel);
        }
        if(stats.equals("MANA")) {
            ResourcePanel = new JPanel();
            ResourceLabel = new JLabel();
            ResourcePanelText = new JLabel();

            ResourceLabel.setText("Resource:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                ResourcePanelText.setText(String.valueOf(result.getDouble(1)));
            }
            ResourcePanel.add(ResourceLabel);
            ResourcePanel.add(ResourcePanelText);
            StatsPanel.add(ResourcePanel);
        }
        if(stats.equals("MANAREGEN")) {
            ResourceRegenPanel = new JPanel();
            ResourceRegenLabel = new JLabel();
            ResourceRegenText = new JLabel();

            ResourceLabel.setText("Resource Regen:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                ResourceRegenText.setText(String.valueOf(result.getDouble(1)));
            }
            ResourceRegenPanel.add(ResourceRegenLabel);
            ResourceRegenPanel.add(ResourceRegenText);
            StatsPanel.add(ResourceRegenPanel);
        }
        if(stats.equals("AD")) {
            ADPanel = new JPanel();
            ADLabel = new JLabel();
            ADText = new JLabel();

            ADLabel.setText("AD:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                ADText.setText(String.valueOf(result.getInt(1)));
            }
            ADPanel.add(ADLabel);
            ADPanel.add(ADText);
            StatsPanel.add(ADPanel);
        }
        if(stats.equals("ASN")) {
            AttackSpeedPanel = new JPanel();
            AttackSpeedLabel = new JLabel();
            AttackSpeedText = new JLabel();

            AttackSpeedLabel.setText("Attack Speed:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                AttackSpeedText.setText(String.valueOf(result.getDouble(1)));
            }
            AttackSpeedPanel.add(AttackSpeedLabel);
            AttackSpeedPanel.add(AttackSpeedText);
            StatsPanel.add(AttackSpeedPanel);
        }
        if(stats.equals("ARMOR")) {
            ArmorPanel = new JPanel();
            ArmorLabel = new JLabel();
            ArmorText = new JLabel();

            ArmorLabel.setText("Armor:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                ArmorText.setText(String.valueOf(result.getInt(1)));
            }
            ArmorPanel.add(AttackSpeedLabel);
            ArmorPanel.add(ArmorText);
            StatsPanel.add(ArmorPanel);
        }
        if(stats.equals("MR")) {
            MRPanel = new JPanel();
            MRLabel = new JLabel();
            MRText = new JLabel();

            MRLabel.setText("Magic Resist:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                MRText.setText(String.valueOf(result.getDouble(1)));
            }
            MRPanel.add(MRLabel);
            MRPanel.add(MRText);
            StatsPanel.add(MRPanel);
        }
        if(stats.equals("MS")) {
            MSPanel = new JPanel();
            MSLabel = new JLabel();
            MSText = new JLabel();

            MSLabel.setText("Movement Speed:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                MSText.setText(String.valueOf(result.getDouble(1)));
            }
            MSPanel.add(MSLabel);
            MSPanel.add(MSText);
            StatsPanel.add(MSPanel);
        }
        if(stats.equals("RANGEN")) {
            RangePanel = new JPanel();
            RangeLabel = new JLabel();
            RangeText = new JLabel();

            RangeLabel.setText("Range:");

            String query = "SELECT "+ stats + " FROM CHAMPIONSTATS WHERE NAME = '" + championName +"'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            while (result.next()) {
                RangeText.setText(String.valueOf(result.getInt(1)));
            }
            RangePanel.add(RangeLabel);
            RangePanel.add(RangeText);
            StatsPanel.add(RangePanel);
        }
    }

    private void setUpAllStats() throws SQLException {
        String[] stats = {"HP", "HPREGEN", "MANA", "MANAREGEN", "AD", "ASN","ARMOR","MR","MS","RANGEN"};
        for (int i = 0; i < 10; i++) {
            setUpStatsLabel(stats[i]);
        }
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
        setUpLevel();

        MiddlePanel.setBackground(new java.awt.Color(204, 204, 255));
        MiddlePanel.setLayout(new java.awt.BorderLayout());

        StatsPanel.setBackground(new java.awt.Color(102, 102, 255));
        StatsPanel.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        setUpAllStats();


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
