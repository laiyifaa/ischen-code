package leetcode.binaryTree;

public class searchBST {
    //700. 二叉搜索树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if(null != root){
            if(root.val == val)
                return root;
            return root.val > val ? searchBST(root.left,val):searchBST(root.right,val);
        }
        return null;
    }
}
