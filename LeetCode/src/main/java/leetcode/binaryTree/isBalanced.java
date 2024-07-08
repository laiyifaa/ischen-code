package leetcode.binaryTree;

public class isBalanced {
    //面试题 04.04. 检查平衡性
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return flag;
    }
    public int maxDepth(TreeNode root) {
        if(null == root)
            return 0;
        if(!flag){
            return -1;
        }
        int hl = maxDepth(root.left)+1;
        int hr = maxDepth(root.right)+1;
        if(Math.abs(hl - hr) > 1){
            flag = false;
        }
        return hl>hr?hl:hr;
    }
}
