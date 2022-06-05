import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ChampionUI extends JFrame {
    private JPanel ADPanel;
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
    private JLabel HpText7;
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
    private JPanel StatsPanel;
    private JPanel TopPanel;
    private String championName;
    private Connection connection;

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

        GroupLayout TopPanelLayout = new GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
                TopPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(TopPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(NameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(NameText)
                                .addContainerGap(318, Short.MAX_VALUE))
        );
        TopPanelLayout.setVerticalGroup(
                TopPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(TopPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(NameLabel)
                                        .addComponent(NameText))
                                .addContainerGap(166, Short.MAX_VALUE))
        );

    }

    private void initComponents() throws SQLException {

        TopPanel = new JPanel();

        MiddlePanel = new JPanel();
        StatsPanel = new JPanel();
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
        JLabel ADLabel = new JLabel();
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
        HpText7 = new JLabel();
        BottomPanel = new JPanel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setPreferredSize(new java.awt.Dimension(450, 650));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setUpName();

        getContentPane().add(TopPanel);

        MiddlePanel.setBackground(new java.awt.Color(204, 204, 255));
        MiddlePanel.setLayout(new java.awt.BorderLayout());

        StatsPanel.setBackground(new java.awt.Color(102, 102, 255));
        StatsPanel.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        HpLabel.setText("Health:");

        HpText.setText("300");

        GroupLayout HpPanelLayout = new GroupLayout(HpPanel);
        HpPanel.setLayout(HpPanelLayout);
        HpPanelLayout.setHorizontalGroup(
                HpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(HpPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(HpLabel)
                                .addGap(18, 18, 18)
                                .addComponent(HpText)
                                .addContainerGap(122, Short.MAX_VALUE))
        );
        HpPanelLayout.setVerticalGroup(
                HpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(HpPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(HpPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(HpLabel)
                                        .addComponent(HpText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(HpPanel);

        HpRegenLabel.setText("HpRegen:");

        HpRegenText.setText("300");

        GroupLayout HpRegenPanelLayout = new GroupLayout(HpRegenPanel);
        HpRegenPanel.setLayout(HpRegenPanelLayout);
        HpRegenPanelLayout.setHorizontalGroup(
                HpRegenPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(HpRegenPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(HpRegenLabel)
                                .addGap(18, 18, 18)
                                .addComponent(HpRegenText)
                                .addContainerGap(108, Short.MAX_VALUE))
        );
        HpRegenPanelLayout.setVerticalGroup(
                HpRegenPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(HpRegenPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(HpRegenPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(HpRegenLabel)
                                        .addComponent(HpRegenText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(HpRegenPanel);

        ResourceLabel.setText("Resource:");

        ResourcePanelText.setText("300");

        GroupLayout ResourcePanelLayout = new GroupLayout(ResourcePanel);
        ResourcePanel.setLayout(ResourcePanelLayout);
        ResourcePanelLayout.setHorizontalGroup(
                ResourcePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ResourcePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ResourceLabel)
                                .addGap(18, 18, 18)
                                .addComponent(ResourcePanelText)
                                .addContainerGap(109, Short.MAX_VALUE))
        );
        ResourcePanelLayout.setVerticalGroup(
                ResourcePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ResourcePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ResourcePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ResourceLabel)
                                        .addComponent(ResourcePanelText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(ResourcePanel);

        ResourceRegenLabel.setText("ResourceRegen:");

        ResourceRegenText.setText("300");

        GroupLayout ResourceRegenPanelLayout = new GroupLayout(ResourceRegenPanel);
        ResourceRegenPanel.setLayout(ResourceRegenPanelLayout);
        ResourceRegenPanelLayout.setHorizontalGroup(
                ResourceRegenPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ResourceRegenPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ResourceRegenLabel)
                                .addGap(18, 18, 18)
                                .addComponent(ResourceRegenText)
                                .addContainerGap(76, Short.MAX_VALUE))
        );
        ResourceRegenPanelLayout.setVerticalGroup(
                ResourceRegenPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ResourceRegenPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ResourceRegenPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ResourceRegenLabel)
                                        .addComponent(ResourceRegenText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(ResourceRegenPanel);

        ADLabel.setText("AD:");

        ADText.setText("300");

        GroupLayout ADPanelLayout = new GroupLayout(ADPanel);
        ADPanel.setLayout(ADPanelLayout);
        ADPanelLayout.setHorizontalGroup(
                ADPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ADPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ADLabel)
                                .addGap(18, 18, 18)
                                .addComponent(ADText)
                                .addContainerGap(141, Short.MAX_VALUE))
        );
        ADPanelLayout.setVerticalGroup(
                ADPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ADPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ADPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ADLabel)
                                        .addComponent(ADText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(ADPanel);

        AttackSpeedLabel.setText("AttackSpeed:");

        AttackSpeedText.setText("300");

        GroupLayout AttackSpeedPanelLayout = new GroupLayout(AttackSpeedPanel);
        AttackSpeedPanel.setLayout(AttackSpeedPanelLayout);
        AttackSpeedPanelLayout.setHorizontalGroup(
                AttackSpeedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(AttackSpeedPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AttackSpeedLabel)
                                .addGap(18, 18, 18)
                                .addComponent(AttackSpeedText)
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        AttackSpeedPanelLayout.setVerticalGroup(
                AttackSpeedPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(AttackSpeedPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(AttackSpeedPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(AttackSpeedLabel)
                                        .addComponent(AttackSpeedText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(AttackSpeedPanel);

        ArmorLabel.setText("Armor:");

        ArmorText.setText("300");

        GroupLayout ArmorPanelLayout = new GroupLayout(ArmorPanel);
        ArmorPanel.setLayout(ArmorPanelLayout);
        ArmorPanelLayout.setHorizontalGroup(
                ArmorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ArmorPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ArmorLabel)
                                .addGap(18, 18, 18)
                                .addComponent(ArmorText)
                                .addContainerGap(123, Short.MAX_VALUE))
        );
        ArmorPanelLayout.setVerticalGroup(
                ArmorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ArmorPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ArmorPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ArmorLabel)
                                        .addComponent(ArmorText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(ArmorPanel);

        MRLabel.setText("MR:");

        MRText.setText("300");

        GroupLayout MRPanelLayout = new GroupLayout(MRPanel);
        MRPanel.setLayout(MRPanelLayout);
        MRPanelLayout.setHorizontalGroup(
                MRPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(MRPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(MRLabel)
                                .addGap(18, 18, 18)
                                .addComponent(MRText)
                                .addContainerGap(139, Short.MAX_VALUE))
        );
        MRPanelLayout.setVerticalGroup(
                MRPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(MRPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(MRPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(MRLabel)
                                        .addComponent(MRText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(MRPanel);

        MSLabel.setText("MS:");

        MSText.setText("300");

        GroupLayout MSPanelLayout = new GroupLayout(MSPanel);
        MSPanel.setLayout(MSPanelLayout);
        MSPanelLayout.setHorizontalGroup(
                MSPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(MSPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(MSLabel)
                                .addGap(18, 18, 18)
                                .addComponent(MSText)
                                .addContainerGap(140, Short.MAX_VALUE))
        );
        MSPanelLayout.setVerticalGroup(
                MSPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(MSPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(MSPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(MSLabel)
                                        .addComponent(MSText))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(MSPanel);

        RangeLabel.setText("Range:");

        HpText7.setText("300");

        GroupLayout RangePanelLayout = new GroupLayout(RangePanel);
        RangePanel.setLayout(RangePanelLayout);
        RangePanelLayout.setHorizontalGroup(
                RangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(RangePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(RangeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(HpText7)
                                .addContainerGap(124, Short.MAX_VALUE))
        );
        RangePanelLayout.setVerticalGroup(
                RangePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(RangePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(RangePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(RangeLabel)
                                        .addComponent(HpText7))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        StatsPanel.add(RangePanel);

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
