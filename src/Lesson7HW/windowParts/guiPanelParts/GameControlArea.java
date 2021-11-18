package Lesson7HW.windowParts.guiPanelParts;

import javax.swing.*;
import java.awt.*;

public class GameControlArea extends JPanel {

    private JLabel areaName;
    private JButton btnStart;
    private JButton btnEndGame;

    public GameControlArea() {
        setLayout(new GridLayout(3,1));
        areaName = new JLabel("Game Control", SwingConstants.CENTER);
        btnStart = new JButton("Start Game");
        btnEndGame = new JButton("End Game");

        add(areaName);
        add(btnStart);
        add(btnEndGame);
    }
}
