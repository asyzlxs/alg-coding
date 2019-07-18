package CodingInterview;

public class _08_NextNodeInBinaryTree {

    static class BinaryTreeNode {
        int val;
        BinaryTreeNode parent;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.parent = this.left = this.right = null;
        }
    }


    public static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null)
            return null;

        BinaryTreeNode next = null;
        BinaryTreeNode current = null;

        if (node.right != null) {
            current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            next = current;
        } else if (node.parent != null) {
            current = node;
            BinaryTreeNode parent = current.parent;
            while (parent != null && current == parent.right) {
                current = parent;
                parent = current.parent;
            }
            next = parent;
        }

        return next;
    }

    public static void main(String[] args) {
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.left.parent = root;
        root.right = new BinaryTreeNode(3);
        root.right.parent = root;
        root.left.left = new BinaryTreeNode(4);
        root.left.left.parent = root.left;
        root.left.right = new BinaryTreeNode(5);
        root.left.right.parent = root.left;

        System.out.println(getNext(root.left.left).val);
        System.out.println(getNext(root.left).val);
        System.out.println(getNext(root.left.right).val);
        System.out.println(getNext(root).val);
        System.out.println(getNext(root.right));

    }
}
