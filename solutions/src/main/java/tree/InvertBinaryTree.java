package tree;

import common.CommonTree;

/**
 * Created by wangyuzhou on 2017/3/1.
 */
public class InvertBinaryTree {
    public CommonTree.TreeNode invertTree(CommonTree.TreeNode root) {
        if (null == root) {
            return null;
        }
        CommonTree.TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
