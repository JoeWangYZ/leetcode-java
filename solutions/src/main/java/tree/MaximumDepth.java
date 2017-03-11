package tree;

import common.CommonTree;

/**
 * Created by joe wang on 2017/2/23.
 */
public class MaximumDepth {


    public static int maxDepth(CommonTree.TreeNode root) {
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
