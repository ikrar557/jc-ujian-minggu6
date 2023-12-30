package com.juaracoding;

public class Soal2 {
    public static void main(String[] args) {
        String randData = modifyString();

        while (!randData.equals("5")) {
            System.out.println(randData);

            if (randData.length() >= 2) {
                randData = randData.substring(1, randData.length() - 1);
            } else {
                break;
            }
        }

        System.out.println(randData);
    }

    private static String modifyString() {
        String output = "";
        for (int i = 1; i <= 9; i += 2) {
            output += (i > 1) ? "_" + i : String.valueOf(i);
        }
        return output;
    }
}
