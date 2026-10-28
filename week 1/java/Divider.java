/**
 * Divider — Exercise 5
 *
 * Provides a divide() method that explicitly raises an exception
 * when the divisor is zero, demonstrating exception handling patterns.
 *
 * This exercise is distinct from Exercise 1's division in that
 * the focus is on exception handling: clear messages, intentional
 * guard clauses, and testable exception behaviour.
 */
public class Divider {

    /**
     * Divides the dividend by the divisor.
     *
     * Exception handling approach:
     *   1. Check the divisor BEFORE performing any arithmetic.
     *   2. Throw ArithmeticException with a human-readable message
     *      so callers (and tests) can identify the cause immediately.
     *   3. This is a "fail-fast" pattern — the method refuses to
     *      proceed with invalid input rather than returning a
     *      sentinel value (like NaN or Infinity).
     *
     * @param dividend the number to be divided
     * @param divisor  the number to divide by (must not be zero)
     * @return the quotient as a double
     * @throws ArithmeticException if divisor is zero
     */
    public double divide(double dividend, double divisor) {
        // Fail-fast guard: check for zero divisor before any computation
        if (divisor == 0) {
            throw new ArithmeticException(
                    "Division by zero is not allowed: cannot divide "
                    + dividend + " by zero");
        }
        // Safe to divide — floating-point arithmetic handles sign and precision
        return dividend / divisor;
    }
}
