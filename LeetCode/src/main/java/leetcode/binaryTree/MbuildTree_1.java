package leetcode.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class MbuildTree_1 {


    //106. 从中序与后序遍历序列构造二叉树
    int [] in;
    int [] post;
    int postIndex ;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(null == inorder || null == postorder)
            return null;
        if(inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length)
            return null;
        this.in = inorder;
        this.post = postorder;
        postIndex = post.length - 1;
        int idx = 0;
        for(Integer val : in){
            map.put(val,idx++ );
        }
        return dfs(0,inorder.length - 1);
    }

    private TreeNode dfs(int l, int r) {
        if(l > r)
            return null;
        int inIndex = map.get(post[postIndex]);
        TreeNode node = new TreeNode(in[inIndex]);
        postIndex--;
        node.right = dfs(inIndex + 1,r);
        node.left = dfs(l,inIndex - 1);
        return node;
    }
    public static void main(String[] args){
        MbuildTree_1 q = new MbuildTree_1();
        TreeNode treeNode = q.buildTree(new int[]{
                9, 3, 15, 20, 7
        }, new int[]{
                9, 15, 7, 20, 3
        });
        TreeNode.show(treeNode);
    }
}
