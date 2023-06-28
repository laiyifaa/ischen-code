package hot_100.binaryTree;

public class isSymmetric {

    private boolean check(TreeNode lnode,TreeNode rnode){
        if(null == lnode && null == rnode)
            return true;
       /* if(null == lnode && null != rnode)
            return false;
        if(null == rnode && null != lnode)
            return false;*/
       if(null == lnode || null == rnode)
           return false;
        if(lnode.val != rnode.val)
            return false;
        return check(lnode.left,rnode.right)&&check(lnode.right,rnode.left);
    }
    //101. 对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(null == root)
            return true;
        return check(root.left,root.right);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = null;
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(3);
        System.out.println(new isSymmetric().isSymmetric(root));
    }
}
