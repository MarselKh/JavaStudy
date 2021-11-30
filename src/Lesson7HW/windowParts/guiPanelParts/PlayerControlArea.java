package Lesson7HW.windowParts.guiPanelParts;

import Lesson7HW.windowParts.GuiMap;
import Lesson7HW.windowParts.GuiPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerControlArea extends JPanel {
    private GuiPanel guiPanel;
    private JButton btnUpMove;
    private JButton btnDownMove;
    private JButton btnLeftMove;
    private JButton btnRightMove;

    public PlayerControlArea(GuiPanel guiPanel) {
        this.guiPanel = guiPanel;
        setLayout(new GridLayout(2,3));

        btnUpMove = new JButton("⬆");
        btnUpMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.changePositionPlayer(GuiMap.DIRECTION_up);
            }
        });
        btnDownMove = new JButton("⬇");
        btnDownMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.changePositionPlayer(GuiMap.DIRECTION_down);
            }
        });
        btnLeftMove = new JButton("⬅");
        btnLeftMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.changePositionPlayer(GuiMap.DIRECTION_left);
            }
        });
        btnRightMove = new JButton("➡");
        btnRightMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiPanel.changePositionPlayer(GuiMap.DIRECTION_right);
            }
        });

        add(new JPanel());
        add(btnUpMove);
        add(new JPanel());
        add(btnLeftMove);
        add(btnDownMove);
        add(btnRightMove);

    }
}
