package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MIsChen_pathSum {
/*    //437. 路径总和 III
    //面试题 04.12. 求和路径
    //双层DFS
    public int pathSum(TreeNode root, int targetSum) {
        if(null == root)
            return 0;
       *//* return dfs(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);*//*
        return dfs(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    private int dfs(TreeNode root,long sum){
        if(null == root)
            return 0;
        int ans = 0;
        if(sum   == root.val)
            ++ans;
        ans += dfs(root.left,sum - root.val);
        ans += dfs(root.right,sum - root.val);
        return ans;
    }*/
    /*private int dfs(TreeNode root,long sum ){
        if(null ==  root)
            return 0;
        int ans = 0;
        if(sum   == root.val)
            ++ans;
         ans  = ans + dfs(root.left,sum - root.val) + dfs(root.right,sum - root.val);
         return ans;
    }*/
/*    public static void main(String[] args){
        TreeNode root = TreeNode.create(
                new Integer[] {10,5,-3,3,2,null,11,3,-2,null,1});
        MIsChen_pathSum q = new MIsChen_pathSum();
       System.out.println( q.pathSum(root,8));
    }*/

    //113. 路径总和 II
    private List<List<Integer>> ansList;
    private List<Integer> tempList ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(null == root)
            return new LinkedList<>();
        ansList = new LinkedList<>();
        tempList = new LinkedList<>();
        dfs(root,targetSum);
        return ansList;
    }

    private void dfs(TreeNode root, int targetSum) {
        if(null != root){
            //叶子节点
            if(root.left == null && root.right == null ){
                //符合路径
                if(root.val == targetSum){

                    List<Integer> insertList = new ArrayList<>(tempList);
                    insertList.add(root.val);
                    ansList.add(insertList);
                    return ;
                }
            }else {
                tempList.add(root.val);
                dfs(root.left,targetSum - root.val);
                dfs(root.right,targetSum - root.val);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main(String[] args){
        TreeNode root = TreeNode.create(new Integer[]{1,2,3});
        MIsChen_pathSum q = new MIsChen_pathSum();
        List<List<Integer>> lists = q.pathSum(root, 5);
        System.out.println(lists);

    }
}
