"""
divider — Exercise 5

Provides a divide() function that explicitly raises an exception
when the divisor is zero, demonstrating exception handling patterns.

This exercise is distinct from Exercise 1's division in that
the focus is on exception handling: clear messages, intentional
guard clauses, and testable exception behaviour.
"""


def divide(dividend, divisor):
    """
    Divide dividend by divisor.

    Exception handling approach:
      1. Check the divisor BEFORE performing any arithmetic.
      2. Raise ZeroDivisionError with a human-readable message
         so callers (and tests) can identify the cause immediately.
      3. This is a "fail-fast" pattern — the function refuses to
         proceed with invalid input rather than returning a
         sentinel value (like float('inf') or NaN).

    Args:
        dividend: the number to be divided.
        divisor:  the number to divide by (must not be zero).

    Returns:
        The quotient as a float.

    Raises:
        ZeroDivisionError: if divisor is zero.
    """
    # Fail-fast guard: check for zero divisor before any computation
    if divisor == 0:
        raise ZeroDivisionError(
            f"Division by zero is not allowed: cannot divide {dividend} by zero"
        )
    # Safe to divide — Python's true division returns a float
    return dividend / divisor
