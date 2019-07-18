package TraverseBinaryTree;

import structure.TreeNode;

import java.util.Stack;

public class Traverse {

    public static void preOrderTraverseRecursion(TreeNode<Integer> root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraverseRecursion(root.left);
            preOrderTraverseRecursion(root.right);
        }
    }

    public static void preOrderTraverseNonRecursion(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> st = new Stack<>();
        TreeNode<Integer> node = root;
        while (node != null || !st.isEmpty()) {
            if (node != null) {
                System.out.print(node.val + " ");
                st.push(node);
                node = node.left;
            } else {
                node = st.pop();
                node = node.right;
            }
        }
    }

    public static void inOrderTraverseRecursion(TreeNode<Integer> root) {
        if (root != null) {
            inOrderTraverseRecursion(root.left);
            System.out.print(root.val + " ");
            inOrderTraverseRecursion(root.right);
        }
    }

    public static void inOrderTraverseNonRecursion(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> st = new Stack<>();
        TreeNode<Integer> node = root;
        while (node != null || !st.isEmpty()) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                node = st.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    public static void postOrderTraverseRecursion(TreeNode<Integer> root) {
        if (root != null) {
            postOrderTraverseRecursion(root.left);
            postOrderTraverseRecursion(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void postOrderTrverseNonRecursion(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> st = new Stack<>();
        TreeNode<Integer> curNode = root;
        TreeNode<Integer> preNode = null;
        while (curNode != null) {
            st.push(curNode);
            curNode = curNode.left;
        }

        while (!st.isEmpty()) {
            curNode = st.pop();
            if (curNode.right!= null && preNode != curNode.right) {
                st.push(curNode);
                curNode = curNode.right;
                while (curNode!=null){
                    st.push(curNode);
                    curNode = curNode.left;
                }
            }
            else {
                System.out.print(curNode.val + " ");
                preNode = curNode;
            }

        }


    }


}
