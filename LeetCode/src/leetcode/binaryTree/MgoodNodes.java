package leetcode.binaryTree;

public class MgoodNodes {
    int cnt ;
    //1448. 统计二叉树中好节点的数目
    public int goodNodes(TreeNode root) {
        if(null == root)
            return 0;
        cnt = 0;
        dfs(root,Integer.MIN_VALUE);
        return cnt;
    }
    private void  dfs(TreeNode root,int val){
        if(null == root)
            return;
        if(root.val < val){
            dfs(root.left,val);
            dfs(root.right,val);
        }
        else {
            ++cnt;
            dfs(root.left,root.val);
            dfs(root.right,root.val);
        }
    }
    public static void main(String[] args){
        MgoodNodes q = new MgoodNodes();
        TreeNode root = TreeNode.create(new Integer[]{
                -1,5,-2,4,4,2,-2,null,null,-4,null,-2,3,null,-2,0,null,-1,null,-3,null,-4,-3,3,null,null,null,null,null,null,null,3,-3
        });
        //TreeNode.show(root);
        System.out.println(q.goodNodes(root));
    }
}
