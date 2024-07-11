package leetcode.binaryTree;

public class MisSubStructure {

    //143子结构判断
    boolean flag = false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(null == A && B ==null)
            return true;
        if(B == null)
            return false;
        solve(A,B);
        return flag;
    }

    private void solve(TreeNode a, TreeNode b) {
        if(flag)
            return;
        if(a.val == b.val){
            flag = dfs(a,b);
        }
        if(!flag){
            if(null != a.left){
                solve(a.left,b);
            }
            if(null != a.right){
                solve(a.right,b);
            }
        }
    }
    private boolean dfs(TreeNode a, TreeNode b) {
        if(null == b)
            return true;
        if(null == a )
            return false;
        if(a.val != b.val)
            return false;
        boolean f = dfs(a.left,b.left) && dfs(a.right,b.right);
        return f;
    }
    public static void main(String[] args){  
        MisSubStructure  q = new MisSubStructure();
        TreeNode A = TreeNode.create(new Integer[]{
                4,2,3,4,5,6,7,8,9
        });
        TreeNode B = TreeNode.create(new Integer[]{
                4,8,9
        });
        System.out.println(q.isSubStructure(A,B));
    }
}
