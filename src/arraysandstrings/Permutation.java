package arraysandstrings;

/**
 * 1.2 Given two strings, write a method to decide if one is a permutation of the other.
 *
 * @author Sanket Patil
 */
public class Permutation {

    /**
     * Algorithm:
     * 1. Create count Ascii Map of String 1
     * 2. Reduce count of each character occurred in 2nd string
     * 3. Add the count of each character in String 1 from ascii map
     * 4. If the final count is '0' then its a permutation otherwise not.
     */
    public boolean isPermutation(String string1, String string2) {

        if (string1.length() != string2.length()) {
            return false;
        }

        int[] asciiMap = getAsciiMap(string1);

        for (int i = 0; i < string2.length(); i++) {
            int charPosition = string2.charAt(i);

            if (asciiMap[charPosition] > 0) {
                asciiMap[charPosition]--;
            }
        }

        int count = 0;
        for (int j = 0; j < string1.length(); j++) {
            int charPosition = string1.charAt(j);

            count = count + asciiMap[charPosition];

        }

        return count <= 0;

    }

    /**
     * Builds and returns count ascii map of characters of a string
     *
     * @param string
     * @return
     */
    private int[] getAsciiMap(String string) {
        int[] asciiMap = new int[256];

        for (int i = 0; i < string.length(); i++) {
            int charPosition = string.charAt(i);

            if (asciiMap[charPosition] > 0) {
                asciiMap[charPosition]++;
            } else {
                asciiMap[charPosition] = 1;
            }

        }
        return asciiMap;
    }

    public static void main(String[] args) {

        Permutation p = new Permutation();
        System.out.println(p.isPermutation("abc", "cab"));
        System.out.println(p.isPermutation("abc", "casd"));
        System.out.println(p.isPermutation("abc", "cad"));
        System.out.println(p.isPermutation("qwertyuiop", "poiuytrewq"));

    }

}
