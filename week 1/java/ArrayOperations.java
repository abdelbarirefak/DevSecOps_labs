/**
 * ArrayOperations — Exercise 3
 *
 * Provides findMax() to locate the maximum element in an int array.
 *   • Uses a single-pass linear scan — O(n) time, O(1) space.
 *   • Handles arrays of any size ≥ 1.
 *   • Rejects null or empty arrays with IllegalArgumentException.
 */
public class ArrayOperations {

    /**
     * Returns the maximum value in the given array.
     *
     * Algorithm: Linear scan — initialise max to the first element,
     * then iterate through the remaining elements, updating max
     * whenever a larger value is found.  This is optimal for an
     * unsorted array because every element must be inspected at
     * least once.
     *
     * Time complexity:  O(n)
     * Space complexity: O(1)
     *
     * @param array the array to search (must not be null or empty)
     * @return the maximum value
     * @throws IllegalArgumentException if array is null or empty
     */
    public int findMax(int[] array) {
        // Guard clause: reject null or empty arrays early
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        // Start with the first element as the running maximum
        int max = array[0];

        // Compare every subsequent element against the current max
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
