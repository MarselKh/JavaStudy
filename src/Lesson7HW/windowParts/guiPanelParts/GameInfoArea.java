package Lesson7HW.windowParts.guiPanelParts;


import javax.swing.*;
import java.awt.*;

public class GameInfoArea extends JPanel {


    private String prefixEnemyCount = "Enemies: ";
    private String prefixLevel = "Level: ";
    private String prefixSizeMap = "Size Map: ";

      private JLabel enemyCount;
    private JLabel levelGame;
    private JLabel sizeMap;

    public GameInfoArea () {
        setLayout(new GridLayout(4,1));
        enemyCount = new JLabel(prefixEnemyCount + "-");
        levelGame = new JLabel(prefixLevel + "-");
        sizeMap = new JLabel(prefixSizeMap + "-");
        add(new JLabel("Player Info", SwingConstants.CENTER));
        add(enemyCount);
        add(levelGame);
        add(sizeMap);
    }

    public void refreshPlayerInfo (int countInfo, int level, String sizeMapInfo) {
        enemyCount.setText(prefixEnemyCount + countInfo);
        levelGame.setText(prefixLevel + level);
        sizeMap.setText(prefixSizeMap + sizeMapInfo);
    }
}

