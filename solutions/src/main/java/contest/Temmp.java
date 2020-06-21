package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Temmp {
  private class TreeNode {
    boolean hasApple;
    List<TreeNode> children;
    int hereToCost;

    public TreeNode(boolean hasApple, int hereToCost) {
      this.hasApple = hasApple;
      this.hereToCost = hereToCost;
      children = new ArrayList();
    }

    public void addChild(TreeNode t) {
      this.children.add(t);
    }
  }
  int totalGotApple = 0;
  int totalApple = 0;
  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    Map<Integer, TreeNode> indexToNode = new HashMap();
    TreeNode root = new TreeNode(hasApple.get(0), 0);
    indexToNode.put(0, root);


    for (int i = 0; i < hasApple.size(); i ++) {
      if (hasApple.get(i)) {
        totalApple ++;
      }
    }

    int totalCost = 0;
    List<TreeNode> hasAppleNodes = new ArrayList();


    for (int i = 0; i < edges.length; i ++) {
      if (totalGotApple == totalApple) {
        break;
      }
      int[] startToEnd = edges[i];
      TreeNode curParent = indexToNode.get(startToEnd[0]);
      int end = startToEnd[1];
      boolean childHasApple = hasApple.get(end);
      TreeNode child = new TreeNode(childHasApple, curParent.hereToCost + 1);
      if (childHasApple) {
        totalGotApple ++;
        hasAppleNodes.add(child);
      }

      indexToNode.put(end, child);
      curParent.addChild(child);

    }
    totalGotApple = 0;

    return deep(root);
  }

  private int deep(TreeNode node) {
    if (totalGotApple == totalApple) {
      return 0;
    }
    List<TreeNode> children = node.children;
    if (null == children || children.size() == 0) {
      if (node.hasApple) {
        totalGotApple ++;
        return 2;
      } else {
        return 0;
      }

    }
    int totalCost = 0;
    for (TreeNode child : children) {
      totalCost += deep(child);
    }
    return totalCost;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{2,3,1,6,7};
    int n = 7;
    int[][] edges = new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
    List<Boolean> apple = Arrays.asList(false,false,true,false,true,true,false);
    System.out.println(new Temmp().minTime(n , edges, apple));

    List<String> test = new ArrayList<>();
    Collections.sort(test, (o1, o2) -> o1.length() - o2.length());

  }
}
