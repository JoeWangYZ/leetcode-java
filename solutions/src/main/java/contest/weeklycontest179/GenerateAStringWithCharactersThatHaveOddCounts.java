package contest.weeklycontest179;

/**
 * https://leetcode-cn.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 * STATUS:PASS
 */
public class GenerateAStringWithCharactersThatHaveOddCounts {
  public String generateTheString(int n) {
    StringBuffer sb = new StringBuffer();
    String endwithZ = "abcdefghijklmnopqrstuvwxyz";
    String endwithY = "abcdefghijklmnopqrstuvwxyy";
    if (n <= 26) {
      return endwithZ.substring(0, n);
    }
    int diff = n - 26;
    if (diff % 2 == 0) {
      sb.append(endwithZ);
      for (int i = 0; i < diff; i ++) {
        sb.append("z");
      }
    } else {
      sb.append(endwithY);
      for (int i = 0; i < diff; i ++) {
        sb.append("y");
      }
    }
    return sb.toString();
  }
}
