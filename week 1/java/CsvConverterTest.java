import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

/**
 * TDD Tests for CsvConverter.
 * Written BEFORE the implementation to define expected behaviour
 * for toCsv(), covering correct formatting, empty input, and edge cases.
 */
public class CsvConverterTest {

    private final CsvConverter converter = new CsvConverter();

    // ──────────────── Correct CSV Formatting ────────────────

    @Test
    @DisplayName("toCsv: single record produces header + one data row")
    public void testSingleRecord() {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("name", "John");
        row.put("age", 30);
        data.add(row);

        String csv = converter.toCsv(data);
        // Header line + data line, separated by newline
        assertEquals("name,age\nJohn,30", csv);
    }

    @Test
    @DisplayName("toCsv: multiple records share consistent columns")
    public void testMultipleRecords() {
        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("name", "Alice");
        row1.put("age", 25);
        data.add(row1);

        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("name", "Bob");
        row2.put("age", 35);
        data.add(row2);

        String csv = converter.toCsv(data);
        assertEquals("name,age\nAlice,25\nBob,35", csv);
    }

    // ──────────────── Empty List ────────────────

    @Test
    @DisplayName("toCsv: empty list produces empty string")
    public void testEmptyList() {
        assertEquals("", converter.toCsv(new ArrayList<>()));
    }

    // ──────────────── Missing Keys ────────────────

    @Test
    @DisplayName("toCsv: missing keys in some records are filled with empty")
    public void testMissingKeys() {
        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("name", "Alice");
        row1.put("age", 25);
        data.add(row1);

        // row2 is missing "age"
        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("name", "Bob");
        data.add(row2);

        String csv = converter.toCsv(data);
        // "age" column exists from row1; row2 gets empty value for "age"
        assertTrue(csv.contains("name,age") || csv.contains("age,name"));
        assertTrue(csv.contains("Bob,"));
    }

    // ──────────────── Non-Dictionary Items ────────────────

    @Test
    @DisplayName("toCsv: null items in list are skipped gracefully")
    public void testNullItemsSkipped() {
        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("name", "Alice");
        data.add(row1);

        data.add(null);  // null item should be skipped

        String csv = converter.toCsv(data);
        assertEquals("name\nAlice", csv);
    }

    // ──────────────── Null Input ────────────────

    @Test
    @DisplayName("toCsv: null input throws IllegalArgumentException")
    public void testNullInput() {
        assertThrows(IllegalArgumentException.class,
                () -> converter.toCsv(null));
    }

    // ──────────────── Values With Special Types ────────────────

    @Test
    @DisplayName("toCsv: different value types converted via toString()")
    public void testDifferentValueTypes() {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("name", "Alice");
        row.put("score", 99.5);
        row.put("active", true);
        data.add(row);

        String csv = converter.toCsv(data);
        assertEquals("name,score,active\nAlice,99.5,true", csv);
    }
}
