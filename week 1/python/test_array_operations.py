"""
TDD Tests for array_operations module — Exercise 3.

Written BEFORE the implementation to define expected behaviour
for find_max(), covering various list compositions and edge cases.
"""
import pytest
from array_operations import find_max


# ──────────────── Positive Numbers ────────────────

def test_find_max_positives():
    """List of positive numbers."""
    assert find_max([1, 3, 5, 7]) == 7


def test_find_max_all_same():
    """All identical elements."""
    assert find_max([4, 4, 4, 4]) == 4


# ──────────────── Negative Numbers ────────────────

def test_find_max_negatives():
    """List of negative numbers — max is the least negative."""
    assert find_max([-1, -3, -5, -7]) == -1


# ──────────────── Mixed Numbers ────────────────

def test_find_max_mixed():
    """Mixed positive, negative, and zero."""
    assert find_max([-3, 0, 9, -2]) == 9


# ──────────────── Single Element ────────────────

def test_find_max_single_element():
    """Single element list."""
    assert find_max([5]) == 5


# ──────────────── Large List ────────────────

def test_find_max_large_list():
    """Large list — max value at the end."""
    large = list(range(10_000))
    assert find_max(large) == 9_999


# ──────────────── Edge Cases: Empty & Invalid ────────────────

def test_find_max_empty_list():
    """Empty list raises ValueError."""
    with pytest.raises(ValueError, match="must not be empty"):
        find_max([])


def test_find_max_none_input():
    """None input raises TypeError."""
    with pytest.raises(TypeError, match="must be a list"):
        find_max(None)


def test_find_max_non_list_input():
    """Non-list input raises TypeError."""
    with pytest.raises(TypeError, match="must be a list"):
        find_max("not a list")
