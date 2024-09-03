package leetcode.binaryTree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MlevelOrder {
    //102. 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(null == root)
            return new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> cntList  = new LinkedList<>();
        int levelMax = 1;
        int levelCnt = 0;
        int levelK = 0;
        while(!queue.isEmpty()){
            TreeNode cnt = queue.poll();
            cntList.add(cnt.val);
            ++levelCnt;
            if(null != cnt.left){
                ++levelK;
                queue.add(cnt.left);
            }

            if(null != cnt.right){
                ++levelK;
                queue.add(cnt.right);
            }
            if(levelCnt == levelMax){
                ans.add(cntList);
                cntList = new LinkedList<>();
                levelCnt = 0;
                levelMax = levelK;
                levelK = 0;
            }
        }
        //Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args){  
        MlevelOrder q = new MlevelOrder();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> lists = q.levelOrder(root);
        for(List<Integer> l: lists){
            for(Integer x : l){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
