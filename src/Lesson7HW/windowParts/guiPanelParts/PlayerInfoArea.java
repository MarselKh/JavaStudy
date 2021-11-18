package Lesson7HW.windowParts.guiPanelParts;

import javax.swing.*;

public class PlayerInfoArea extends JPanel {
    private JTextArea playerInfoArea;
    private JScrollPane scrollPlayerInfo;

    public PlayerInfoArea () {
        playerInfoArea = new JTextArea("Player Info");
        scrollPlayerInfo = new JScrollPane(playerInfoArea);
        add(scrollPlayerInfo);
    }
}
