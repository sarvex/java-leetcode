import java.util.HashMap;
import java.util.Map;

/**
 * Returns indices of the two numbers such that they add up to the target.
 * Assumes exactly one solution exists.
 */
public final class Solution {
  public record Indices(int first, int second) {
  }

  /**
   * Finds two distinct indices such that nums[i] + nums[j] == target.
   *
   * @param nums   the array of integers
   * @param target the target sum
   * @return indices as an array [i, j]
   * @throws IllegalArgumentException if no solution is found
   */
  public int[] twoSum(final int[] nums, final int target) {
    final Map<Integer, Integer> seen = new HashMap<>();
    for (var index = 0; index < nums.length; index++) {
      final var complement = target - nums[index];
      if (seen.containsKey(complement)) {
        return new int[] { seen.get(complement), index };
      }
      seen.put(nums[index], index);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}
