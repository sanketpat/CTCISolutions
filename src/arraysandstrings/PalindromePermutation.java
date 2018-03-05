package arraysandstrings;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat". "atco cta". etc.)
 *
 * @author Sanket Patil
 */
public class PalindromePermutation {

    /**
     * Assumption: No constraint for small or capital letter and for space
     * Algorithm:
     * 1. Create ascii map of all character
     * 2. Take % of each character count from ascii map
     * 3. A string with even number of characters should always return '0' for % operation on character count,
     * 4. A string with odd number of characters should always return '1' for % operation on character count,
     * 5. Anything else is not a candidate for palindrome
     * @param inputString
     * @return
     */
    private boolean isPalindromePermutation(String inputString) {
        String inpitStringSpaceLess = inputString.replace(" ", "").toLowerCase();
        int[] asciiMap = getAsciiMap(inpitStringSpaceLess);
        int oddCount = 0;

        for (int i = 0; i < inpitStringSpaceLess.length(); i++) {
            char currentChar = inpitStringSpaceLess.charAt(i);
            if (asciiMap[currentChar] % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

    /**
     * Returns an ascii map containing character counts of the given string
     * @param inputString
     * @return
     */
    private int[] getAsciiMap(String inputString) {
        int[] asciiMap = new int[256];
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (asciiMap[currentChar] > 0) {
                asciiMap[currentChar]++;
            } else {
                asciiMap[currentChar] = 1;
            }
        }

        return asciiMap;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePermutation().isPalindromePermutation("Tact Coa"));
    }
}
