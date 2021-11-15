package Lesson7HW.windowParts.guiPanelParts;

import javax.swing.*;

public class GameInfoArea extends JPanel {
    private JTextArea gameInfoArea;
    private JScrollPane scrollGameInfo;

    public GameInfoArea () {
        gameInfoArea = new JTextArea("Game Info");
        scrollGameInfo = new JScrollPane(gameInfoArea);
        add(scrollGameInfo);
    }
}

