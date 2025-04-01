package com.github.listwas;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // read file and then split it by 'x\n' characters
            String fCon = new String(Files.readAllBytes(Paths.get("input.txt")));
            String[] split = fCon.split("[x\n]");
            int fLen = split.length;

            // get l, w, h for further calculations
            int totalWrap = 0;
            for (int i = 0; i < fLen; i += 3) {
                int length = Integer.parseInt(split[i]);
                int width = Integer.parseInt(split[i + 1]);
                int height = Integer.parseInt(split[i + 2]);

                totalWrap += getRes(length, width, height);
            }

            System.out.println("total square feet of wrapping paper: " + totalWrap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int getRes(int length, int width, int height) {
        // calculate surface area
        int surfaceArea = 2 * (length * width + width * height + height * length);

        // calculate the area of the smallest side
        int area1 = length * width;
        int area2 = width * height;
        int area3 = height * length;
        int smallestSide = Math.min(Math.min(area1, area2), area3);

        return surfaceArea + smallestSide;
    }
    // TODO
    // A present with dimensions 2x3x4 requires 2+2+3+3 = 10 feet of ribbon to wrap
    // the present plus 2*3*4 = 24 feet of ribbon for the bow, for a total of 34 feet.
}
