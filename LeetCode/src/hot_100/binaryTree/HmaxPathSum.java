package hot_100.binaryTree;


public class HmaxPathSum {
    int ans = Integer.MIN_VALUE;
    //124
    public int maxPathSum(TreeNode root) {
        if(null == root)
            return 0;
       int temp =  dfs(root);
        return temp>ans?temp:ans;
    }
    private int dfs(TreeNode root){
        if(null == root)
            return -1001;
        int lMax = dfs(root.left);
        int rMax = dfs(root.right);
        int MLMax = root.val + lMax;
        int MRMax = root.val + rMax;
        int LMRMax  = MLMax + rMax;
        ans = Math.max(ans,Math.max(LMRMax,Math.max(lMax,rMax)));
/*        ans = Math.max(ans,root.val);*/
        return Math.max(root.val,Math.max(MLMax,MRMax));
    }
    public static void main(String[] args){
        TreeNode root = TreeNode.create(new Integer[]{1,2,3});
        HmaxPathSum q = new HmaxPathSum();
        System.out.println(q.maxPathSum(root));
        root = TreeNode.create(new Integer[]{-10,9,20,null,null,15,7});
        System.out.println(q.maxPathSum(root));
    }
}
