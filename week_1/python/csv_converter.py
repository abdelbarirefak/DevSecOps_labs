"""
csv_converter — Exercise 6

Converts a list of dictionaries into a CSV-formatted string with:
  • A header row derived from the union of all keys across all dicts.
  • Data rows where missing keys produce empty values.
  • Non-dict items in the list are silently skipped.
  • Values are converted to strings via str().
"""


def dicts_to_csv(data):
    """
    Convert a list of dictionaries into a CSV string.

    Algorithm:
      1. First pass — collect all unique keys from every dict item
         to form the header row.  A dict (Python 3.7+ insertion-ordered)
         is used as an ordered set so columns appear in the order they
         are first encountered.
      2. Second pass — for each dict, look up every header key and
         append its value (or empty string if absent) to the row.
      3. Join header and rows with newline characters.

    Time complexity:  O(n × k) where n = records, k = keys.
    Space complexity: O(n × k) for the output string.

    Args:
        data: a list of dicts; each dict is one record.

    Returns:
        The CSV string (header + data rows), or "" for an empty list.

    Raises:
        TypeError: if data is not a list.
    """
    # Guard clause: reject non-list input
    if not isinstance(data, list):
        raise TypeError("Input must be a list")

    # Empty list → empty CSV (no header, no data)
    if len(data) == 0:
        return ""

    # ── Step 1: Collect all unique column headers ──
    # Using dict.fromkeys() preserves insertion order (Python 3.7+)
    # while deduplicating keys across all records.
    header_set = {}
    for record in data:
        if isinstance(record, dict):
            for key in record:
                header_set[key] = None
    headers = list(header_set.keys())

    # If no valid dicts were found, return empty
    if not headers:
        return ""

    # ── Step 2: Build the header row ──
    lines = [",".join(headers)]

    # ── Step 3: Build each data row ──
    for record in data:
        # Skip non-dict items (None, strings, ints, etc.) gracefully
        if not isinstance(record, dict):
            continue
        # Map each header to its value in this record, or "" if missing
        row = ",".join(
            str(record[h]) if h in record else ""
            for h in headers
        )
        lines.append(row)

    return "\n".join(lines)
