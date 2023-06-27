package hot_100.binaryTree;

public class invertTree {
    TreeNode temp;
    public TreeNode invertTree(TreeNode root) {
        if(null == root)
            return null;
        invertTree(root.left);
        invertTree(root.right);
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
