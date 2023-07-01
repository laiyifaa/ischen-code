package hot_100.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MrightSideView {

    //199. 二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        if(null == root)
            return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<Integer>ans = new LinkedList<>();
        LinkedList<Integer>cntList = new LinkedList<>();
        while(!queue.isEmpty()){
            int count = queue.size();
            //cntList = new LinkedList<>();
            cntList.clear();
            while (count>0){
                --count;
                TreeNode curNode = queue.poll();
                cntList.add(curNode.val);
                if(null != curNode.left)
                    queue.add(curNode.left);
                if(null!= curNode.right)
                    queue.add(curNode.right);
            }
            ans.add(cntList.getLast());
        }
        return ans;
    }
    public static void main(String[] args){
        MrightSideView q = new MrightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        q.rightSideView(root);
    }
}
