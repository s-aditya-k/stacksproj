package org.kompella;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println((new Grid(5)));
        /*
        try {
            readInput();
        } catch (Exception e) {
            System.out.println("oop " + e);
        };
         */
    }
    public static void readInput() throws FileNotFoundException {
        Scanner in = new Scanner(new File("file.input"));
        int val = in.nextInt();
        boolean[][] grid = new boolean[val][val];
        for (int i = 0; i < val; i++) {
            for (int j = 0; j < val; j++) {
                String str = in.nextLine();
                char c = str.charAt(j);
                switch (c) {
                    case 'x' -> grid[i][j] = true;
                    case ' ' -> grid[i][j] = false;
                }
            }
        }
    }
}
