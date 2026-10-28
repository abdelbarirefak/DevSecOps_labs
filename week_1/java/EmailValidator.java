import java.util.regex.Pattern;

/**
 * EmailValidator — Exercise 4
 *
 * Validates email addresses against a standard format using regex.
 *
 * Validation rules enforced:
 *   1. Exactly one '@' separating local and domain parts.
 *   2. Local part: one or more alphanumeric chars, dots, underscores,
 *      percent signs, plus signs, or hyphens.
 *   3. Domain part: one or more alphanumeric chars or hyphens,
 *      followed by a dot and a 2–10 character TLD.
 *   4. No spaces allowed anywhere.
 *   5. Null and empty inputs return false (not exceptions).
 */
public class EmailValidator {

    /*
     * Regex breakdown:
     *   ^                     — start of string
     *   [A-Za-z0-9._%+-]+     — local part: allowed characters, one or more
     *   @                     — literal @ separator
     *   [A-Za-z0-9.-]+        — domain name: alphanumeric, dots, hyphens
     *   \\.                   — literal dot before TLD
     *   [A-Za-z]{2,10}        — TLD: 2–10 letters (e.g., .com, .museum)
     *   $                     — end of string
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,10}$"
    );

    /**
     * Returns true if the given string matches a standard email format.
     * Returns false for null, empty, or malformed input — never throws.
     *
     * @param email the email address to validate
     * @return true if valid, false otherwise
     */
    public boolean isValidEmail(String email) {
        // Null or empty strings are trivially invalid — return false
        // rather than throwing, because "is it valid?" is a yes/no question.
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Match the entire string against the compiled regex pattern
        return EMAIL_PATTERN.matcher(email).matches();
    }
}
