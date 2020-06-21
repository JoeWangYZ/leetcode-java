package contest.weeklycontest187;

public class LongestSubarray {
  public int longestSubarray(int[] nums, int limit) {
    int i = 0;
    int maxStart = 0;
    int maxEnd = 0;
    int start = 0;
    int end = 0;
    while (i < nums.length - 1) {
      start = i;
      int j = i + 1;
      int m = i;
      int curMin = nums[i];
      int curMax = nums[i];
      while (j < nums.length) {
        if (Math.abs(nums[j] - curMax) > limit || Math.abs(nums[j] - curMin) > limit) {
          break;
        }
        if (curMax < nums[j]) {
          curMax = nums[j];
        }
        if (curMin > nums[j]) {
          curMin = nums[j];
        }
        j ++;

      }
      end = j - 1;
      if (end - start > (maxEnd - maxStart)) {
        maxEnd = end;
        maxStart = start;
      }
      i ++;
    }
    return maxEnd - maxStart + 1;
  }

  public static void main(String[] args) {
    LongestSubarray longestSubarray = new LongestSubarray();
    int[] nums = {10,1,2,4,7,2};
    int limit = 5;
    System.out.println(longestSubarray.longestSubarray(nums, limit));
  }
}
