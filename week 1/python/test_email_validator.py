"""
TDD Tests for email_validator module — Exercise 4.

Written BEFORE the implementation to define expected behaviour
for is_valid_email(), covering valid formats, invalid formats, and edge cases.
"""
import pytest
from email_validator import is_valid_email


# ──────────────── Valid Email Addresses ────────────────

def test_valid_standard():
    """Standard email format."""
    assert is_valid_email("test@example.com") is True


def test_valid_dots_in_local():
    """Dots in the local part."""
    assert is_valid_email("first.last@example.com") is True


def test_valid_subdomain():
    """Domain with subdomain."""
    assert is_valid_email("user@mail.example.com") is True


def test_valid_digits():
    """Digits in local and domain parts."""
    assert is_valid_email("user123@domain456.org") is True


def test_valid_hyphen_domain():
    """Hyphen in domain."""
    assert is_valid_email("user@my-domain.com") is True


# ──────────────── Invalid Email Formats ────────────────

def test_invalid_double_at():
    """Double @@ symbol."""
    assert is_valid_email("test@@example.com") is False


def test_invalid_no_at():
    """Missing @ symbol entirely."""
    assert is_valid_email("testexample.com") is False


def test_invalid_no_domain():
    """Missing domain part."""
    assert is_valid_email("test@") is False


def test_invalid_no_local():
    """Missing local part."""
    assert is_valid_email("@example.com") is False


def test_invalid_no_tld():
    """Missing top-level domain."""
    assert is_valid_email("test@example") is False


def test_invalid_dot_only():
    """Domain starts with a dot."""
    assert is_valid_email("test@.com") is False


# ──────────────── Edge Cases ────────────────

def test_empty_string():
    """Empty string is invalid."""
    assert is_valid_email("") is False


def test_just_at_symbol():
    """Just an @ symbol."""
    assert is_valid_email("@") is False


def test_none_input():
    """None input is invalid (returns False, no exception)."""
    assert is_valid_email(None) is False


def test_spaces_in_email():
    """Spaces make an email invalid."""
    assert is_valid_email("test @example.com") is False
