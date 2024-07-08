package leetcode.binaryTree;

public class convertBiNode {
    //面试题 17.12. BiNode
    TreeNode head ;
    public TreeNode convertBiNode(TreeNode root) {
        head = new TreeNode();
        TreeNode ans = head;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode root ) {
        if(null == root)
            return;
        inorder(root.left);
        addVal(root);
        inorder(root.right);
    }

    private void addVal(TreeNode root) {
        head.right = root;
        head = head.right;
        head.left = null;
    }
    public static void main(String[] args){
        convertBiNode q = new convertBiNode();
        TreeNode treeNode = TreeNode.create(new Integer[]{
                4, 2, 5, 1, 3, null, 6, 0
        });
        q.convertBiNode(treeNode);
    }
}
