package contest.weeklycontest178;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallerNumbersThanCurrent {
  public int[] smallerNumbersThanCurrent(int[] nums) {

    int size = nums.length;
    int[] result = new int[size];
    Arrays.fill(result, 0);
    for (int i = 0; i < size; i ++) {
      for (int j = 0; j < size; j ++) {
        if (j != i && nums[j] < nums[i]) {
          result[i] ++;
        }
      }
    }
    return result;

  }

  /**
   * 作者：lzhlyle
   *   链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/solution/java-pai-xu-yu-ying-she-by-lzhlyle/
   *   来源：力扣（LeetCode）
   *   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param nums
   * @return
   */
  public int[] optimizedSmallerNumbersThanCurrent(int[] nums) {
    // 8, 1, 2, 2, 3
    int len = nums.length;
    Map<Integer, Set<Integer>> valueIndex = new HashMap<>(len); // 预存每个值与索引对应
    for (int i = 0; i < len; i++) {
      if (!valueIndex.containsKey(nums[i])) valueIndex.put(nums[i], new HashSet<>());
      valueIndex.get(nums[i]).add(i);
    }
    int[] sortedArr = Arrays.copyOf(nums, len), res = new int[len];
    Arrays.sort(sortedArr); // 1, 2, 2, 3, 8
    for (int si = len - 1; si >= 0; si--) {
      for (int i : valueIndex.get(sortedArr[si])) res[i] = si; // 同值的所有索引都更新
    }
    return res;
  }


}
