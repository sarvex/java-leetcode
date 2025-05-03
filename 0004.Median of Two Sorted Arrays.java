/**
 * Efficiently finds the median of two sorted arrays using divide and conquer.
 *
 * @intuition
 *            Reduce the problem to finding the k-th smallest element by
 *            recursively discarding parts of the arrays.
 *
 * @approach
 *           Use a helper to find the k-th smallest element, always discarding
 *           the smaller k/2 prefix from one array.
 *           Avoid extra space and minimize branching. Use static methods and no
 *           unnecessary fields.
 *
 * @complexity
 *             Time: O(log(min(m, n)))
 *             Space: O(1)
 */
public final class Solution {
  public double findMedianSortedArrays(final int[] nums1, final int[] nums2) {
    final int m = nums1.length, n = nums2.length;
    final int left = kth(nums1, 0, nums2, 0, (m + n + 1) / 2);
    final int right = kth(nums1, 0, nums2, 0, (m + n + 2) / 2);
    return (left + right) / 2.0;
  }

  private static int kth(final int[] a, final int i, final int[] b, final int j, final int k) {
    if (i >= a.length)
      return b[j + k - 1];
    if (j >= b.length)
      return a[i + k - 1];
    if (k == 1)
      return Math.min(a[i], b[j]);
    final int ai = i + k / 2 - 1 < a.length ? a[i + k / 2 - 1] : Integer.MAX_VALUE;
    final int bj = j + k / 2 - 1 < b.length ? b[j + k / 2 - 1] : Integer.MAX_VALUE;
    return ai < bj
        ? kth(a, i + k / 2, b, j, k - k / 2)
        : kth(a, i, b, j + k / 2, k - k / 2);
  }
}
