"""
string_manipulator — Exercise 2

Provides reverse_string() with proper handling of:
  • Normal strings, palindromes, sentences with spaces
  • Special characters and mixed content
  • Empty strings (returns "")
  • Non-string input (raises TypeError)
"""


def reverse_string(text):
    """
    Reverse the given string character-by-character.

    Algorithm: Python slice notation [::-1] creates a reversed copy
    in O(n) time and O(n) space. It correctly handles all Unicode
    characters including whitespace and symbols.

    Args:
        text: the string to reverse (must be a str)

    Returns:
        The reversed string.

    Raises:
        TypeError: if text is not a string.
    """
    # Guard clause: reject non-string types with a clear message
    if not isinstance(text, str):
        raise TypeError("Input must be a string")
    # Slice with step -1 produces a reversed copy — idiomatic Python.
    return text[::-1]
