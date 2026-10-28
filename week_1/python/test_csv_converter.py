"""
TDD Tests for csv_converter module — Exercise 6.

Written BEFORE the implementation to define expected behaviour
for dicts_to_csv(), covering correct formatting, empty input, and edge cases.
"""
import pytest
from csv_converter import dicts_to_csv


# ──────────────── Correct CSV Formatting ────────────────

def test_single_record():
    """Single dict produces header + one data row."""
    data = [{"name": "John", "age": 30}]
    csv = dicts_to_csv(data)
    assert csv == "name,age\nJohn,30"


def test_multiple_records():
    """Multiple dicts share consistent columns."""
    data = [
        {"name": "Alice", "age": 25},
        {"name": "Bob", "age": 35},
    ]
    csv = dicts_to_csv(data)
    assert csv == "name,age\nAlice,25\nBob,35"


# ──────────────── Empty List ────────────────

def test_empty_list():
    """Empty list produces empty string."""
    assert dicts_to_csv([]) == ""


# ──────────────── Missing Keys ────────────────

def test_missing_keys():
    """Missing keys in some records are filled with empty string."""
    data = [
        {"name": "Alice", "age": 25},
        {"name": "Bob"},  # missing "age"
    ]
    csv = dicts_to_csv(data)
    lines = csv.split("\n")
    # Header should contain both keys
    assert "name" in lines[0]
    assert "age" in lines[0]
    # Bob's row should have an empty value for age
    assert lines[2].endswith(",") or lines[2] == "Bob,"


# ──────────────── Non-Dictionary Items ────────────────

def test_non_dict_items_skipped():
    """Non-dict items in the list are skipped gracefully."""
    data = [
        {"name": "Alice"},
        "not a dict",
        42,
    ]
    csv = dicts_to_csv(data)
    assert csv == "name\nAlice"


def test_none_items_skipped():
    """None items in the list are skipped gracefully."""
    data = [
        {"name": "Alice"},
        None,
    ]
    csv = dicts_to_csv(data)
    assert csv == "name\nAlice"


# ──────────────── Invalid Input ────────────────

def test_none_input():
    """None input raises TypeError."""
    with pytest.raises(TypeError, match="must be a list"):
        dicts_to_csv(None)


# ──────────────── Different Value Types ────────────────

def test_different_value_types():
    """Values of different types are converted via str()."""
    data = [{"name": "Alice", "score": 99.5, "active": True}]
    csv = dicts_to_csv(data)
    assert csv == "name,score,active\nAlice,99.5,True"
