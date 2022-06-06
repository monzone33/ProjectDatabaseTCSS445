import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RuneUI {
    private JPanel namePanel;
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
    private final String runeName;
    private final Connection connection;

    public RuneUI(String runeName, Connection connection) throws SQLException{
        this.runeName = runeName;
        this.connection = connection;

    }

    private void setUpRuneName() throws SQLException{
        nameLabel = new JLabel();
        nameText = new JLabel();

        nameLabel.setText("Rune Name:");
        String query = "SELECT RUNE_NAME FROM RUNES WHERE RUNE_NAME = '" + runeName + "'";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(query);

        while (result.next()){
            nameText.setText(result.getString(1));
        }


    }

























    private void setUpRune() throws SQLException {

    }
}
