package contest.weeklycontest179;

import java.util.Arrays;

/**
 *  https://leetcode-cn.com/problems/bulb-switcher-iii/
 *  STATUS:PASS
 */
public class BulbSwitcheriii {
  public int numTimesAllBlue(int[] light) {
    int n = light.length;
    int[] lightStatusMap = new int[n];
    Arrays.fill(lightStatusMap, 0);
    int result = 0;
    int maxLight = 0;
    for (int i = 0; i < n; i ++) {
      int curLight = light[i] - 1;
      lightStatusMap[curLight] = -1;
      boolean isBlue = true;
      if (maxLight < curLight) {
        for (int j = curLight - 1; j >= 0; j --) {
          if (lightStatusMap[j] == 0) {
            isBlue = false;
            break;
          } else if (lightStatusMap[j] == 1) {
            break;
          }
        }
        if (isBlue) {
          result ++;
          lightStatusMap[curLight] = 1;
        }
      } else {
        for (int j = curLight - 1; j >= 0; j --) {
          if (lightStatusMap[j] == 0) {
            isBlue = false;
            break;
          } else if (lightStatusMap[j] == 1) {
            break;
          }
        }
        if (isBlue) {
          for (int j = curLight; j < maxLight; j ++) {
            if (lightStatusMap[j] == 0) {
              isBlue = false;
              break;
            } else {
              lightStatusMap[j] = 1;
            }
          }
        }
        if (isBlue) {
          result ++;
        }
      }

      maxLight = Math.max(maxLight, light[i] - 1);


    }
    return result;
  }

  private boolean isBlue(int[] lightStatusMap, int curLight) {
    for (int i = curLight - 1; i >= 0; i --) {
      if (lightStatusMap[i] == 1) {
        return true;
      } else if (lightStatusMap[i] == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] input = new int[] {1,2,3,4,5,6};
    BulbSwitcheriii bulbSwitcheriii = new BulbSwitcheriii();
    System.out.println("result: " + bulbSwitcheriii.numTimesAllBlue(input));
  }
}
