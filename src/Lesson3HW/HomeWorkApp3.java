package Lesson3HW;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp3 {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main (String[] args) {
        arrChapter1();
        arrChapter2();
        arrChapter3();
        arrChapter4();
        System.out.println(Arrays.toString(arrChapter5(5, 3)));
        // "Arrays.toString" рекомендовал использовать IDEA, иначе было "[I@27973e9b"
    }

    public static int[] arrChapter5(int initialValue, int len) {
            int[] arr = new int [len];
            for (int i = 0; i < len; i++) {
                arr[i] = initialValue;
            }
            return arr;
    }

    public static void arrChapter4() {
        int[][] arr = new int [6][6];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(50);
                if (i == j || j == arr.length - i) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();

        }
        System.out.println("---------------------------------------------------");
    }

    public static void arrChapter3() {
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        System.out.println("---------------------------------------------------");
    }

    public static void arrChapter2() {
        int[] arr = new int[100];
        for (int i = 0, j = 1; i < arr.length; i++, j++) {
            arr[i] = j;
            System.out.print(arr[i] + "->");
        }
        System.out.println();
        System.out.println("---------------------------------------------------");
    }


    public static void arrChapter1() {
        int[] arr = { 1, 0, 1, 0, 0, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr [i] = 1;
            } else {
                arr [i] = 0;
            }
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
        System.out.println("---------------------------------------------------");
    }

}

