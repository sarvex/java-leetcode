/**
 * Sliding window for longest substring without repeats using modern Java.
 *
 * @intuition Use two pointers to maintain a window of unique characters. Move
 *            the right pointer to expand, left to shrink on duplicates.
 *
 * @approach Track last seen positions of characters using an int array (ASCII).
 *           For each character, if seen, move left pointer past its last index.
 *           Update max length.
 *
 * @complexity
 *             Time: O(n) — each character is visited at most twice.
 *             Space: O(1) — constant space for ASCII character tracking.
 */
public final class Solution {
    public int lengthOfLongestSubstring(final String s) {
        final int[] lastSeen = new int[128];
        int maxLen = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            final char c = s.charAt(right);
            left = Math.max(lastSeen[c], left);
            maxLen = Math.max(maxLen, right - left + 1);
            lastSeen[c] = right + 1;
        }
        return maxLen;
    }
}
