import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TDD Tests for ArrayOperations.
 * Written BEFORE the implementation to define expected behaviour
 * for findMax(), covering various array compositions and edge cases.
 */
public class ArrayOperationsTest {

    private final ArrayOperations ao = new ArrayOperations();

    // ──────────────── Positive Numbers ────────────────

    @Test
    @DisplayName("findMax: array of positive numbers")
    public void testFindMaxPositives() {
        assertEquals(7, ao.findMax(new int[]{1, 3, 5, 7}));
    }

    @Test
    @DisplayName("findMax: all identical elements")
    public void testFindMaxAllSame() {
        assertEquals(4, ao.findMax(new int[]{4, 4, 4, 4}));
    }

    // ──────────────── Negative Numbers ────────────────

    @Test
    @DisplayName("findMax: array of negative numbers")
    public void testFindMaxNegatives() {
        assertEquals(-1, ao.findMax(new int[]{-1, -3, -5, -7}));
    }

    // ──────────────── Mixed Numbers ────────────────

    @Test
    @DisplayName("findMax: mixed positive, negative, and zero")
    public void testFindMaxMixed() {
        assertEquals(9, ao.findMax(new int[]{-3, 0, 9, -2}));
    }

    // ──────────────── Single Element ────────────────

    @Test
    @DisplayName("findMax: single element array")
    public void testFindMaxSingleElement() {
        assertEquals(5, ao.findMax(new int[]{5}));
    }

    // ──────────────── Large Array ────────────────

    @Test
    @DisplayName("findMax: large array — max at the end")
    public void testFindMaxLargeArray() {
        // Build a 10 000-element array; max value placed at the last index
        int[] large = new int[10_000];
        for (int i = 0; i < large.length; i++) {
            large[i] = i;
        }
        assertEquals(9_999, ao.findMax(large));
    }

    // ──────────────── Edge Cases: Empty & Null ────────────────

    @Test
    @DisplayName("findMax: empty array throws IllegalArgumentException")
    public void testFindMaxEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> ao.findMax(new int[]{}));
    }

    @Test
    @DisplayName("findMax: null array throws IllegalArgumentException")
    public void testFindMaxNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> ao.findMax(null));
    }
}
