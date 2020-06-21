package contest.weeklycontest191;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MaxArea {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    List<Area> areaList = new ArrayList();
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    Area firstArea = new Area(0, horizontalCuts[0]);
    areaList.add(firstArea);
    for (int i = 0; i < horizontalCuts.length - 1; i ++) {
      Area area = new Area(horizontalCuts[i], horizontalCuts[i + 1]);
      areaList.add(area);
    }
    Area finalArea = new Area(horizontalCuts[horizontalCuts.length - 1], h);
    areaList.add(finalArea);
    int maxArea = 0;
    int firstWEnd = verticalCuts[0];
    int maxWGap = verticalCuts[0];

    for (int i = 0; i < verticalCuts.length - 1; i ++) {

      int curGap = verticalCuts[i + 1] - verticalCuts[i];
      if (curGap > maxWGap) {
        maxWGap = curGap;
      }
    }
    if (maxWGap < w - verticalCuts[verticalCuts.length - 1]) {
      maxWGap = w - verticalCuts[verticalCuts.length - 1];
    }
    for (Area area : areaList) {
      int curArea = (area.hEnd - area.hStart) * maxWGap;
      if (maxArea < curArea) {
        maxArea = curArea;
      }
    }

    return maxArea % 100000007;
  }

  private class Area {
    int hStart;
    int hEnd;


    public Area (int hStart, int hEnd) {
      this.hStart = hStart;
      this.hEnd = hEnd;
    }


  }

  public static void main(String[] args) {
    MaxArea maxArea = new MaxArea();
//    int[] hc1 = new int[]{3, 1};
//    int[] vc1 = new int[]{1};
//    System.out.println(maxArea.maxArea(5, 4, hc1, vc1));
//    int[] hc = new int[]{1, 2, 4};
//    int[] vc = new int[]{1, 3};
//    System.out.println(maxArea.maxArea(5, 4, hc, vc));
    Stack<String> stack = new Stack<>();
    stack.clear();
    Map<Integer, Integer> map = new HashMap<>();
    List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
    Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override public int compare(
          Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o1.getValue() - o2.getValue();
      }
    });

  }
}
