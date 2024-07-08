package leetcode.list;

import java.util.HashSet;

public class removeDuplicateNodes {
    //面试题 02.01. 移除重复节点
    public ListNode removeDuplicateNodes(ListNode head) {
        if(null == head || head.next  == null)
            return head;
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        ListNode ans = head;
        ListNode p = ans;
        set.add(cur.val);
        cur = cur.next;
        while (cur != null){
            if(!set.contains(cur.val)){
                p.next = cur;
                p = p.next;
                set.add(cur.val);
            }
            cur = cur.next;
        }
        p.next = null;
        return ans;
    }
    public static void main(String[] args){  
        ListNode q = new ListNode(1);
        q.next = new ListNode(2);
        q.next.next = new ListNode(3);
        q.next.next.next = new ListNode(3);
        q.next.next.next.next = new ListNode(2);
        q.next.next.next.next.next = new ListNode(1);
        removeDuplicateNodes x = new removeDuplicateNodes();
        x.removeDuplicateNodes(q).print();
    }
}
