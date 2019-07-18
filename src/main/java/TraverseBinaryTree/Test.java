package TraverseBinaryTree;

import structure.TreeNode;

import static TraverseBinaryTree.Traverse.*;

public class Test {

    static void test_1(TreeNode<Integer> root) {
        preOrderTraverseNonRecursion(root);
    }

    static void test_2(TreeNode<Integer> root) {
        preOrderTraverseRecursion(root);
    }

    static void test_3(TreeNode<Integer> root){
        inOrderTraverseRecursion(root);
    }

    static void test_4(TreeNode<Integer> root){
        inOrderTraverseNonRecursion(root);
    }

    static void test_5(TreeNode<Integer> root){
        postOrderTraverseRecursion(root);
    }

    static void test_6(TreeNode<Integer> root){
        postOrderTrverseNonRecursion(root);
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(6);
        root.right = new TreeNode<>(14);
        root.left.left = new TreeNode<Integer>(4);
        root.left.right = new TreeNode<Integer>(8);
        root.right.left = new TreeNode<Integer>(12);
        root.right.right = new TreeNode<Integer>(16);

        test_1(root);
        System.out.println();
        test_2(root);
        System.out.println();
        test_3(root);
        System.out.println();
        test_4(root);
        System.out.println();
        test_5(root);
        System.out.println();
        test_6(root);
    }
}
