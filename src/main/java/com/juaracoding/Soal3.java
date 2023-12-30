package com.juaracoding;

public class Soal3 {
    public static void main (String[] args){
        String t1Data1 = "202112SOAL3";
        String t2Data1 = "SOAL3/2112/AB000000011 OD:0001234500CDE5432100 SOAL003 ABCDE12345 XAS SKILL TEST ESSAY .DT";
        String t1Data2 = "202111SOAL3";
        String t2Data2 = "SOAL3/2111/BC000011100 OD:0003452100EFG2451300 SOAL003 EFGHI25134 XAS SKILL TEST ESSAY .DT";
        String t1Data3 = "202110SOAL3";
        String t2Data3 = "SOAL3/2110/DE210031010 OD:0001524300HIJ2145300 SOAL003 JKLMN52431 XAS SKILL TEST ESSAY .DT";

        int trailerLength = 18;
        int totalTrailers = 5;

        String newT2Data1 = shiftAndCombine(t2Data1, trailerLength, totalTrailers, 3);
        String newT2Data2 = shiftAndCombine(t2Data2, trailerLength, totalTrailers, 3);
        String newT2Data3 = shiftAndCombine(t2Data3, trailerLength, totalTrailers, 3);


        System.out.print("DATA / Before: ");
        System.out.println("\nT1:" + t1Data1);
        System.out.println("T2:" + t2Data1);
        System.out.println("\nT1:" + t1Data2);
        System.out.println("T2:" + t2Data2);
        System.out.println("\nT1:" + t1Data3);
        System.out.println("T2:" + t2Data3);

        System.out.print("\nExpected Result (Hasil yang diharapkan): ");
        System.out.println("\nT1:" + t1Data1);
        System.out.println("T2:" + newT2Data1);
        System.out.println("\nT1:" + t1Data2);
        System.out.println("T2:" + newT2Data2);
        System.out.println("\nT1:" + t1Data3);
        System.out.println("T2:" + newT2Data3);
    }

    private static String shiftAndCombine(String inputString, int trailerLength, int totalTrailers, int positions) {
        if (inputString.length() == trailerLength * totalTrailers) {
            String shiftedString = shiftTrailers(inputString, trailerLength, totalTrailers, positions);

            return combineTrailers(shiftedString, trailerLength, totalTrailers);
        } else {
            System.out.println("Invalid input length");
            return null;
        }
    }

    private static String shiftTrailers(String inputString, int trailerLength, int totalTrailers, int positions) {
        StringBuilder shiftedString = new StringBuilder(inputString);
        for (int i = 0; i < totalTrailers; i++) {
            int newIndex = (i + positions) % totalTrailers;
            for (int j = 0; j < trailerLength; j++) {
                shiftedString.setCharAt(newIndex * trailerLength + j, inputString.charAt(i * trailerLength + j));
            }
        }
        return shiftedString.toString();
    }

    private static String combineTrailers(String inputString, int trailerLength, int totalTrailers) {
        StringBuilder combinedString = new StringBuilder();
        for (int i = 0; i < totalTrailers; i++) {
            combinedString.append(inputString.substring(i * trailerLength, (i + 1) * trailerLength));
        }
        return combinedString.toString();
    }

}
