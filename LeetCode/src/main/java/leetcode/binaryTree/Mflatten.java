package leetcode.binaryTree;

public class Mflatten {
    private TreeNode head = new TreeNode(0);
    //114. 二叉树展开为链表
    public void flatten(TreeNode root) {
        if(null == root)
            return ;
        addNode(root);
        TreeNode cur = head;
        root = cur.right;
    }
    private void addNode(TreeNode root){
        if(null == root)
            return;
        TreeNode ll = root.left;
        TreeNode rr = root.right;
        head.left = null;
        head.right = root;
        head = root;
        addNode(ll);
        addNode(rr);
    }
    public static void main(String[] args){
        Mflatten q = new Mflatten();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        q.flatten(root);
    }
}
