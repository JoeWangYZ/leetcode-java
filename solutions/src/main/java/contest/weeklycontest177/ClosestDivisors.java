package contest.weeklycontest177;

/**
 * https://leetcode-cn.com/problems/closest-divisors/
 * STATUS:PASS
 */
public class ClosestDivisors {
  public int[] closestDivisors(int num) {
    int[] result = new int[2];
    if (num == 2) {
      result[0] = 2;
      result[1] = 2;
      return result;
    }
    int mid = (int)Math.sqrt((double)(num + 1));
    int i = mid;
    int j = mid;
    int mid2 = (int)Math.sqrt((double)(num + 2));
    if (mid * mid == num + 1 || mid * mid == num + 2) {
      result[0] = mid;
      result[1] = mid;
      return result;
    } else if (mid2 * mid2 == num + 1 || mid2 * mid2 == num + 2) {
      result[0] = mid2;
      result[1] = mid2;
      return result;
    }

    while ((i >= 0 || j <= num + 1)) {
      int temp = i * j;
      if ((i * j == num + 1) || (i * j == num + 2)) {
        result[0] = i;
        result[1] = j;
        return result;
      } else if (temp > (num + 2)) {
        i --;
      } else if (temp < num + 1) {
        j ++;
      }
    }
    return result;

  }
}
