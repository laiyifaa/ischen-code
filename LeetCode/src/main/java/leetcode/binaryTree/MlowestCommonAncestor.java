package leetcode.binaryTree;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class MlowestCommonAncestor {
    Map<TreeNode,TreeNode> map ;
    //int cnt ;
    private void preSearch(TreeNode parent,TreeNode cur){
  /*      if(2 == cnt)
            return;*/
        if(null != cur){
            map.put(cur,parent);
            preSearch(cur,cur.left);
            preSearch(cur,cur.right);
        }
    }
    //236. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root)
            return null;
        if(null == p || null == q)
            return root;
        map = new LinkedHashMap<>();
/*        cnt = 0;*/
        preSearch(root,root);
        HashSet set = new HashSet(map.size());
        while (true){
            set.add(p);
            if(root == p)
                break;
            TreeNode pp = map.get(p);
            p = pp;
        }
        while (true){
            if(set.contains(q))
                return q;
            set.add(q);
            q = map.get(q);
            if(root == q)
                break;
        }
        return root;
    }
    public static void main(String[] args){  
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
       root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        MlowestCommonAncestor M = new MlowestCommonAncestor();
        TreeNode p = root.left;
        TreeNode q =  root.left.right.right ;
        System.out.println(M.lowestCommonAncestor(root,p,q).val);
    }
}
