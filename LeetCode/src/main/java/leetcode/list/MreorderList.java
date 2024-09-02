package leetcode.list;

import java.util.LinkedList;

public class MreorderList {
    //143. 重排链表
    public void reorderList(ListNode head) {
        int len  = getLen(head);
        if(len < 3)
            return;
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode p = head;
        while (p != null){
            queue.addLast(p);
            p = p.next;
        }

        ListNode first = null;
        ListNode next = null;
        ListNode end = null;
        for(int i = 0;i < len / 2;++i){
            first = queue.pollFirst();
            end = queue.pollLast();
            next = first.next;
            first.next = end;
            end.next = next;
        }
        if(queue.isEmpty()){
            end.next = null;
        }else {
            end.next = queue.getLast();
            queue.pollFirst().next = null;
        }
        return ;
    }

    private int getLen(ListNode head) {
        int cnt = 0;
        ListNode p = head;
        while (p != null){
            ++cnt;
            p = p.next;
        }
        return cnt;
    }
    public static void main(String[] args){
        MreorderList q = new MreorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        q.reorderList(head);
        head.print();

    }
}
