package leetcode.binaryTree;

public class MIsChen_pathSum {
    //437. 路径总和 III
    //面试题 04.12. 求和路径
    //双层DFS
    public int pathSum(TreeNode root, int targetSum) {
        if(null == root)
            return 0;
       /* return dfs(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);*/
        return dfs(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    private int dfs(TreeNode root,long sum){
        if(null == root)
            return 0;
        int ans = 0;
        if(sum   == root.val)
            ++ans;
        ans += dfs(root.left,sum - root.val);
        ans += dfs(root.right,sum - root.val);
        return ans;
    }
    /*private int dfs(TreeNode root,long sum ){
        if(null ==  root)
            return 0;
        int ans = 0;
        if(sum   == root.val)
            ++ans;
         ans  = ans + dfs(root.left,sum - root.val) + dfs(root.right,sum - root.val);
         return ans;
    }*/
    public static void main(String[] args){
        TreeNode root = TreeNode.create(
                new Integer[] {10,5,-3,3,2,null,11,3,-2,null,1});
        MIsChen_pathSum q = new MIsChen_pathSum();
       System.out.println( q.pathSum(root,8));
    }
}
