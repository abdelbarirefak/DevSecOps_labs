import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TDD Tests for Divider.
 * Written BEFORE the implementation to define expected behaviour
 * for divide(), with emphasis on exception handling for zero divisor.
 */
public class DividerTest {

    private final Divider divider = new Divider();

    // ──────────────── Normal Division ────────────────

    @Test
    @DisplayName("divide: exact positive division")
    public void testDivideExact() {
        assertEquals(5.0, divider.divide(10, 2), 0.0001);
    }

    @Test
    @DisplayName("divide: fractional result")
    public void testDivideFractional() {
        assertEquals(2.5, divider.divide(5, 2), 0.0001);
    }

    @Test
    @DisplayName("divide: large dividend")
    public void testDivideLarge() {
        assertEquals(500_000.0, divider.divide(1_000_000, 2), 0.0001);
    }

    // ──────────────── Negative Number Cases ────────────────

    @Test
    @DisplayName("divide: negative dividend")
    public void testDivideNegativeDividend() {
        assertEquals(-2.0, divider.divide(-10, 5), 0.0001);
    }

    @Test
    @DisplayName("divide: negative divisor")
    public void testDivideNegativeDivisor() {
        assertEquals(-2.0, divider.divide(10, -5), 0.0001);
    }

    @Test
    @DisplayName("divide: both negative yields positive")
    public void testDivideBothNegative() {
        assertEquals(2.0, divider.divide(-10, -5), 0.0001);
    }

    // ──────────────── Zero Dividend ────────────────

    @Test
    @DisplayName("divide: zero dividend yields 0")
    public void testDivideZeroDividend() {
        assertEquals(0.0, divider.divide(0, 5), 0.0001);
    }

    // ──────────────── Division by Zero — Exception ────────────────

    @Test
    @DisplayName("divide: division by zero throws ArithmeticException with message")
    public void testDivideByZero() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> divider.divide(10, 0));
        // Verify the exception message is descriptive
        assertTrue(ex.getMessage().contains("zero"),
                "Exception message should mention 'zero'");
    }

    @Test
    @DisplayName("divide: zero divided by zero also throws ArithmeticException")
    public void testDivideZeroByZero() {
        assertThrows(ArithmeticException.class,
                () -> divider.divide(0, 0));
    }
}
