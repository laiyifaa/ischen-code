package leetcode.binaryTree;

public class invertTree {
    TreeNode temp;
    //226. 翻转二叉树
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
