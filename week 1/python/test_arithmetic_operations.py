"""
TDD Tests for arithmetic_operations module — Exercise 1.

Written BEFORE the implementation to define expected behaviour
for multiply() and divide(), including edge cases.
"""
import pytest
from arithmetic_operations import multiply, divide


# ──────────────── Multiplication: Normal Cases ────────────────

def test_multiply_positives():
    """Two positive integers."""
    assert multiply(6, 7) == 42


def test_multiply_negative():
    """Positive × negative yields negative."""
    assert multiply(-3, 4) == -12


def test_multiply_two_negatives():
    """Negative × negative yields positive."""
    assert multiply(-3, -5) == 15


# ──────────────── Multiplication: Zero Cases ────────────────

def test_multiply_by_zero():
    """Anything × 0 is 0."""
    assert multiply(0, 5) == 0
    assert multiply(5, 0) == 0
    assert multiply(0, 0) == 0


# ──────────────── Multiplication: Large Numbers ────────────────

def test_multiply_large_numbers():
    """Python handles big integers natively; verify correctness."""
    assert multiply(100_000, 100_000) == 10_000_000_000


# ──────────────── Division: Normal Cases ────────────────

def test_divide_positives():
    """Exact positive division."""
    assert divide(42, 7) == pytest.approx(6.0)


def test_divide_negative_dividend():
    """Negative dividend."""
    assert divide(-15, 5) == pytest.approx(-3.0)


def test_divide_both_negative():
    """Both operands negative."""
    assert divide(-15, -5) == pytest.approx(3.0)


def test_divide_fraction():
    """Non-exact division produces a float."""
    assert divide(10, 3) == pytest.approx(3.3333, rel=1e-3)


# ──────────────── Division: Zero Cases ────────────────

def test_divide_zero_dividend():
    """Zero divided by anything is 0."""
    assert divide(0, 5) == pytest.approx(0.0)


def test_divide_by_zero():
    """Division by zero must raise ValueError with a clear message."""
    with pytest.raises(ValueError, match="zero"):
        divide(10, 0)
