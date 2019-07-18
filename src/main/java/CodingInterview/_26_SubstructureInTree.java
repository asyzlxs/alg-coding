package CodingInterview;

import structure.TreeNode;

public class _26_SubstructureInTree {

    public static boolean hasSubtree(TreeNode<Double> root1, TreeNode<Double> root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        boolean result = false;

        if (equal(root1.val, root2.val))
            result = doesTree1HasTree2(root1, root2);
        if (!result)
            result = hasSubtree(root1.left, root2);
        if (!result)
            result = hasSubtree(root1.right, root2);

        return result;

    }

    public static boolean doesTree1HasTree2(TreeNode<Double> root1, TreeNode<Double> root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (!equal(root1.val, root2.val))
            return false;
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }

    public static boolean equal(double double1, double double2) {
        return double1 - double2 >= -0.0000001 && double1 - double2 <= 0.0000001;
    }

    public static void main(String[] args) {
        TreeNode<Double> root1 = new TreeNode<>(8.0);
        root1.left = new TreeNode<>(8.0);
        root1.right = new TreeNode<>(7.0);
        root1.left.left = new TreeNode<>(9.0);
        root1.left.right = new TreeNode<>(2.0);
        root1.left.right.left = new TreeNode<>(4.0);
        root1.left.right.right = new TreeNode<>(7.0);
        TreeNode<Double> root2 = new TreeNode<>(8.0);
        root2.left = new TreeNode<>(9.0);
        root2.right = new TreeNode<>(2.0);
        TreeNode<Double> root3 = new TreeNode<>(2.0);
        root3.left = new TreeNode<>(4.0);
        root3.right = new TreeNode<>(3.0);
        System.out.println(hasSubtree(root1, root2));
        System.out.println(hasSubtree(root1, root3));
    }
}
