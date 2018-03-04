package arraysandstrings;

/**
 * 1.3 URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE:
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20J ohn%20Smith"
 */
public class URLify {

    private final static String URLFY = "%20";
    private final static int URLFLY_COUNT = URLFY.length();

    /**
     * Assumption: space is available in char array
     * Algorithm: Time complexity: O(n) Space Complexity: O(n)
     * 1. Count space in given array : O(n)
     * 2. Create char array with string length and copy characters from input string and add extra space for URL fy string :O(n)
     * 3. Traverse backward and keep on filling the characters from above char array : O(n)
     *
     * @param string
     * @return
     */
    public String stringURLify(String string) {

        int spaceCount = getSpaceCount(string);

        int finalLength = string.length() + ((spaceCount - 1) * URLFLY_COUNT);

        char[] stringCharacters = new char[finalLength];

        for (int i = 0; i < string.length(); i++) {
            stringCharacters[i] = string.charAt(i);
        }

        for (int i = string.length() - 1; i > 0; i--) {
            if (stringCharacters[i] == ' ') {
                stringCharacters[finalLength - 1] = '0';
                stringCharacters[finalLength - 2] = '2';
                stringCharacters[finalLength - 3] = '%';
                finalLength = finalLength - 3;
            } else {
                stringCharacters[finalLength - 1] = stringCharacters[i];
                finalLength--;
            }

        }


        return String.valueOf(stringCharacters);
    }

    private int getSpaceCount(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        URLify urLify = new URLify();
        System.out.print(urLify.stringURLify("Mr Sanket chandrakant Patil"));
    }

}
