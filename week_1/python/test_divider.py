"""
TDD Tests for divider module — Exercise 5.

Written BEFORE the implementation to define expected behaviour
for divide(), with emphasis on exception handling for zero divisor.
"""
import pytest
from divider import divide


# ──────────────── Normal Division ────────────────

def test_divide_exact():
    """Exact positive division."""
    assert divide(10, 2) == pytest.approx(5.0)


def test_divide_fractional():
    """Fractional result."""
    assert divide(5, 2) == pytest.approx(2.5)


def test_divide_large():
    """Large dividend."""
    assert divide(1_000_000, 2) == pytest.approx(500_000.0)


# ──────────────── Negative Number Cases ────────────────

def test_divide_negative_dividend():
    """Negative dividend."""
    assert divide(-10, 5) == pytest.approx(-2.0)


def test_divide_negative_divisor():
    """Negative divisor."""
    assert divide(10, -5) == pytest.approx(-2.0)


def test_divide_both_negative():
    """Both negative yields positive."""
    assert divide(-10, -5) == pytest.approx(2.0)


# ──────────────── Zero Dividend ────────────────

def test_divide_zero_dividend():
    """Zero dividend yields 0."""
    assert divide(0, 5) == pytest.approx(0.0)


# ──────────────── Division by Zero — Exception ────────────────

def test_divide_by_zero():
    """Division by zero raises ZeroDivisionError with descriptive message."""
    with pytest.raises(ZeroDivisionError, match="zero"):
        divide(10, 0)


def test_divide_zero_by_zero():
    """Zero divided by zero also raises ZeroDivisionError."""
    with pytest.raises(ZeroDivisionError, match="zero"):
        divide(0, 0)
