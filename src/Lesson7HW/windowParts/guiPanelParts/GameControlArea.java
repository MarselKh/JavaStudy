package Lesson7HW.windowParts.guiPanelParts;

import Lesson7HW.windowParts.GuiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControlArea extends JPanel {

    private GuiPanel guiPanel;
    private JButton btnStart;
    private JButton btnEndGame;

    public GameControlArea(GuiPanel guiPanel) {
        setLayout(new GridLayout(3,1));
        btnStart = new JButton("Start Game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.launchNewGame();
            }
        });
        btnEndGame = new JButton("End Game");
        btnEndGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            });

        add(new JLabel("Game Control", SwingConstants.CENTER));
        add(btnStart);
        add(btnEndGame);
    }
}
