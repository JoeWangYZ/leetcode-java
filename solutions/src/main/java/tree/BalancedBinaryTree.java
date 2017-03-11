package tree;

import common.CommonTree;

/**
 * Created by joe wang on 2017/2/24.
 */
public class BalancedBinaryTree {
    private boolean isBalanced = true;
    public boolean isBalanced(CommonTree.TreeNode root) {
        getDepth(root);
        return isBalanced;
    }



    private int getDepth(CommonTree.TreeNode root) {
        if (null == root || !this.isBalanced) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            this.isBalanced = false;
        }
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }

}
