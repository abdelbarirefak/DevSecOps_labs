import java.util.*;
import java.util.stream.Collectors;

/**
 * CsvConverter — Exercise 6
 *
 * Converts a List of Maps (each Map representing one record) into a
 * CSV-formatted String with:
 *   • A header row derived from the union of all keys across all records.
 *   • Data rows where missing keys produce empty values.
 *   • Null items in the list are silently skipped.
 *   • Values are converted to strings via Object.toString().
 */
public class CsvConverter {

    /**
     * Converts a list of key-value maps into a CSV string.
     *
     * Algorithm:
     *   1. First pass — collect all unique keys from every non-null map
     *      to form the header row.  A LinkedHashSet preserves insertion
     *      order so columns appear in the order they are first encountered.
     *   2. Second pass — for each non-null map, look up every header key
     *      and append its value (or empty string if absent) to the row.
     *   3. Join header and rows with newline characters.
     *
     * Time complexity:  O(n × k) where n = number of records, k = number of keys.
     * Space complexity: O(n × k) for the output string.
     *
     * @param data list of maps; each map is one record (may contain nulls)
     * @return the CSV string (header + data rows)
     * @throws IllegalArgumentException if data is null
     */
    public String toCsv(List<Map<String, Object>> data) {
        // Guard clause: null list is a programming error, not an empty result
        if (data == null) {
            throw new IllegalArgumentException("Input list must not be null");
        }

        // Empty list → empty CSV (no header, no data)
        if (data.isEmpty()) {
            return "";
        }

        // ── Step 1: Collect all unique column headers ──
        // LinkedHashSet preserves insertion order for deterministic output
        LinkedHashSet<String> headerSet = new LinkedHashSet<>();
        for (Map<String, Object> record : data) {
            if (record != null) {
                headerSet.addAll(record.keySet());
            }
        }
        List<String> headers = new ArrayList<>(headerSet);

        // ── Step 2: Build the header row ──
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", headers));

        // ── Step 3: Build each data row ──
        for (Map<String, Object> record : data) {
            // Skip null items gracefully
            if (record == null) {
                continue;
            }
            sb.append("\n");
            // Map each header to its value in this record, or "" if missing
            String row = headers.stream()
                    .map(h -> {
                        Object val = record.get(h);
                        return val != null ? val.toString() : "";
                    })
                    .collect(Collectors.joining(","));
            sb.append(row);
        }

        return sb.toString();
    }
}
