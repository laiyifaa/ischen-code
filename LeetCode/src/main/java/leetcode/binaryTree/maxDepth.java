package leetcode.binaryTree;

public class maxDepth {
    //104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(null == root)
            return 0;
        int hl = maxDepth(root.left)+1;
        int hr = maxDepth(root.right)+1;
        return hl>hr?hl:hr;
    }
}
