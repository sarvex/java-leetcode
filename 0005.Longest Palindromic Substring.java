import java.util.Objects;

final class Solution {
  /**
   * Expand Around Center for Longest Palindromic Substring (Java 24)
   *
   * @intuition
   *            A palindrome mirrors around its center. We can expand from each
   *            center and track the longest palindrome found.
   *
   * @approach
   *           Iterate through each character, expanding around both single and
   *           double centers. Update the longest found.
   *
   * @complexity
   *             Time: O(n^2)
   *             Space: O(1) (ignoring output)
   */
  public String longestPalindrome(final String s) {
    Objects.requireNonNull(s);
    final int n = s.length();
    if (n < 2)
      return s;
    int start = 0, maxLen = 1;
    // Local lambda for expanding around center
    java.util.function.BiFunction<Integer, Integer, int[]> expandFromCenter = (left, right) -> {
      while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
        --left;
        ++right;
      }
      return new int[] { left + 1, right - left - 1 };
    };
    for (int center = 0; center < n; ++center) {
      int[] odd = expandFromCenter.apply(center, center);
      int[] even = expandFromCenter.apply(center, center + 1);
      int[] best = odd[1] > even[1] ? odd : even;
      if (best[1] > maxLen) {
        start = best[0];
        maxLen = best[1];
      }
    }
    return s.substring(start, start + maxLen);
  }

}
