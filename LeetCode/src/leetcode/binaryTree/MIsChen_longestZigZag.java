package leetcode.binaryTree;

public class MIsChen_longestZigZag {
    //1372. 二叉树中的最长交错路径
    private  int ans = -1;
    public int longestZigZag(TreeNode root) {
        if(null == root)
            return 0;
        step(root,0,true);
        step(root,0,false);
        return ans;
    }
    private void step(TreeNode root,int step,boolean dir){
        if(step - 1 > ans)
            ans = step - 1;
        if(null == root)
            return ;
        if(dir){
            step(root.left,step + 1,false);
            step(root.right,1,true);
        }else {
            step(root.right,step + 1,true);
            step(root.left,1,false);
        }
    }
    public static void main(String[] args){
        MIsChen_longestZigZag q = new MIsChen_longestZigZag();
        System.out.println(
                q.longestZigZag(TreeNode.create(new Integer[]{
                        1,null,1,1,1,null,null,1,1,null,1,null,null,null,1
                }))
        );
    }
}
