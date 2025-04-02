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

            int totalWrap = 0;
            int totalRibbon = 0;
            for (int i = 0; i < fLen; i += 3) {
                // get dimensions
                int length = Integer.parseInt(split[i]);
                int width = Integer.parseInt(split[i + 1]);
                int height = Integer.parseInt(split[i + 2]);

                // calculate areas
                int area1 = length * width;
                int area2 = width * height;
                int area3 = height * length;

                // wrapping paper calculations
                int surfaceArea = 2 * (length * width + width * height + height * length);
                int smallestSide = Math.min(Math.min(area1, area2), area3);
                totalWrap += smallestSide + surfaceArea;

                // ribbon calculations
                int perimeter = smallestPerimeter(length, width, height);
                int volume = length * width * height;
                totalRibbon += perimeter + volume;
            }

            System.out.println("total square feet of wrapping paper: " + totalWrap);
            System.out.println("total feet of ribbon to order: " + totalRibbon);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int smallestPerimeter(int length, int width, int height) {
        if (length >= width && length >= height) {
            return 2 * (width + height);
        } else if (width >= length && width >= height) {
            return 2 * (length + height);
        } else {
            return 2 * (length + width);
        }
    }
}
