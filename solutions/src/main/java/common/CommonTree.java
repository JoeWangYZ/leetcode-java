package common;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by joe wang on 2017/2/24.
 */
public class CommonTree {
    /**
     * Definition for a binary tree node.
     **/
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static class BTreeNode {
        private int order;//
        public int keyNum;
        public BTreeNode parent;
        public int[] key;
        public BTreeNode[] childs;

        public BTreeNode(int order) {
            this.order = order;
            this.key = new int[order + 1];
            this.childs = new BTreeNode[order + 1];
        }
    }

    TreeNode root;


    public CommonTree(int[] array){
        root=makeBinaryTreeByArray(array,1);
    }



    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    public void levelOrderTravel() {
        if(root == null){
            System.out.println("empty tree");
            return;
        }
        Queue<TreeNode> queue = new PriorityQueue<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.remove();
            System.out.print(parent.val + " ");
            if (null != parent.left) {
                queue.add(parent.left);
            }
            if (null != parent.right) {
                queue.add(parent.right);
            }
        }
        System.out.print("\n");
    }

    public void depthOrderTravel() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            System.out.print(parent.val + " ");
            if (null != parent.right) {
                stack.push(parent.right);
            }
            if (null != parent.left) {
                stack.push(parent.left);
            }
        }
    }
}
