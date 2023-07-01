package hot_100.binaryTree;

public class MkthSmallest {
    private int cnt = 0;
    private int ans = -1;
    private int _k = 0;
    private void inorder(TreeNode root){
        if(null == root)
            return;
        if(ans != -1)
            return;
        inorder(root.left);
        cnt++;
        if(cnt == _k){
            ans = root.val;
            return;
        }
        inorder(root.right);

    }
    //230. 二叉搜索树中第K小的元素 中序遍历 找到第K个就结束
    public int kthSmallest(TreeNode root, int k) {
        ans = -1;
        _k = k;
        inorder(root);
        return ans;
    }
}
