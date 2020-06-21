package contest.weeklycontest181;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import contest.weeklycontest179.TimeNeededToInformAllEmployees;

/**
 * https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 * STATUS:PASS
 */
public class HasValidPath {
  private int m;
  private int n;
  public boolean hasValidPath(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    int x = 0;
    int y = 0;
    int curNo = grid[0][0];
    int curDirect = -1;
    if (curNo == 5) {
      return false;
    } else if (curNo == 4) {
      curDirect = 4;
      while(x < n && y < m) {
        curNo = grid[y][x];
        int nextS = nextStep(grid, curNo, x, y, curDirect);
        if (nextS == -1) {
          break;
        }
        switch(nextS) {
          case 1:
            y --;
            curDirect = 2;
            break;
          case 2 :
            y ++;
            curDirect = 1;
            break;
          case 3:
            x --;
            curDirect = 4;
            break;
          case 4:
            curDirect = 3;
            x ++;
            break;
        }
        if (x == n - 1  && y == m - 1) {
          return true;
        }
      }
      x = 0;
      y = 0;
      curDirect = 2;
      while(x < n && y < m) {
        curNo = grid[y][x];
        int nextS = nextStep(grid, curNo, x, y, curDirect);
        if (nextS == -1) {
          break;
        }
        switch(nextS) {
          case 1:
            y --;
            curDirect = 2;
            break;
          case 2 :
            y ++;
            curDirect = 1;
            break;
          case 3:
            x --;
            curDirect = 4;
            break;
          case 4:
            curDirect = 3;
            x ++;
            break;
        }
        if (x == n - 1  && y == m - 1) {
          return true;
        }
      }

    } else {
      switch(curNo) {
        case 1:
          curDirect = 3;
          break;
        case 2:
          curDirect = 1;
          break;
        case 3:
          curDirect = 3;
          break;
        case 6:
          curDirect = 1;
          break;
      }
      while(x < n && y < m) {
        curNo = grid[y][x];
        int nextS = nextStep(grid, curNo, x, y, curDirect);
        if (nextS == -1) {
          break;
        }
        switch(nextS) {
          case 1:
            y --;
            curDirect = 2;
            break;
          case 2 :
            y ++;
            curDirect = 1;
            break;
          case 3:
            x --;
            curDirect = 4;
            break;
          case 4:
            curDirect = 3;
            x ++;
            break;
        }
        if (x == n - 1  && y == m - 1) {
          return true;
        }
      }
    }
    return false;
  }

  private int nextStep(int[][] grid, int curNo, int curX, int curY, int fromDirect) {

    switch(curNo) {
      case 1:
        if (fromDirect == 3) {
          if (curX == n - 1) {
            return -1;
          }
          int nextNo = grid[curY][curX + 1];
          if (nextNo == 3 || nextNo == 5 || nextNo == 1) {
            return 4;
          } else {
            return -1;
          }
        } else if (fromDirect == 4) {
          if (curX == 0) {
            return -1;
          }
          int nextNo = grid[curY][curX - 1];
          if (nextNo == 4 || nextNo == 6 || nextNo == 1) {
            return 3;
          } else {
            return -1;
          }
        } else return -1;
      case 2:
        if (fromDirect == 1) {
          if (curY == m - 1) {
            return -1;
          }
          int nextNo = grid[curY + 1][curX];
          if (nextNo == 5 || nextNo == 6 || nextNo == 2) {
            return 2;
          } else {
            return -1;
          }
        } else if (fromDirect == 2) {
          if (curY == 0) {
            return -1;
          }
          int nextNo = grid[curY - 1][curX];
          if (nextNo == 3 || nextNo == 4 || nextNo == 2) {
            return 1;
          } else {
            return -1;
          }
        } else return -1;
      case 3:
        if (fromDirect == 3) {
          if (curY == m - 1) {
            return -1;
          }
          int nextNo = grid[curY + 1][curX];
          if (nextNo == 2 || nextNo == 6 || nextNo == 5) {
            return 2;
          } else {
            return -1;
          }
        } else if (fromDirect == 2) {
          if (curX == 0) {
            return -1;
          }
          int nextNo = grid[curY][curX - 1];
          if (nextNo == 4 || nextNo == 6 || nextNo == 1) {
            return 3;
          } else {
            return -1;
          }
        } else return -1;
      case 4:
        if (fromDirect == 4) {
          if (curY == m - 1) {
            return -1;
          }
          int nextNo = grid[curY + 1][curX];
          if (nextNo == 2 || nextNo == 6 || nextNo == 5) {
            return 2;
          } else {
            return -1;
          }
        } else if (fromDirect == 2) {
          if (curX == n - 1) {
            return -1;
          }
          int nextNo = grid[curY][curX + 1];
          if (nextNo == 3 || nextNo == 5 || nextNo == 1) {
            return 4;
          } else {
            return -1;
          }
        } else return -1;
      case 5:
        if (fromDirect == 1) {
          if (curX == 0) {
            return -1;
          }
          int nextNo = grid[curY][curX - 1];
          if (nextNo == 4 || nextNo == 6 || nextNo == 1) {
            return 3;
          } else {
            return -1;
          }
        } else if (fromDirect == 3) {
          if (curY == 0) {
            return -1;
          }
          int nextNo = grid[curY - 1][curX];
          if (nextNo == 3 || nextNo == 4 || nextNo == 2) {
            return 1;
          } else {
            return -1;
          }
        } else return -1;
      case 6:
        if (fromDirect == 1) {
          if (curX == n - 1) {
            return -1;
          }
          int nextNo = grid[curY][curX + 1];
          if (nextNo == 3 || nextNo == 5 || nextNo == 1) {
            return 4;
          } else {
            return -1;
          }
        } else if (fromDirect == 4) {
          if (curY == 0) {
            return -1;
          }
          int nextNo = grid[curY - 1][curX];
          if (nextNo == 3 || nextNo == 4 || nextNo == 2) {
            return 1;
          } else {
            return -1;
          }
        } else return -1;
    }
    return -1;
  }


  public int sumFourDivisors(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    List<Integer> result = new ArrayList();
    List<Integer> temp = new ArrayList();
    for (int i = nums.length - 1; i >= 0; i --) {
      temp = new ArrayList();
      int cur = nums[i];
      if (cur != 1) {
        temp.add(1);
        temp.add(cur);
      } else {
        break;
      }
      count = 2;
      for (int j = 2; j <= cur / 2; j ++) {
        if (cur % j == 0) {
          temp.add(j);
          count ++;
        }
        if (count > 4) {
          break;
        }
      }
      if (count == 4) {
        result.addAll(temp);
        continue;
      }
      if (count > 4) {
        continue;
      }
    }

    int sum = 0;
    for (int i = 0; i < result.size(); i ++) {
      sum += result.get(i);
    }
    return sum;

  }


  public static void main(String[] args) {
    HasValidPath hasValidPath = new HasValidPath();
//    int[][] grid = {{2,4,3},{6,5,2}};
//    int[][] grid = {{4, 1}, {6, 1}};
//    System.out.println("result: " + hasValidPath.hasValidPath(grid));
    int[] ss = {1,2,3,4,5,6,7,8,9,10};
    System.out.println(hasValidPath.sumFourDivisors(ss));
  }
}
