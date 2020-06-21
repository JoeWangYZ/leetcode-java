package contest.weeklycontest181;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
 * STATUS:PASS
 */
public class CreateTargetArrayInTheGivenOrder {
  public int[] createTargetArray(int[] nums, int[] index) {
    List<Integer> result = new ArrayList();
    int n = nums.length;
    for (int i = 0; i < n; i ++) {
      result.add(index[i], nums[i]);
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
