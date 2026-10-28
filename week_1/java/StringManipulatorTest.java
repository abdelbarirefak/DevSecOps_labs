import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TDD Tests for StringManipulator.
 * Written BEFORE the implementation to define expected behaviour
 * for string reversal, including special characters and whitespace.
 */
public class StringManipulatorTest {

    private final StringManipulator sm = new StringManipulator();

    // ──────────────── Normal Strings ────────────────

    @Test
    @DisplayName("reverse: standard word")
    public void testReverseNormalString() {
        assertEquals("olleh", sm.reverse("hello"));
    }

    @Test
    @DisplayName("reverse: sentence with spaces")
    public void testReverseWithSpaces() {
        // Spaces are characters too — they reverse along with everything else
        assertEquals("dlrow olleh", sm.reverse("hello world"));
    }

    @Test
    @DisplayName("reverse: palindrome remains identical")
    public void testReversePalindrome() {
        assertEquals("racecar", sm.reverse("racecar"));
    }

    // ──────────────── Empty & Single Character ────────────────

    @Test
    @DisplayName("reverse: empty string yields empty string")
    public void testReverseEmptyString() {
        assertEquals("", sm.reverse(""));
    }

    @Test
    @DisplayName("reverse: single character unchanged")
    public void testReverseSingleChar() {
        assertEquals("a", sm.reverse("a"));
    }

    // ──────────────── Special Characters ────────────────

    @Test
    @DisplayName("reverse: special characters preserved in reverse order")
    public void testReverseSpecialCharacters() {
        assertEquals("#@!", sm.reverse("!@#"));
    }

    @Test
    @DisplayName("reverse: mixed alphanumeric and symbols")
    public void testReverseMixed() {
        assertEquals("!321cba", sm.reverse("abc123!"));
    }

    // ──────────────── Whitespace Variants ────────────────

    @Test
    @DisplayName("reverse: tabs and newlines reversed correctly")
    public void testReverseWhitespaceVariants() {
        assertEquals("\nb\ta", sm.reverse("a\tb\n"));
    }

    // ──────────────── Null Input ────────────────

    @Test
    @DisplayName("reverse: null input throws IllegalArgumentException")
    public void testReverseNullInput() {
        assertThrows(IllegalArgumentException.class, () -> sm.reverse(null));
    }
}
