package com.github.listwas;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args)
            throws IOException {

        String fCon = new String(Files.readAllBytes(Paths.get("input.txt")));
        String[] split = fCon.split("");
        int fLen = fCon.length();

        int[] xVisited = new int[fLen];
        int[] yVisited = new int[fLen];

        int x = 0;
        int y = 1;
        for (int i = 0; i < fLen; i++ ) {
            switch (split[i]) {
                case ">" -> xVisited[i] = x++;
                case "<" -> xVisited[i] = x--;
                case "^" -> yVisited[i] = y++;
                case "v" -> yVisited[i] = y--;
            }
            System.out.println("x: " + xVisited[i]);
            System.out.println("y: " + yVisited[i]);

        }
        // TODO
        //  maybe use hashmap instead??
    }
}