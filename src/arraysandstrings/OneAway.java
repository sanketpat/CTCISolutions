package arraysandstrings;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales. pale -> true
 * pale. bale -> true
 * pale. bake -> false
 */
public class OneAway {

    public static boolean oneAway(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.equals(str2)) {
            return false;
        }
        int edits = 0;
        if (Math.abs(str1.length() - str2.length()) >= 2) {
            return false;
        }
        if (Math.abs(str1.length() - str2.length()) == 1) {
            edits = 1;
        }

        String longString = str1.length() >= str2.length() ? str1 : str2;
        String shortString = longString.equals(str1) ? str2 : str1;
        edits = getEdits(longString, shortString, edits);

        return edits == 1;
    }

    public static int getEdits(String longString, String shortString, int edits) {
        int[] asciiMap = getAsciiMap(longString);
        for (int i = 0; i < shortString.length(); i++) {
            char c = shortString.charAt(i);
            if (asciiMap[c] > 0) {
                asciiMap[c]--;
                edits = edits + asciiMap[c];
            } else {
                edits++;
            }
        }
        return edits;
    }

    public static int[] getAsciiMap(String str) {
        int[] asciiMap = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (asciiMap[c] > 0) asciiMap[c]++;
            else asciiMap[c] = 1;
        }
        return asciiMap;
    }

    public static void main(String[] args) {

        System.out.println("String1: pale, String2: ple");
        System.out.println(String.format("Expected: true ===== Actual: %b", oneAway("pale", "ple")));

        System.out.println("String1: pales, String2: pale");
        System.out.println(String.format("Expected: true ===== Actual: %b", oneAway("pales", "pale")));

        System.out.println("String1: pale, String2: bale");
        System.out.println(String.format("Expected: true ===== Actual: %b", oneAway("pale", "bale")));

        System.out.println("String1: pale, String2: bake");
        System.out.println(String.format("Expected: false ===== Actual: %b", oneAway("pale", "bake")));

        System.out.println("String1: pale, String2: bakesaas");
        System.out.println(String.format("Expected: false ===== Actual: %b", oneAway("pale", "bakesaas")));
    }
}
