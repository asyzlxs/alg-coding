package structure;

public class TreeNode<T> {
    public T val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
