package leetcode.binaryTree;

import leetcode.list.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class MlistOfDepth {
    //面试题 04.03. 特定深度节点链表
    public ListNode[] listOfDepth(TreeNode tree) {
        if(null == tree)
            return new ListNode[]{};
        Queue<TreeNode> queue = new LinkedList();
        queue.add(tree);
        LinkedList<ListNode> ans = new LinkedList<>();
        while(!queue.isEmpty()){
            int count = queue.size();
            ListNode head = new ListNode(0);
            ListNode q = head;
            while (count>0){
                --count;
                TreeNode curNode = queue.poll();
                ListNode p = new ListNode(curNode.val);
                q.next = p;
                q = p;
                if(null != curNode.left)
                    queue.add(curNode.left);
                if(null!= curNode.right)
                    queue.add(curNode.right);
            }
            ans.addLast(head.next);
        }
        return ans.toArray(new ListNode[ans.size()]);
    }
}
