package Lesson7HW.windowParts;

import Lesson7HW.windowParts.guiPanelParts.GameControlArea;
import Lesson7HW.windowParts.guiPanelParts.GameInfoArea;
import Lesson7HW.windowParts.guiPanelParts.PlayerControlArea;
import Lesson7HW.windowParts.guiPanelParts.PlayerInfoArea;

import javax.swing.*;
import java.awt.*;

public class GuiPanel extends JPanel {
    
    private GameControlArea gameControlArea;
    private GameInfoArea gameInfoArea;
    private PlayerControlArea playerControlArea;
    private PlayerInfoArea playerInfoArea;
    
    private JTextArea gameLog;
    private JScrollPane scrollLog; 
    
    public GuiPanel(){
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
        gameLog = new JTextArea("Game Log");
        scrollLog = new JScrollPane(gameLog);
    }

    private void createParts() {
        gameControlArea = new GameControlArea();
        gameInfoArea = new GameInfoArea();
        playerControlArea = new PlayerControlArea();
        playerInfoArea = new PlayerInfoArea();
    }
}
