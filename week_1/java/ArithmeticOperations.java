/**
 * ArithmeticOperations — Exercise 1
 *
 * Provides multiplication and division with proper handling of:
 *   • Large numbers (long return type prevents int overflow)
 *   • Division by zero (explicit ArithmeticException)
 *   • Negative operands (standard arithmetic rules apply)
 */
public class ArithmeticOperations {

    /**
     * Multiplies two integers and returns a long to safely accommodate
     * products that exceed Integer.MAX_VALUE (e.g. 100_000 × 100_000).
     *
     * @param a first operand
     * @param b second operand
     * @return the product as a long
     */
    public long multiply(int a, int b) {
        // Cast to long BEFORE multiplying so the arithmetic
        // is performed in 64-bit space and cannot overflow.
        return (long) a * (long) b;
    }

    /**
     * Divides the dividend by the divisor using floating-point arithmetic.
     * Throws ArithmeticException when the divisor is zero to prevent
     * undefined behaviour.
     *
     * @param dividend the number to be divided
     * @param divisor  the number to divide by (must not be zero)
     * @return the quotient as a double
     * @throws ArithmeticException if divisor is zero
     */
    public double divide(int dividend, int divisor) {
        // Guard clause: fail fast with a clear message for zero divisor
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        // Cast dividend to double so integer division does not truncate
        return (double) dividend / divisor;
    }
}
