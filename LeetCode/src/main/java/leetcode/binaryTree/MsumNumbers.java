package leetcode.binaryTree;

public class MsumNumbers {

    //129. 求根节点到叶节点数字之和
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        if(null == root)
            return 0;
        dfs(root,0);
        return ans;
    }

    private void dfs(TreeNode root,int temp) {
        if(null == root.left && null == root.right){
            ans+=temp * 10 + root.val;
            return;
        }
        if(null != root.left){
            dfs(root.left,temp * 10 + root.val);
        }
        if(null != root.right){
            dfs(root.right,temp * 10 + root.val);
        }

    }
}
