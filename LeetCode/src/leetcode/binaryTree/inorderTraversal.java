package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class inorderTraversal {

    private void inorderSearch(TreeNode root,List list){
        if(null != root){
            inorderSearch(root.left,list);
            list.add(root.val);
            inorderSearch(root.right,list);
        }
    }
    //94. 二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List list = new LinkedList();
        inorderSearch(root,list);
        return list;
    }
}
