package leetcode.binaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MwidthOfBinaryTree {


    Map<TreeNode,Integer> map;
    //662.二叉树最大宽度
    public int widthOfBinaryTree(TreeNode root) {
        if(null == root)
            return 0;
        map = new HashMap<>();
        init(root,0);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int count = queue.size();
            int l = Integer.MAX_VALUE;
            int r = Integer.MIN_VALUE;
            while (count > 0){
                --count;
                TreeNode curNode = queue.pollFirst();
                Integer value = map.get(curNode);
                l = Math.min(value,l);
                r = Math.max(value,r);
                if(null != curNode.left)
                    queue.addLast(curNode.left);
                if(null != curNode.right)
                    queue.addLast(curNode.right);
            }
            ans = Math.max(ans,r - l + 1);
        }
        return ans;
    }

    private void init(TreeNode root,int height) {
        if(null != root.left){
            init(root.left,2 * height + 1);
        }
        if(null != root.right){
            init(root.right, 2 * height + 2);
        }
        map.put(root,height);
    }

    public static void main(String[] args){
        MwidthOfBinaryTree q = new MwidthOfBinaryTree();
        q.widthOfBinaryTree(TreeNode.create(new Integer[]{
                1,3,2,5,null,null,9,6,null,7
        }));
    }
}
