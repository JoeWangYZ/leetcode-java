package contest.weeklycontest177;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/validate-binary-tree-nodes/
 * STATUS:PASS
 */
public class ValidateBinaryTreeNodes {
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    int[] childRecord = new int[n];
    Arrays.fill(childRecord, 0);
    Map<Integer, Integer> childToParentMap = new HashMap();
    Map<Integer, Integer> parentToChildMap = new HashMap();
    int lineCount = 0;
    for (int i = 0; i < n; i ++) {
      int left = leftChild[i];
      int right = rightChild[i];
      if (left != -1) {
        if (childToParentMap.containsKey(left)) {
          return false;
        }
        childToParentMap.put(left, i);
        lineCount ++;
        if (parentToChildMap.containsKey(left) && parentToChildMap.get(left) == i) {
          return false;
        }
        parentToChildMap.put(i, left);

      }
      if (right != -1) {
        if (childToParentMap.containsKey(right)) {
          return false;
        }
        childToParentMap.put(right, i);
        lineCount ++;
        if (parentToChildMap.containsKey(right) && parentToChildMap.get(right) == i) {
          return false;
        }
        parentToChildMap.put(i, right);
      }


    }
    if (lineCount < n - 1) {
      return false;
    } else {
      return true;
    }
  }
}
