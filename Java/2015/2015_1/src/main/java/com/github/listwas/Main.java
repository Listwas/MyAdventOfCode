package com.github.listwas;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // read file
            File file = new File("input.txt");
            FileInputStream fis = new FileInputStream(file);

            // file length
            int fLen = (int) file.length();

            // pack input things to char array
            char[] fCon = new char[fLen];
            InputStreamReader isr = new InputStreamReader(fis);
            isr.read(fCon, 0, fLen);

            int floor = 0;
            int basement = -1;
            for (int i = 0; i < fLen; i++) {
                // count floors
                if (fCon[i] == '(') {
                    floor++;
                } else {
                    floor--;
                }

                // check when santa first enters basement
                if (floor == -1 && basement == -1) {
                    basement = i + 1;
                }
            }

            System.out.println("ending floor: " + floor);
            System.out.println("entered basement at: " + basement + " floor");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}