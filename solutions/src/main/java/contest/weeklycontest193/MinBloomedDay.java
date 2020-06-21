package contest.weeklycontest193;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinBloomedDay {
  int remainM = 0;
  int totalM;
  public int minDays(int[] bloomDay, int m, int k) {
    int n = bloomDay.length;
    totalM = m;
    if (m * k > n) {
      return -1;
    } else if (m * k == n) {
      int max = 1;
      for (int i : bloomDay) {
        if (i > max) {
          max = i;
        }
      }
      return max;
    } else {
      remainM = m;
      Map<Integer, List<Integer>> dayToIndex = new HashMap();
      for (int i = 0; i < n; i ++) {
        List<Integer> indexes = dayToIndex.containsKey(bloomDay[i]) ? dayToIndex.get(bloomDay[i]) : new ArrayList();
        indexes.add(i);
        dayToIndex.put(bloomDay[i], indexes);
      }
      List<Map.Entry<Integer, List<Integer>>> entries = new ArrayList(dayToIndex.entrySet());
      Collections.sort(entries, new Comparator<Map.Entry<Integer, List<Integer>>>() {
        @Override public int compare(
            Map.Entry<Integer, List<Integer>> o1, Map.Entry<Integer, List<Integer>> o2) {
          return o1.getKey() - o2.getKey();
        }
      });
      int[] bloomed = new int[n];
      Arrays.fill(bloomed, 0);
      int bCount = 0;

      int lastFailed = 0;
      Map<Integer, Integer> bloomBeforeFailed = new HashMap<>();
      for (Map.Entry<Integer, List<Integer>> entry : entries) {
        List<Integer> indexes = entry.getValue();

        for (Integer in : indexes) {
          bloomed[in] = 1;
          bCount ++;

        }
        if (k > bCount) {
          continue;
        }
        if (remainM * k > bCount) {
          continue;
        }

        lastFailed = func(bloomed, k, bCount, lastFailed, bloomBeforeFailed);
        if (lastFailed == -1) {
          return entry.getKey();
        }
      }
      return -1;
    }

  }

  private int func(int[] bloom, int k, int bCount, int lastFailed, Map<Integer, Integer> bloomBeforeFailed) {
    int per = k;
    int tempBCount = 0;

    int thisFailed = lastFailed;

    boolean restore = false;
    int start = 0;
    int thisBCount = bCount;
    if (bloom[lastFailed] == 1) {
      bCount += bloomBeforeFailed.get(lastFailed);
      start = 0;
      remainM = totalM;
    } else {
      start = lastFailed;
    }
    for (int i = lastFailed; i < bloom.length; i ++) {
      if (remainM <= 0) {
        return -1;
      }
      if (remainM * k > bCount) {

        return thisFailed;
      }

      if (bloom[i] != 1) {
        per = k;
        bCount -= tempBCount;
        tempBCount = 0;

        thisFailed = i;
        continue;
      } else {
        if (!restore && i == lastFailed) {

        }
        tempBCount ++;
      }
      if (per <= 1) {
        remainM --;
        per = k;
        bCount -= tempBCount;
        tempBCount = 0;
      } else {
        per --;
      }
    }
    if (remainM > 0) {
      thisFailed = bloom.length - 1;
      return thisFailed;
    } else {
      return -1;
    }

  }

  public static void main(String[] args) {
    MinBloomedDay minBloomedDay = new MinBloomedDay();
//    int[] bloomDay = new int[]{1,10,2,9,3,8,4,7,5,6};
//    int m = 4;
//    int k = 2;
//    System.out.println(minBloomedDay.minDays(bloomDay, m, k));
//
//    int[] bloomDay2 = new int[]{7,7,7,7,12,7,7};
//    int m2 = 2;
//    int k2 = 3;
//    System.out.println(minBloomedDay.minDays(bloomDay2, m2, k2));
    int[] bloomDay3 = new int[]{62,75,98,63,47,65,51,87,22,27,73,92,76,44,13,90,100,85};
    int m3 = 2;
    int k3 = 7;
    System.out.println(minBloomedDay.minDays(bloomDay3, m3, k3));
  }
}
