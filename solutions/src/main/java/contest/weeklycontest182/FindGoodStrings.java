package contest.weeklycontest182;

public class FindGoodStrings {
  public int findGoodStrings(int n, String s1, String s2, String evil) {
    int totalCount = 0;
    for (int i = n - 1; i >= 0; i --) {
      char c = s1.charAt(i);
      if (c == 'z') {
        continue;
      }
      boolean needEnd =false;
      while (c < 'z') {
        String newString = new StringBuilder().append(s1.substring(0, i)).append((char) (c + 1)).toString();
        if (newString.contains(evil)) {
          c ++;
          continue;
        }
        if (newString.compareTo(s2) > 0) {
          needEnd = true;
          break;
        }
        c ++;
        totalCount ++;
      }
      if (needEnd) {
        break;
      }
    }
    return totalCount;

  }
  public static void main(String[] args) {

  }
}
