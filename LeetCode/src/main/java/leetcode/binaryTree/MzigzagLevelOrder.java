package leetcode.binaryTree;


import java.util.LinkedList;
import java.util.List;

public class MzigzagLevelOrder {

    //103. 二叉树的锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(null == root)
            return ans;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            int cnt = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for(int i = 0;i < cnt; ++i){
                TreeNode cur = queue.pollFirst();
                if (flag) {
                    levelList.addFirst(cur.val);
                } else {
                    levelList.addLast(cur.val);
                }
                if(null != cur.left)
                    queue.addLast(cur.left);
                if(null != cur.right)
                    queue.addLast(cur.right);
            }
            ans.add(levelList);
            flag = !flag;
        }
        return ans;
    }
    public static void main(String[] args){  
        MzigzagLevelOrder q = new MzigzagLevelOrder();
        TreeNode treeNode = TreeNode.create(new Integer[]{
                3, 9, 20, null, null, 15, 7
        });
        List<List<Integer>> lists = q.zigzagLevelOrder(treeNode);

    }
}
