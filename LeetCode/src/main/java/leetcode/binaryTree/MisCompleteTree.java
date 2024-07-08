package leetcode.binaryTree;

import java.util.LinkedList;

public class MisCompleteTree {



    //958. 二叉树的完全性检验
    public boolean isCompleteTree(TreeNode root) {
        if(null == root)
            return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int curH = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int num = 0;
            boolean flag = false;
            for(int i = 0;i < size;++i){
                ++num;
                TreeNode curNode = queue.pollFirst();
                if(curNode.left == null && curNode.right != null)
                    return false;

                if(null != curNode.left){
                    if(flag)
                        return false;
                    queue.addLast(curNode.left);
                }
                if(null != curNode.right){
                    if(flag)
                        return false;
                    queue.addLast(curNode.right);
                }
                if(curNode.left != null && curNode.right == null){
                    flag = true;
                }
                if(curNode.left == null && curNode.right == null){
                    flag = true;
                }
            }
            if (!queue.isEmpty() && num != 1 << curH)
                return false;
            ++curH;
        }
        return true;
    }
    public static void main(String[] args){  
        MisCompleteTree q = new MisCompleteTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        System.out.println(q.isCompleteTree(root));
    }
}
