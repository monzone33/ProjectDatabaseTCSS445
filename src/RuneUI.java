import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RuneUI extends JFrame {
    private JLabel nameLabel;
    private JLabel nameText;
    private JPanel pathPanel;
    private JLabel pathLabel;
    private JLabel pathText;
    private JPanel keystonePanel;
    private JLabel keystoneLabel;
    private JLabel keystoneText;
    private JPanel shardPanel;
    private JLabel shardLabel;
    private JLabel shardText;
    private JPanel cooldownPanel;
    private JLabel cooldownLabel;
    private JLabel cooldownText;
    private JPanel damagePanel;
    private JLabel damageLabel;
    private JLabel damageText;
    private JPanel percentDamagePanel;
    private JLabel percentDamageLabel;
    private JLabel percentDamageText;
    private JPanel lethalityPanel;
    private JLabel lethalityLabel;
    private JLabel lethalityText;
    private JPanel magicPenPanel;
    private JLabel magicPenLabel;
    private JLabel magicPenText;
    private JPanel shieldingPanel;
    private JLabel shieldingLabel;
    private JLabel shieldingText;
    private JPanel percentShieldPanel;
    private JLabel percentShieldLabel;
    private JLabel percentShieldText;
    private JPanel attackSpeedPanel;
    private JLabel attackSpeedLabel;
    private JLabel attackSpeedText;
    private JPanel tenacityPanel;
    private JLabel tenacityLabel;
    private JLabel tenacityText;
    private JPanel lifeStealPanel;
    private JLabel lifeStealLabel;
    private JLabel lifeStealText;
    private JPanel abilityHastePanel;
    private JLabel abilityHasteLabel;
    private JLabel abilityHasteText;
    private JPanel itemHastePanel;
    private JLabel itemHasteLabel;
    private JLabel itemHasteText;
    private JPanel spellHastePanel;
    private JLabel spellHasteLabel;
    private JLabel spellHasteText;
    private JPanel rangePanel;
    private JLabel rangeLabel;
    private JLabel rangeText;
    private JPanel healPanel;
    private JLabel healLabel;
    private JLabel healText;
    private JPanel percentHealPanel;
    private JLabel percentHealLabel;
    private JLabel percentHealText;
    private JPanel MSPanel;
    private JLabel MSLabel;
    private JLabel MSText;
    private JPanel percentMSPanel;
    private JLabel percentMSLabel;
    private JLabel percentMSText;
    private JPanel ADPanel;
    private JLabel ADLabel;
    private JLabel ADText;
    private JPanel APPanel;
    private JLabel APLabel;
    private JLabel APText;
    private JPanel HPPanel;
    private JLabel HPLabel;
    private JLabel HPText;
    private JPanel percentHPPanel;
    private JLabel percentHPLabel;
    private JLabel percentHPText;
    private JPanel manaPanel;
    private JLabel manaLabel;
    private JLabel manaText;
    private JPanel percentManaPanel;
    private JLabel percentManaLabel;
    private JLabel percentManaText;
    private JPanel armorPanel;
    private JLabel armorLabel;
    private JLabel armorText;
    private JPanel MRPanel;
    private JLabel MRLabel;
    private JLabel MRText;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel botPanel;
    private JPanel statsPanel;
    private final String runeName;
    private final Connection connection;

    public RuneUI(String runeName, Connection connection) throws SQLException {
        this.runeName = runeName;
        this.connection = connection;
        initComponents();
    }

    private void setUpRuneName() throws SQLException {
        nameLabel = new JLabel();
        nameText = new JLabel();

        nameLabel.setText("Rune Name:");
        String query = "SELECT RUNE_NAME FROM RUNES WHERE RUNE_NAME = '" + runeName + "'";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);

        while (result.next()) {
            nameText.setText(result.getString(1));
        }

        topPanel.add(nameLabel);
        topPanel.add(nameText);
        getContentPane().add(topPanel);
    }

    private void statLabel() throws SQLException {
        String query = "SELECT RUNE_PATHS, KEYSTONE, SHARD, COOLDOWN, " +
                "DAMAGE, PERCENTAGE_DAMAGE,LETHALITY, MAGIC_PEN, SHIELDING, PERCENTAGE_SHIELDING, " +
                "ATTACK_SPEED,  TENACITY, LIFE_STEAL, ABILITY_HASTE, ITEM_HASTE, SUMMONER_SPELL_HASTE, " +
                "RANGE, HEAL, PERCENTAGE_HEAL, MOVEMENT_SPEED_FLAT, MOVEMENT_SPEED_PERCENTAGE, " +
                "ATTACK_DAMAGE, ABILITY_POWER, HEALTH, HEALTH_PERCENTAGE, MANA, PERCENTAGE_MANA, ARMOR, MAGIC_RESIST " +
                "FROM tcss445project.championstats";

        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);

        while (result.next()) {
            pathText.setText(result.getString(1));
            keystoneText.setText(String.valueOf(result.getInt(2)));
            shardText.setText(String.valueOf(result.getInt(3)));
            cooldownText.setText(String.valueOf(result.getInt(4)));
            damageText.setText(String.valueOf(result.getInt(5)));
            percentDamageText.setText(String.valueOf(result.getInt(6)));
            lethalityText.setText(String.valueOf(result.getInt(7)));
            magicPenText.setText(String.valueOf(result.getInt(8)));
            shieldingText.setText(String.valueOf(result.getInt(9)));
            percentShieldText.setText(String.valueOf(result.getInt(10)));
            attackSpeedText.setText(String.valueOf(result.getInt(11)));
            tenacityText.setText(String.valueOf(result.getInt(12)));
            lifeStealText.setText(String.valueOf(result.getInt(13)));
            abilityHasteText.setText(String.valueOf(result.getInt(14)));
            itemHasteText.setText(String.valueOf(result.getInt(15)));
            spellHasteText.setText(String.valueOf(result.getInt(16)));
            rangeText.setText(String.valueOf(result.getInt(17)));
            healText.setText(String.valueOf(result.getInt(18)));
            percentHealText.setText(String.valueOf(result.getInt(19)));
            MSText.setText(String.valueOf(result.getInt(20)));
            percentMSLabel.setText(String.valueOf(result.getInt(21)));
            ADText.setText(String.valueOf(result.getInt(22)));
            APText.setText(String.valueOf(result.getInt(23)));
            HPText.setText(String.valueOf(result.getInt(24)));
            percentHPText.setText(String.valueOf(result.getInt(25)));
            manaText.setText(String.valueOf(result.getInt(26)));
            percentManaText.setText(String.valueOf(result.getInt(27)));
            armorText.setText(String.valueOf(result.getInt(28)));
            MRText.setText(String.valueOf(result.getInt(29)));
        }
    }

    private void allStats(String runeName) throws SQLException {
        pathPanel = new JPanel();
        pathLabel = new JLabel();
        pathText = new JLabel();
        keystonePanel = new JPanel();
        keystoneLabel = new JLabel();
        keystoneText = new JLabel();
        shardPanel = new JPanel();
        shardLabel = new JLabel();
        shardText = new JLabel();
        cooldownPanel = new JPanel();
        cooldownLabel = new JLabel();
        cooldownText = new JLabel();
        damagePanel = new JPanel();
        damageLabel = new JLabel();
        damageText = new JLabel();
        percentDamagePanel = new JPanel();
        percentDamageLabel = new JLabel();
        percentDamageText = new JLabel();
        lethalityPanel = new JPanel();
        lethalityLabel = new JLabel();
        lethalityText = new JLabel();
        magicPenPanel = new JPanel();
        magicPenLabel = new JLabel();
        magicPenText = new JLabel();
        shieldingPanel = new JPanel();
        shieldingLabel = new JLabel();
        shieldingText = new JLabel();
        percentShieldPanel = new JPanel();
        percentShieldLabel = new JLabel();
        percentShieldText = new JLabel();
        attackSpeedPanel = new JPanel();
        attackSpeedLabel = new JLabel();
        attackSpeedText = new JLabel();
        tenacityPanel = new JPanel();
        tenacityLabel = new JLabel();
        tenacityText = new JLabel();
        lifeStealPanel = new JPanel();
        lifeStealLabel = new JLabel();
        lifeStealText = new JLabel();
        abilityHastePanel = new JPanel();
        abilityHasteLabel = new JLabel();
        abilityHasteText = new JLabel();
        itemHastePanel = new JPanel();
        itemHasteLabel = new JLabel();
        itemHasteText = new JLabel();
        spellHastePanel = new JPanel();
        spellHasteLabel = new JLabel();
        spellHasteText = new JLabel();
        rangePanel = new JPanel();
        rangeLabel = new JLabel();
        rangeText = new JLabel();
        healPanel = new JPanel();
        healLabel = new JLabel();
        healText = new JLabel();
        percentHealPanel = new JPanel();
        percentHealLabel = new JLabel();
        percentHealText = new JLabel();
        MSPanel = new JPanel();
        MSLabel = new JLabel();
        MSText = new JLabel();
        percentMSPanel = new JPanel();
        percentMSLabel = new JLabel();
        percentMSText = new JLabel();
        ADPanel = new JPanel();
        ADLabel = new JLabel();
        ADText = new JLabel();
        APPanel = new JPanel();
        APLabel = new JLabel();
        APText = new JLabel();
        HPPanel = new JPanel();
        HPLabel = new JLabel();
        HPText = new JLabel();
        percentHPPanel = new JPanel();
        percentHPLabel = new JLabel();
        percentHPText = new JLabel();
        manaPanel = new JPanel();
        manaLabel = new JLabel();
        manaText = new JLabel();
        percentManaPanel = new JPanel();
        percentManaLabel = new JLabel();
        percentManaText = new JLabel();
        armorPanel = new JPanel();
        armorLabel = new JLabel();
        armorText = new JLabel();
        MRPanel = new JPanel();
        MRLabel = new JLabel();
        MRText = new JLabel();

        statLabel();
        pathLabel.setText("Path:");
        keystoneLabel.setText("Keystone:");
        shardLabel.setText("Shard:");
        cooldownLabel.setText("Cooldown:");
        damageLabel.setText("Damage:");
        percentDamageLabel.setText("Percent Damage:");
        lethalityLabel.setText("Lethality:");
        magicPenLabel.setText("Magic Pen:");
        shieldingLabel.setText("Shielding:");
        percentShieldLabel.setText("Percent Shielding:");
        attackSpeedLabel.setText("Attack Speed:");
        tenacityLabel.setText("Tenacity:");
        lifeStealLabel.setText("Life Steal:");
        abilityHasteLabel.setText("Ability Haste:");
        itemHasteLabel.setText("item Haste:");
        spellHasteLabel.setText("Spell Haste:");
        rangeLabel.setText("Range:");
        healLabel.setText("Heal:");
        percentHealLabel.setText("Percent Heal:");
        MSLabel.setText("Move Speed:");
        percentMSLabel.setText("Percent Move Speed:");
        ADLabel.setText("AD:");
        APLabel.setText("AP:");
        HPLabel.setText("HP:");
        percentHPLabel.setText("Percent HP:");
        manaLabel.setText("Mana:");
        percentManaLabel.setText("Percent Mana:");
        armorLabel.setText("Armor:");
        MRLabel.setText("Magic Resist:");

        pathPanel.add(pathLabel);
        pathPanel.add(pathText);
        statsPanel.add(pathPanel);
        keystonePanel.add(keystoneLabel);
        keystonePanel.add(keystoneText);
        statsPanel.add(keystonePanel);
        shardPanel.add(shardLabel);
        shardPanel.add(shardText);
        statsPanel.add(shardPanel);
        cooldownPanel.add(cooldownLabel);
        cooldownPanel.add(cooldownText);
        statsPanel.add(cooldownPanel);
        damagePanel.add(damageLabel);
        damagePanel.add(damageText);
        statsPanel.add(damagePanel);
        percentDamagePanel.add(percentDamageLabel);
        percentDamagePanel.add(percentDamageText);
        statsPanel.add(percentDamagePanel);
        lethalityPanel.add(lethalityLabel);
        lethalityPanel.add(lethalityText);
        statsPanel.add(lethalityPanel);
        magicPenPanel.add(magicPenLabel);
        magicPenPanel.add(magicPenText);
        statsPanel.add(magicPenPanel);
        shieldingPanel.add(shieldingLabel);
        shieldingPanel.add(shieldingText);
        statsPanel.add(shieldingPanel);
        percentShieldPanel.add(percentShieldLabel);
        percentShieldPanel.add(percentShieldText);
        statsPanel.add(percentShieldPanel);
        attackSpeedPanel.add(attackSpeedLabel);
        attackSpeedPanel.add(attackSpeedText);
        statsPanel.add(attackSpeedPanel);
        tenacityPanel.add(tenacityLabel);
        tenacityPanel.add(tenacityText);
        statsPanel.add(tenacityPanel);
        lifeStealPanel.add(lifeStealLabel);
        lifeStealPanel.add(lifeStealText);
        statsPanel.add(lifeStealPanel);
        abilityHastePanel.add(abilityHasteLabel);
        abilityHastePanel.add(abilityHasteText);
        statsPanel.add(abilityHastePanel);
        itemHastePanel.add(itemHasteLabel);
        itemHastePanel.add(itemHasteText);
        statsPanel.add(itemHastePanel);
        spellHastePanel.add(spellHasteLabel);
        spellHastePanel.add(spellHasteText);
        statsPanel.add(spellHastePanel);
        rangePanel.add(rangeLabel);
        rangePanel.add(rangeText);
        statsPanel.add(rangePanel);
        healPanel.add(healLabel);
        healPanel.add(healText);
        statsPanel.add(healPanel);
        percentHealPanel.add(percentHealLabel);
        percentHealPanel.add(percentHealText);
        statsPanel.add(percentHealPanel);
        MSPanel.add(MSLabel);
        MSPanel.add(MSText);
        statsPanel.add(MSPanel);
        percentMSPanel.add(percentMSLabel);
        percentMSPanel.add(percentMSText);
        statsPanel.add(percentMSPanel);
        ADPanel.add(ADLabel);
        ADPanel.add(ADText);
        statsPanel.add(ADPanel);
        APPanel.add(APLabel );
        APPanel.add(APText);
        statsPanel.add(APPanel);
        HPPanel.add(HPLabel);
        HPPanel.add(HPText);
        statsPanel.add(HPPanel);
        percentHPPanel.add(percentHPLabel);
        percentHPPanel.add(percentHPText);
        statsPanel.add(percentHPPanel);
        manaPanel.add(manaLabel);
        manaPanel.add(manaText);
        statsPanel.add(manaPanel);
        percentManaPanel.add(percentManaLabel);
        percentManaPanel.add(percentManaText);
        statsPanel.add(percentManaPanel);
        armorPanel.add(armorLabel);
        armorPanel.add(armorText);
        statsPanel.add(armorPanel);
        MRPanel.add(MRLabel);
        MRPanel.add(MRText);
        statsPanel.add(MRPanel);
    }

    private void initComponents() throws SQLException {
        topPanel = new JPanel();
        middlePanel = new JPanel();
        statsPanel = new JPanel();
        botPanel = new JPanel();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setPreferredSize(new java.awt.Dimension(450, 650));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        setUpRuneName();

        middlePanel.setBackground(new java.awt.Color(204, 204, 255));
        middlePanel.setLayout(new java.awt.BorderLayout());

        statsPanel.setBackground(new java.awt.Color(102, 102, 255));
        statsPanel.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        allStats(runeName);


        middlePanel.add(statsPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(middlePanel);

        GroupLayout BottomPanelLayout = new GroupLayout(botPanel);
        botPanel.setLayout(BottomPanelLayout);
        BottomPanelLayout.setHorizontalGroup(
                BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 410, Short.MAX_VALUE)
        );
        BottomPanelLayout.setVerticalGroup(
                BottomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 188, Short.MAX_VALUE)
        );

        getContentPane().add(botPanel);

    }
}
