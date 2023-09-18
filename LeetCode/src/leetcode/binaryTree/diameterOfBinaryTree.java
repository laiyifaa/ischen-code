package leetcode.binaryTree;

public class diameterOfBinaryTree {
    private  int ans = 0;
    //543. 二叉树的直径
    public int diameterOfBinaryTree(TreeNode root) {
        if(null == root)
            return 0;
        ans = 0;
        int l1 = maxDepth(root.left);
        int r1 = maxDepth(root.right);
        if(l1 + r1 > ans)
            ans = l1 + r1;
         return ans;
    }
    //104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(null == root)
            return 0;
        int hl = maxDepth(root.left) ;
        int hr = maxDepth(root.right) ;
        if(hl + hr  > ans){
            ans = hl + hr ;
        }
        return hl>hr?hl+1:hr+1;
    }
    public static void main(String[] args){
        diameterOfBinaryTree q = new diameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(q.diameterOfBinaryTree(root));

    }
}
