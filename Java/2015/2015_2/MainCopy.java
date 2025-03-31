package com.github.listwas;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // split input string by 'x' character
            String fCon = new String(Files.readAllBytes(Paths.get("input.txt")));

            String regex = "[x\n]";
            String[] split = fCon.split(regex);

            int res = getRes(split);
            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getRes(String[] split) {
        int fLen = split.length;
        int length, width, height, res = 0;

        for (int i = 0; i < fLen-2; i += 3) {
            length = Integer.parseInt(split[i]);
            width = Integer.parseInt(split[i+1]);
            height = Integer.parseInt(split[i+2]);

            // TODO
            // DETERMINATE SMALLEST NUMBER FOR SLACK

            res += 2*(length * width + width * height + height * length);
//                System.out.println(split[i]);
//                System.out.printf("%d %d %d\n", length, width, height);
//                System.out.println(res);
        }
        return res;
    }
}
