package CodingInterview;

import structure.TreeNode;

import static TraverseBinaryTree.Traverse.*;

public class _07_ConstructBinaryTree {

    public static TreeNode construct(int[] pre, int in[]) {
        if (pre == null || in == null || pre.length == 0 || pre.length != in.length)
            return null;
        return constructCore(pre, 0, in, 0, pre.length );
    }

    public static TreeNode constructCore(int[] pre, int preStart, int[] in, int inStart, int length) {
        if (length == 0)
            return null;

        TreeNode<Integer> root = new TreeNode<>(pre[preStart]);
        root.left = root.right = null;
        int rootInOrder = -1;
        for (int i = inStart; i < inStart + length; ++i) {
            if (in[i] == pre[preStart]) {
                rootInOrder = i;
                break;
            }
        }
//
//        if (rootInOrder == -1)
//            return null;

        int leftChildLength = rootInOrder - inStart;
        root.left = constructCore(pre, preStart + 1, in, inStart, leftChildLength);
        root.right = constructCore(pre, preStart + leftChildLength + 1, in, rootInOrder + 1, length - leftChildLength - 1);


        return root;

    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3};
        int[] in = {4, 2, 5, 1, 3};
        TreeNode root = construct(pre, in);
        //对重建后的树,进行前中后序遍历，验证是否重建正确
        //pre->12453  in->42513   post->45231
        preOrderTraverseRecursion(root);
        System.out.println();
        inOrderTraverseRecursion(root);
        System.out.println();
        postOrderTraverseRecursion(root);
    }


}
