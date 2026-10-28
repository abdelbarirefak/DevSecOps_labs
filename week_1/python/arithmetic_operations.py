"""
arithmetic_operations — Exercise 1

Provides multiply() and divide() with proper handling of:
  • Large numbers  (Python's arbitrary-precision int handles this natively)
  • Division by zero (explicit ValueError)
  • Negative operands (standard arithmetic rules apply)
"""


def multiply(a, b):
    """
    Return the product of a and b.

    Python integers have arbitrary precision, so overflow is
    impossible regardless of operand size.
    """
    # Straightforward multiplication; no overflow guard needed in Python.
    return a * b


def divide(dividend, divisor):
    """
    Return dividend / divisor as a float.

    Raises ValueError when divisor is zero to prevent
    undefined behaviour and provide a clear error message.
    """
    # Guard clause: fail fast with a descriptive message for zero divisor
    if divisor == 0:
        raise ValueError("Cannot divide by zero")
    # True division (/) always returns a float in Python 3
    return dividend / divisor
