"""
email_validator — Exercise 4

Validates email addresses against a standard format using regex.

Validation rules enforced:
  1. Exactly one '@' separating local and domain parts.
  2. Local part: one or more alphanumeric chars, dots, underscores,
     percent signs, plus signs, or hyphens.
  3. Domain part: one or more alphanumeric chars or hyphens,
     followed by a dot and a 2–10 character TLD.
  4. No spaces allowed anywhere.
  5. None and empty inputs return False (no exceptions).
"""
import re

# Compiled regex for performance when validating many addresses.
#
# Regex breakdown:
#   ^                     — start of string
#   [A-Za-z0-9._%+-]+     — local part: allowed characters, one or more
#   @                     — literal @ separator
#   [A-Za-z0-9.-]+        — domain name: alphanumeric, dots, hyphens
#   \.                    — literal dot before TLD
#   [A-Za-z]{2,10}        — TLD: 2–10 letters (e.g., .com, .museum)
#   $                     — end of string
_EMAIL_REGEX = re.compile(
    r"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,10}$"
)


def is_valid_email(email):
    """
    Return True if email matches a standard email format, False otherwise.
    Returns False for None, empty, or malformed input — never raises.

    Args:
        email: the email address string to validate.

    Returns:
        True if valid, False otherwise.
    """
    # None or non-string inputs are trivially invalid
    if not isinstance(email, str) or len(email) == 0:
        return False
    # Match the entire string against the compiled regex
    return _EMAIL_REGEX.match(email) is not None
