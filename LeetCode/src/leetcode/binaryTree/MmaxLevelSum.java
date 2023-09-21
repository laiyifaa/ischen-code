package leetcode.binaryTree;

import java.util.LinkedList;

public class MmaxLevelSum {
    //1161. 最大层内元素和
    public int maxLevelSum(TreeNode root) {
        if(null == root)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        int ansLevel = 0;
        queue.addLast(root);
        int cnt = 0;
        while (!queue.isEmpty()){
            ++cnt;
            int count = queue.size();
            int temp = 0;
            while (count>0){
                --count;
                TreeNode curNode = queue.pollFirst();
                temp+=curNode.val;
                if(null != curNode.left)
                    queue.addLast(curNode.left);
                if(null != curNode.right)
                    queue.addLast(curNode.right);
            }
            if(temp > ans){
                ans = temp;
                ansLevel = cnt;
            }
        }
        return ansLevel;
    }
    public static void main(String[] args){
        MmaxLevelSum q = new MmaxLevelSum();
        System.out.println(
                q.maxLevelSum(TreeNode.create(new Integer[]{
                        -100,-200,-300,-20,-5,-10,null
                }))
        );
    }
}
