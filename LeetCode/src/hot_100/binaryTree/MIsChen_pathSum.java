package hot_100.binaryTree;

public class MIsChen_pathSum {
    //437. 路径总和 III
    public int pathSum(TreeNode root, int targetSum) {
        if(null == root)
            return 0;
        return dfs(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    private int dfs(TreeNode root,long sum ){
        if(null ==  root)
            return 0;
        int ans = 0;
        if(sum   == root.val)
            ++ans;
         ans  = ans + dfs(root.left,sum - root.val) + dfs(root.right,sum - root.val);
         return ans;
    }
}
