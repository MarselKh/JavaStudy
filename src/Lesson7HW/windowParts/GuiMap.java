package Lesson7HW.windowParts;

import Lesson7HW.MainWindow;
import Lesson7HW.models.Enemy;
import Lesson7HW.models.Player;
import Lesson7HW.models.Tools;

import javax.swing.*;
import java.awt.*;

public class GuiMap extends JPanel {

    private MainWindow mainWindow;
    private final int CELL_PLAYER = 1;
    private final int CELL_ENEMY = 2;
    private final int CELL_EMPTY = 0;
    private final int CELL_READY = 9;


    public static final int DIRECTION_up = 8;
    public static final int DIRECTION_down = 2;
    public static final int DIRECTION_left = 4;
    public static final int DIRECTION_right = 6;

    private int [][] map;
    private int [][] invisibleLocation;
    private int mapMin = 4;
    private int mapMax = 6;
    private int heigthMap;
    private int weigthMap;
    private int levelCount;
    private Player player;
    private Enemy enemy;
    private int cellWidth;
    private int cellHeight;
    private boolean isMapExist;
    private boolean isGameStart;

    public GuiMap(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.isMapExist = false;
        this.isGameStart = false;
        setBackground(Color.white);
    }

    public void launchNewGame() {
        player = new Player("Seno");
        levelCount = 0;
        levelCycle();
        mainWindow.refreshInfo(this);
        this.isMapExist = true;
        this.isGameStart = true;
    }

    private void levelCycle() {
        createMapPlay();
        createPlayer();
        createEnemy();
        ++levelCount;
        mainWindow.recordLog("Start Level " + levelCount);
        mainWindow.refreshInfo(this);
        repaint();
    }

    private void render (Graphics g) {
        if (!isMapExist) {
            return;
        }
        if (!isGameStart) {
            return;
        }
        paintMap(g);

        for (int y = 0; y < heigthMap; y++) {
            for (int x = 0; x < weigthMap; x++) {
                if (map[y][x] == CELL_EMPTY) {
                    continue;
                }
                if (map[y][x] == CELL_PLAYER) {
                    g.setColor(Color.orange);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth,cellHeight);
                }
                if (map[y][x] == CELL_READY) {
                    g.setColor(Color.green);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth,cellHeight);
                }

            }
        }

    }

    private void paintMap (Graphics g) {
        int meWidth = getWidth();
        int meHeight = getHeight();

        cellWidth = meWidth / weigthMap;
        cellHeight = meHeight / heigthMap;

        g.setColor(Color.GRAY);
        for (int i = 0; i <= heigthMap; i++){
            int y = i * cellHeight;
            g.drawLine(0,y,meWidth,y);
        }
        for (int i = 0; i <= weigthMap; i++){
            int x  = i * cellWidth;
            g.drawLine(x,0, x,meHeight);
        }
    }

    public void updatePlayer(int key){
        if (!isMapExist) {
            return;
        }
        if (!isGameStart) {
            return;
        }
        int currentX = player.getX();
        int currentY = player.getY();

        switch (key) {
            case DIRECTION_up:
                player.moveUp();
                break;
            case DIRECTION_down:
                player.moveDown();
                break;
            case DIRECTION_left:
                player.moveLeft();
                break;
            case DIRECTION_right:
                player.moveRight();
                break;
        }
        if (!isValidMovePlayer(currentX, currentY, player.getX(), player.getY())) {
        return;
        }
    playerNextMoveAction(currentX, currentY, player.getX(), player.getY());
    mainWindow.refreshInfo(this);
    repaint();
        if (!player.isAlive()) {
        this.isGameStart = false;
        JOptionPane.showMessageDialog(this,player.getName() + " is dead");
        }
        if (isReadyLocation()){
            levelCycle();
            JOptionPane.showMessageDialog(this,player.getName() + " Level" + levelCount);

        }
    }

    private boolean isAlivePlayer () {
        return player.getHealth() > 0;
    }


    private boolean isReadyLocation () {
        for (int y = 0; y < heigthMap; y++) {
            for (int x = 0; x < weigthMap; x++) {
                if (map[y][x] == CELL_EMPTY) {
                    return false;
                }
            }
        } return true;
    }

    private boolean isValidMovePlayer(int currentX, int  currentY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < weigthMap && nextY >= 0 && nextY < heigthMap) {
            mainWindow.recordLog(player.getName() + " move [" + player.getPosition() + "] success!");
            return true;
        } else {
            player.setPosition(currentX,currentY);
            mainWindow.recordLog(player.getName() + "Invalid move! Try again!");
            return false;
        }
    }

    private void battle (int nextX, int nextY) {
        int currentEnemyHealth = enemy.getHealth();

        while (isAlivePlayer()&&currentEnemyHealth > 0){
            currentEnemyHealth -= player.getAttackPoint();
            if (currentEnemyHealth > 0) {
                player.decreaseHP(enemy.getAttackPoint());
            } else {
                enemy.killEnemy();
                invisibleLocation[nextY][nextX] = CELL_EMPTY;
                break;
            }
        }
    }


    private void playerNextMoveAction(int lastX, int lastY, int nextX, int nextY) {
        if (invisibleLocation[nextY][nextX] == CELL_ENEMY) {
            mainWindow.recordLog(player.getName() + "has been attack");
            battle(nextX, nextY);
        }
        map[lastY][lastX] = CELL_READY;
        map[nextY][nextX] = CELL_PLAYER;
        mainWindow.refreshInfo(this);
    }

    private boolean isEmptyRoom (int [][] map, int x, int y) {
        return map[y][x] == CELL_EMPTY;
    }


    private void createEnemy() {
        enemy = new Enemy((heigthMap + weigthMap) / 2);
        int xlocationEnemy;
        int ylocationEnemy;
        for (int i = 0; i < enemy.getCountEnemies(); i++) {
            do {
                xlocationEnemy = Tools.random.nextInt(weigthMap);
                ylocationEnemy = Tools.random.nextInt(heigthMap);
            } while (!isEmptyRoom(map, xlocationEnemy, ylocationEnemy)&&!isEmptyRoom(invisibleLocation, xlocationEnemy,ylocationEnemy));
            invisibleLocation[ylocationEnemy][xlocationEnemy] = CELL_ENEMY;
        }
    }

    private void createPlayer () {
        player.setPosition(Tools.myRandom(0, weigthMap - 1), Tools.myRandom(0, weigthMap - 1));
        map[player.getY()][player.getX()] = CELL_PLAYER;
    }

    private void createMapPlay () {
        heigthMap = Tools.myRandom(mapMin, mapMax);
        weigthMap = Tools.myRandom(mapMin, mapMax);
        map = new int [heigthMap][weigthMap];
        invisibleLocation = new int [heigthMap][weigthMap];
        for (int y = 0; y < heigthMap; y++) {
            for (int x = 0; x < weigthMap; x++) {
                map [y][x] = CELL_EMPTY;
                invisibleLocation [y][x] = CELL_EMPTY;
            }
        }
        mainWindow.recordLog("Map size:" + heigthMap + "-" + weigthMap);
    }

    public Player getPlayer() {
        return player;
    }

    public String getMapSize() {
        return heigthMap + ":" + weigthMap;
    }

    public int getCountEnemies() {
        return enemy.getCountEnemies();
    }

    public int getLevelCount() {
        return levelCount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
}
