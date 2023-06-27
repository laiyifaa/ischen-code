package hot_100.binaryTree;

public class maxDepth {
    public int maxDepth(TreeNode root) {
        if(null == root)
            return 0;
        int hl = maxDepth(root.left)+1;
        int hr = maxDepth(root.right)+1;
        return hl>hr?hl:hr;
    }
}
