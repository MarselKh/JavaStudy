package Lesson7HW.windowParts;

import Lesson4HW.Game;
import Lesson7HW.MainWindow;
import Lesson7HW.models.Player;
import Lesson7HW.windowParts.guiPanelParts.GameControlArea;
import Lesson7HW.windowParts.guiPanelParts.GameInfoArea;
import Lesson7HW.windowParts.guiPanelParts.PlayerControlArea;
import Lesson7HW.windowParts.guiPanelParts.PlayerInfoArea;

import javax.swing.*;
import java.awt.*;

public class GuiPanel extends JPanel {

    private MainWindow mainWindow;
    
    private GameControlArea gameControlArea;
    private GameInfoArea gameInfoArea;
    private PlayerControlArea playerControlArea;
    private PlayerInfoArea playerInfoArea;
    
    private JTextArea gameLog;
    private JScrollPane scrollLog; 
    
    public GuiPanel(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        prepare();
        createParts();
        prepareLogArea();

        add(gameControlArea);
        add(playerInfoArea);
        add(gameInfoArea);
        add(playerControlArea);
        add(scrollLog);

    }

    private void prepare() {
        setBackground(Color.yellow);
        setLayout(new GridLayout(5,1));
    }

    private void prepareLogArea() {
        gameLog = new JTextArea();
        gameLog.setEditable(false);
        gameLog.setLineWrap(true);
        scrollLog = new JScrollPane(gameLog);
    }

    private void createParts() {
        gameControlArea = new GameControlArea(this);
        gameInfoArea = new GameInfoArea();
        playerControlArea = new PlayerControlArea(this);
        playerInfoArea = new PlayerInfoArea();
    }

    public void recordLog(String msg) {
        gameLog.append(msg + "\n");
    }

    public void launchNewGame () {
        mainWindow.startNewGame();

    }

    public void refreshGuiInfo(GuiMap map) {
        playerInfoArea.refreshPlayerInfo(map.getPlayer());
        gameInfoArea.refreshPlayerInfo(map.getCountEnemies(), map.getLevelCount(), map.getMapSize());
    }

    public void changePositionPlayer(int key) {
        mainWindow.changePositionPlayer(key);
    }
}
