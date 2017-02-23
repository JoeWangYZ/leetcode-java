package tree;

/**
 * Created by wangyuzhou on 2017/2/23.
 */
public class MaximumDepth {

    /**
     * Definition for a binary tree node.
     **/
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
    }

    public static void main (String[] args) {

    }
}
