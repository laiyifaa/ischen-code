package hot_100.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class MbuildTree {
    Map<Integer,Integer> inMap;
    int pId ;
    private TreeNode dfs(int l,int r,int[] preorder ){
        if(l>r)
            return null ;
        int pValue = preorder[pId];
        int iId = inMap.get(pValue);
        TreeNode root = new TreeNode(pValue);
        ++pId;
        root.left = dfs(l,iId-1,preorder);
        root.right = dfs(iId+1,r,preorder);
        return root;
    }
    //105. 从前序与中序遍历序列构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null == preorder || 0 == preorder.length )
            return null;
        if(1 == preorder.length)
            return new TreeNode(preorder[0]);
        inMap = new HashMap<>(preorder.length);
        pId = 0;
        for(int i = 0;i<inorder.length;++i){
            inMap.put(inorder[i],i);
        }
        return dfs(0,preorder.length - 1,preorder);
    }
    public static void main(String[] args){
        MbuildTree q = new MbuildTree();
        TreeNode x = q.buildTree(new int[]{1,2,4,7,5,9,3,6},new int[]{7,4,2,5,9,1,3,6});
        System.out.println(x);
    }
}
