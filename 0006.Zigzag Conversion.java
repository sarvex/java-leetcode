
import java.util.*;

public final class Solution {
  /**
   * Simulate zigzag row traversal and collect characters efficiently.
   *
   * @intuition: Place each character in the appropriate row, switching direction
   *             at the top and bottom.
   * @approach: Use an array of StringBuilder, iterate through the input, and
   *            append to the correct row, reversing direction as needed.
   * @complexity: Time O(n), Space O(n)
   */
  public String convert(final String s, final int numRows) {
    if (numRows == 1 || s.length() <= numRows)
      return s;
    final var rows = new StringBuilder[numRows];

    Arrays.setAll(rows, i -> new StringBuilder());
    int row = 0, step = 1;

    for (final char c : s.toCharArray()) {
      rows[row].append(c);
      if (row == 0 || row == numRows - 1)
        step = -step;
      row += step;
    }
    return String.join("", rows);
  }
}
