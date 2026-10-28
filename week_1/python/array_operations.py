"""
array_operations — Exercise 3

Provides find_max() to locate the maximum element in a list.
  • Uses a single-pass linear scan — O(n) time, O(1) space.
  • Handles lists of any size >= 1.
  • Rejects None, non-list, or empty inputs with clear exceptions.
"""


def find_max(numbers):
    """
    Return the maximum value in the given list.

    Algorithm: Linear scan — initialise max to the first element,
    then iterate through the remaining elements, updating max
    whenever a larger value is found.  This is optimal for an
    unsorted list because every element must be inspected at
    least once.

    Time complexity:  O(n)
    Space complexity: O(1)

    Args:
        numbers: a non-empty list of comparable items.

    Returns:
        The maximum value in the list.

    Raises:
        TypeError:  if numbers is not a list.
        ValueError: if numbers is an empty list.
    """
    # Guard clause: reject non-list types
    if not isinstance(numbers, list):
        raise TypeError("Input must be a list")

    # Guard clause: reject empty lists
    if len(numbers) == 0:
        raise ValueError("List must not be empty")

    # Start with the first element as the running maximum
    current_max = numbers[0]

    # Compare every subsequent element against the current max
    for value in numbers[1:]:
        if value > current_max:
            current_max = value

    return current_max
