package com.github.listwas;
import java.io.File;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        try {
            // read and open file
            File file = new File("input.txt");
            FileInputStream fis = new FileInputStream(file);

            // get length
            int fLen = (int) file.length();

            // save input to string array
            String[] fCon = new String[fLen];
            String string = "test string";
            String[] fSplit = string.split("x");
            for (String s : fSplit) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}