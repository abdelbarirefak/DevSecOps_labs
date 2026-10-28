import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TDD Tests for EmailValidator.
 * Written BEFORE the implementation to define expected behaviour
 * for isValidEmail(), covering valid formats, invalid formats, and edge cases.
 */
public class EmailValidatorTest {

    private final EmailValidator validator = new EmailValidator();

    // ──────────────── Valid Email Addresses ────────────────

    @Test
    @DisplayName("valid: standard email format")
    public void testValidStandard() {
        assertTrue(validator.isValidEmail("test@example.com"));
    }

    @Test
    @DisplayName("valid: email with dots in local part")
    public void testValidDotsInLocal() {
        assertTrue(validator.isValidEmail("first.last@example.com"));
    }

    @Test
    @DisplayName("valid: email with subdomain")
    public void testValidSubdomain() {
        assertTrue(validator.isValidEmail("user@mail.example.com"));
    }

    @Test
    @DisplayName("valid: email with digits")
    public void testValidDigits() {
        assertTrue(validator.isValidEmail("user123@domain456.org"));
    }

    @Test
    @DisplayName("valid: email with hyphen in domain")
    public void testValidHyphenDomain() {
        assertTrue(validator.isValidEmail("user@my-domain.com"));
    }

    // ──────────────── Invalid Email Formats ────────────────

    @Test
    @DisplayName("invalid: double @@ symbol")
    public void testInvalidDoubleAt() {
        assertFalse(validator.isValidEmail("test@@example.com"));
    }

    @Test
    @DisplayName("invalid: missing @ symbol entirely")
    public void testInvalidNoAt() {
        assertFalse(validator.isValidEmail("testexample.com"));
    }

    @Test
    @DisplayName("invalid: missing domain part")
    public void testInvalidNoDomain() {
        assertFalse(validator.isValidEmail("test@"));
    }

    @Test
    @DisplayName("invalid: missing local part")
    public void testInvalidNoLocal() {
        assertFalse(validator.isValidEmail("@example.com"));
    }

    @Test
    @DisplayName("invalid: missing top-level domain")
    public void testInvalidNoTLD() {
        assertFalse(validator.isValidEmail("test@example"));
    }

    @Test
    @DisplayName("invalid: domain is only a dot")
    public void testInvalidDotOnly() {
        assertFalse(validator.isValidEmail("test@.com"));
    }

    // ──────────────── Edge Cases ────────────────

    @Test
    @DisplayName("edge: empty string")
    public void testEmptyString() {
        assertFalse(validator.isValidEmail(""));
    }

    @Test
    @DisplayName("edge: just an @ symbol")
    public void testJustAtSymbol() {
        assertFalse(validator.isValidEmail("@"));
    }

    @Test
    @DisplayName("edge: null input")
    public void testNullInput() {
        assertFalse(validator.isValidEmail(null));
    }

    @Test
    @DisplayName("edge: spaces in email")
    public void testSpacesInEmail() {
        assertFalse(validator.isValidEmail("test @example.com"));
    }
}
