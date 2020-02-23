package contest.weeklycontest172;

import common.CommonTree.TreeNode;

/**
 * https://leetcode-cn.com/contest/weekly-contest-172/problems/delete-leaves-with-a-given-value/
 * Created by wangyuzhou on 2020/1/19.
 * LEVEL: MID
 * STATUS: PASS: https://leetcode-cn.com/submissions/detail/44798289/
 *
 */
public class RemoveLeafNodes {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (null == root) {
            return null;
        }

        if (null != root.left) {
            isTarget(root, root.left, target, true);
        }
        if (null != root.right) {
            isTarget(root, root.right, target, false);
        }
        if (null == root.right && null == root.left && root.val == target) {
            root = null;
        }

        return root;
    }

    private void isTarget(TreeNode parent, TreeNode node, int target, boolean isLeft) {
        if (null == node) {
            return;
        }

        if (null != node.left) {
            isTarget(node, node.left, target, true);
        }
        if (null != node.right) {
            isTarget(node, node.right, target, false);
        }
        if (null == node.right && null == node.left && node.val == target) {
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }
}
