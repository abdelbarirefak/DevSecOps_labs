"""
TDD Tests for string_manipulator module — Exercise 2.

Written BEFORE the implementation to define expected behaviour
for reverse_string(), including special characters and whitespace.
"""
import pytest
from string_manipulator import reverse_string


# ──────────────── Normal Strings ────────────────

def test_reverse_normal_string():
    """Standard word."""
    assert reverse_string("hello") == "olleh"


def test_reverse_with_spaces():
    """Spaces reverse along with all other characters."""
    assert reverse_string("hello world") == "dlrow olleh"


def test_reverse_palindrome():
    """A palindrome remains identical after reversal."""
    assert reverse_string("racecar") == "racecar"


# ──────────────── Empty & Single Character ────────────────

def test_reverse_empty_string():
    """Empty string yields empty string."""
    assert reverse_string("") == ""


def test_reverse_single_char():
    """Single character is unchanged."""
    assert reverse_string("a") == "a"


# ──────────────── Special Characters ────────────────

def test_reverse_special_characters():
    """Symbols are preserved in reverse order."""
    assert reverse_string("!@#") == "#@!"


def test_reverse_mixed():
    """Mixed alphanumeric and symbols."""
    assert reverse_string("abc123!") == "!321cba"


# ──────────────── Whitespace Variants ────────────────

def test_reverse_whitespace_variants():
    """Tabs and newlines are reversed correctly."""
    assert reverse_string("a\tb\n") == "\nb\ta"


# ──────────────── Invalid Input ────────────────

def test_reverse_none_input():
    """None input raises TypeError."""
    with pytest.raises(TypeError, match="must be a string"):
        reverse_string(None)


def test_reverse_non_string_input():
    """Non-string input raises TypeError."""
    with pytest.raises(TypeError, match="must be a string"):
        reverse_string(12345)
