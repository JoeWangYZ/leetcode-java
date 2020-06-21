package contest.weeklycontest189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumPoints {
  Map<Integer, Integer> disMap = new HashMap();

  double[][] memo;
  public int numPoints(int[][] points, int r) {
    memo = new double[points.length][points.length];
    for (int i = 0; i < points.length; i ++) {
      Arrays.fill(memo[i], 0.0);
    }
    List<Point> rPoints = new ArrayList();
    for (int i = 0; i < points.length; i ++) {
      Point p = new Point(points[i][0], points[i][1], i);
      rPoints.add(p);
    }
    double longest = 0.0;
    int count = 0;
    int maxCount = 0;
    int maxCountIndex = 0;
    for (int i = 0; i < rPoints.size() - 1; i ++) {
      count = 0;
      for (int j = i + 1; j < rPoints.size(); j ++) {
        double dis = rPoints.get(i).disToOther(rPoints.get(j));
        if (dis > longest) {
          longest = dis;
        }
        memo[i][j] = dis;
        if (dis > r) {
          count ++;
        }
      }
      if (count > maxCount) {
        maxCount = count;
        maxCountIndex = i;
      }
    }
    return maxCount;

  }



  class Point {
    int x;
    int y;
    int index;
    public Point(int x, int y, int index) {
      this.x = x;
      this.y = y;
      this.index = index;
    }
    public double disToOther(Point other) {
      int disx = Math.abs(x - other.x);
      int disy = Math.abs(y - other.y);
      return Math.sqrt(disx * disx + disy * disy);
    }
  }

  public static void main(String[] args) {
    NumPoints numPoints = new NumPoints();
    int[][] points = {{-2,0},{2,0},{0,2},{0,-2}};
    numPoints.numPoints(points, 2);
  }
}
