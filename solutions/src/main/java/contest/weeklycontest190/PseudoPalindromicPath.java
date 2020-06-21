package contest.weeklycontest190;

import java.util.Arrays;

import common.CommonTree.TreeNode;

public class PseudoPalindromicPath {
  int totalSize = 0;
  public int pseudoPalindromicPaths (TreeNode root) {
    int[] memo = new int[10];
    Arrays.fill(memo, 0);
    isLoop(root, memo, 1);
    return totalSize;
  }

  private void isLoop(TreeNode node, int[] memo, int length) {
    memo[node.val] ++;
    if (node.left == null && node.right == null) {

      boolean isDouble = (length % 2 == 0);
      int singleCount = 0;
      for (int i = 0; i < memo.length; i ++) {
        if (memo[i] % 2 == 1) {
          if (isDouble || singleCount >= 1) {
            return;
          } else {
            singleCount ++;
          }
        }
      }
      totalSize ++;
    }
    if (node.left != null) {
      isLoop(node.left, Arrays.copyOf(memo, memo.length), length + 1);
    }
    if (node.right != null) {
      isLoop(node.right, Arrays.copyOf(memo, memo.length), length + 1);
    }
  }

  public static void main(String[] args) {
    PseudoPalindromicPath pseudoPalindromicPath = new PseudoPalindromicPath();
    TreeNode root = new TreeNode(2);
    TreeNode left = new TreeNode(3);
    TreeNode right = new TreeNode(1);
    root.left = left;
    root.right = right;
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(1);
    root.right.left = null;
    root.right.right = new TreeNode(1);
    pseudoPalindromicPath.pseudoPalindromicPaths(root);
  }
}
