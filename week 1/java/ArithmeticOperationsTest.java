import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TDD Tests for ArithmeticOperations.
 * Written BEFORE the implementation to define expected behaviour
 * for multiplication and division, including edge cases.
 */
public class ArithmeticOperationsTest {

    private final ArithmeticOperations ops = new ArithmeticOperations();

    // ──────────────── Multiplication: Normal Cases ────────────────

    @Test
    @DisplayName("multiply: two positive integers")
    public void testMultiplyPositives() {
        assertEquals(42, ops.multiply(6, 7));
    }

    @Test
    @DisplayName("multiply: positive × negative yields negative")
    public void testMultiplyNegative() {
        assertEquals(-12, ops.multiply(-3, 4));
    }

    @Test
    @DisplayName("multiply: two negatives yield positive")
    public void testMultiplyTwoNegatives() {
        assertEquals(15, ops.multiply(-3, -5));
    }

    // ──────────────── Multiplication: Zero Cases ────────────────

    @Test
    @DisplayName("multiply: anything × 0 is 0")
    public void testMultiplyByZero() {
        assertEquals(0, ops.multiply(0, 5));
        assertEquals(0, ops.multiply(5, 0));
        assertEquals(0, ops.multiply(0, 0));
    }

    // ──────────────── Multiplication: Large Numbers ────────────────

    @Test
    @DisplayName("multiply: large values handled via long return type")
    public void testMultiplyLargeNumbers() {
        // 100_000 × 100_000 = 10_000_000_000, exceeds int range
        assertEquals(10_000_000_000L, ops.multiply(100_000, 100_000));
    }

    // ──────────────── Division: Normal Cases ────────────────

    @Test
    @DisplayName("divide: exact positive division")
    public void testDividePositives() {
        assertEquals(6.0, ops.divide(42, 7), 0.0001);
    }

    @Test
    @DisplayName("divide: negative dividend")
    public void testDivideNegativeDividend() {
        assertEquals(-3.0, ops.divide(-15, 5), 0.0001);
    }

    @Test
    @DisplayName("divide: both negative")
    public void testDivideBothNegative() {
        assertEquals(3.0, ops.divide(-15, -5), 0.0001);
    }

    @Test
    @DisplayName("divide: result is a fraction")
    public void testDivideFraction() {
        assertEquals(3.3333, ops.divide(10, 3), 0.001);
    }

    // ──────────────── Division: Zero Cases ────────────────

    @Test
    @DisplayName("divide: zero dividend yields 0")
    public void testDivideZeroDividend() {
        assertEquals(0.0, ops.divide(0, 5), 0.0001);
    }

    @Test
    @DisplayName("divide: division by zero throws ArithmeticException")
    public void testDivideByZero() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> ops.divide(10, 0));
        // Verify the exception carries a meaningful message
        assertTrue(ex.getMessage().contains("zero"));
    }
}
