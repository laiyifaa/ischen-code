package leetcode.binaryTree;

public class McheckSubTree {
    //面试题 04.10. 检查子树
    //双层DFS
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return false;
        if(t2 == null)
            return true;
        return find(t1,t2) || checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
    }

    private boolean find(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        if(t1.val == t2.val ){
            return find(t1.left,t2.left) && find(t1.right,t2.right);
        }
        return false;
    }


    public static void main(String[] args){
        McheckSubTree q = new McheckSubTree();
        TreeNode x = TreeNode.create(new Integer[]{
                1, 2, 3
        });
        System.out.println(q.checkSubTree(x,x.left));
    }
}
