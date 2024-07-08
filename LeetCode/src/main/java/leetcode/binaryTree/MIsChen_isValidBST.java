package leetcode.binaryTree;

public class MIsChen_isValidBST {
    //98. 验证二叉搜索树
    public boolean isValidBST(TreeNode root) {
      return validBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean validBST(TreeNode root,long lmax,long rmin){
        if(null == root)
            return true;
        if(root.val>=rmin || root.val<=lmax)
            return false;
        return validBST(root.left,lmax,root.val)&&validBST(root.right,root.val,rmin);
    }

}
