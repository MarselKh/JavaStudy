package Lesson4HW;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    // Player

    public static String namePlayer = "Seno";
    public static char picturePlayer = 'P';
    public static int xlocationPlayer;
    public static int ylocationPlayer;
    public static int healthPlayer = 100;
    public static int actionPlayer = 50;
    public static final int upPlayer = 8;
    public static final int downPlayer = 2;
    public static final int leftPlayer = 4;
    public static final int rightPlayer = 6;

    // Map

    public static char [][] map;
    public static char[][] invisibleLocation;
    public static int mapMin = 3;
    public static int mapMax = 6;
    public static int heigthMap;
    public static int weigthMap;
    public static char emptyRoom = '-';
    public static char readyRoom = '+';

    // Enemy

    public static char enemy = 'E';
    public static String nameEnemy = "Crazy";
    public static int healthEnemy = 25;
    public static int actionEnemy = 20;

    public static int countEnemy;
    public static int strEnemy = 20;


    public static void main (String[] args) {
        createMapPlay ();
        createPlayer ();
        createEnemy();
        printLocation();

        while (true) {
            directionPlayer();
            printLocation();

            if (!isAlivePlayer()) {
                System.out.println(namePlayer + " is dead!");
                break;
            }

            if (isReadyLocation()) {
                System.out.println(namePlayer + " win!");
                break;
            }
        }

        System.out.println("GoodBye! Game over!");

    }
    public static int myRandom (int min, int max) { return min + random.nextInt(max - min + 1);

    }
    public static void createMapPlay () {
        heigthMap = myRandom(mapMin, mapMax);
        weigthMap = myRandom(mapMin, mapMax);
        map = new char [heigthMap][weigthMap];
        invisibleLocation = new char [heigthMap][weigthMap];
        for (int y = 0; y < heigthMap; y++) {
            for (int x = 0; x < weigthMap; x++) {
                map [y][x] = emptyRoom;
                invisibleLocation [y][x] = emptyRoom;
            }
        }
        System.out.println("Map size:" + heigthMap + "-" + weigthMap);
    }

    public static void createPlayer () {
        xlocationPlayer = myRandom(0, weigthMap - 1);
        ylocationPlayer = myRandom(0, heigthMap - 1);
        map[ylocationPlayer][xlocationPlayer] = picturePlayer;
        System.out.println("Player name: " + namePlayer + " - [" + xlocationPlayer + ":" + ylocationPlayer + "]");
    }

    public static void createEnemy() {
        countEnemy = (heigthMap + weigthMap) / 2;
        int xlocationEnemy;
        int ylocationEnemy;
        for (int i = 0; i < countEnemy; i++) {
            do {
                xlocationEnemy = random.nextInt(weigthMap);
                ylocationEnemy = random.nextInt(heigthMap);
            } while (!isEmptyRoom(invisibleLocation, xlocationEnemy,ylocationEnemy));
            invisibleLocation[ylocationEnemy][xlocationEnemy] = enemy;
        }
        System.out.println("All Enemy = " + countEnemy);
    }

    public static boolean isEmptyRoom (char [][] map, int x, int y) {
        return map[y][x] == emptyRoom;
    }

    public static void directionPlayer() {
        int currentX = xlocationPlayer;
        int currentY = ylocationPlayer;
        int playerMoveValue;

        do {
            System.out.print("Enter: ");
            playerMoveValue = scanner.nextInt();
            switch (playerMoveValue) {
                case upPlayer:
                    ylocationPlayer -= 1;
                    break;
                case downPlayer:
                    ylocationPlayer += 1;
                    break;
                case leftPlayer:
                    xlocationPlayer -= 1;
                    break;
                case rightPlayer:
                    xlocationPlayer += 1;
                    break;
            }
        } while (!isValidMovePlayer(currentX, currentY, xlocationPlayer, ylocationPlayer));
        playerNextMoveAction(currentX, currentY, xlocationPlayer, ylocationPlayer);

    }

    public static void playerNextMoveAction(int lastX, int lastY, int nextX, int nextY) {
        if (invisibleLocation[nextY][nextX] == enemy) {
            healthPlayer -= strEnemy;
            countEnemy--;
            System.out.println("Battle: " + namePlayer + " health Player " + healthPlayer);
            System.out.println("Enemy: " + countEnemy);
        }
        invisibleLocation[nextY][nextX] = emptyRoom;
        map[lastY][lastX] = readyRoom;
        map[nextY][nextX] = picturePlayer;
    }

    public static boolean isValidMovePlayer(int currentX, int  currentY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < weigthMap && nextY >= 0 && nextY < heigthMap) {
            return true;
        } else {
            System.out.println("Invalid move! Try again!");
            xlocationPlayer = currentX;
            ylocationPlayer = currentY;
            return false;
        }
    }

    public static void printLocation() {
        for (int y = 0; y < heigthMap; y++) {
            for (int x = 0; x < weigthMap; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static boolean isAlivePlayer () {
        return healthPlayer > 0;
    }

    public static boolean isReadyLocation () {
        for (int y = 0; y < heigthMap; y++) {
            for (int x = 0; x < weigthMap; x++) {
                if (map[y][x] == emptyRoom) {
                    return false;
                }
            }
        } return true;
    }



}
