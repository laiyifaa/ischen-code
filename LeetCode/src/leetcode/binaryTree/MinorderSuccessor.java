package leetcode.binaryTree;

public class MinorderSuccessor {
    //面试题 04. 06. 后继者
    private TreeNode ans;
    private int flag ;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(null == root )
            return null;
        flag = 0;
        inorderSearch(root,p);
        return ans;
    }

    private void inorderSearch(TreeNode root, TreeNode p) {
        if(null == root )
            return ;
        inorderSearch(root.left,p);
        if(flag > 0){
            if(flag == 1){
                ans = root;
            }
            ++flag;
            return ;
        }
        if(p == root){
            ++flag ;
        }
        inorderSearch(root.right,p);
    }
    public static void main(String[] args){
        MinorderSuccessor q = new MinorderSuccessor();
        TreeNode x = new TreeNode(2);
        //x.left = new TreeNode(3);
        x.right = new TreeNode(3);
       // x.left.left = new TreeNode(2);
        //x.left.right = new TreeNode(4);
        //x.left.left.left = new TreeNode(1);
        System.out.println(q.inorderSuccessor(x,x));
    }
}
