package Lesson7HW.windowParts.guiPanelParts;

import javax.swing.*;
import java.awt.*;

public class PlayerControlArea extends JPanel {
    private JButton btnUpMove;
    private JButton btnDownMove;
    private JButton btnLeftMove;
    private JButton btnRightMove;

    public PlayerControlArea() {
        setLayout(new GridLayout(2,3));
        new JButton();
        btnUpMove = new JButton("⬆");
        btnDownMove = new JButton("⬇");
        btnLeftMove = new JButton("⬅");
        btnRightMove = new JButton("➡");

        add(btnUpMove);
        add(btnDownMove);
        add(btnLeftMove);
        add(btnRightMove);

    }
}
