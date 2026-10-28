/**
 * StringManipulator — Exercise 2
 *
 * Provides a reverse() method that handles:
 *   • Normal strings, palindromes, sentences with spaces
 *   • Special characters and mixed content
 *   • Empty strings (returns "")
 *   • Null input (throws IllegalArgumentException)
 */
public class StringManipulator {

    /**
     * Reverses the given string character-by-character.
     *
     * Algorithm: delegates to StringBuilder.reverse(), which iterates
     * from both ends toward the centre, swapping characters in O(n) time
     * and O(n) space for the new builder.
     *
     * @param input the string to reverse (must not be null)
     * @return the reversed string
     * @throws IllegalArgumentException if input is null
     */
    public String reverse(String input) {
        // Guard clause: reject null to avoid NullPointerException deeper in the code
        if (input == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }
        // StringBuilder.reverse() is the idiomatic, efficient Java approach.
        // It handles all Unicode characters including whitespace and symbols.
        return new StringBuilder(input).reverse().toString();
    }
}
