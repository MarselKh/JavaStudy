package Lesson7HW;

import Lesson7HW.windowParts.GuiMap;
import Lesson7HW.windowParts.GuiPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private int windowWidth = 1024;
    private int windowHeight = 768;
    private int windowPosX = 250;
    private int windowPosY = 50;
    private String windowTitle = "Window for Java";
    private GuiPanel guiPanel;
    private GuiMap guiMap;

    MainWindow() {
        setupWindow();

        guiPanel = new GuiPanel();
        guiMap = new GuiMap();

        add(guiPanel, BorderLayout.EAST);
        add(guiMap);

        setVisible(true);
    }
    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(windowWidth,windowHeight);
        setLocation(windowPosX,windowPosY);
        setTitle(windowTitle);
        setResizable(true);

    }

}
