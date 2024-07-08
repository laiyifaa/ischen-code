package leetcode.list;

public class Mpartition {
    //面试题 02.04. 分割链表
    //86. 分隔链表
    public ListNode partition(ListNode head, int x) {
        if(null == head || head.next == null)
            return head;
        ListNode lower = new ListNode(0);
        ListNode l = lower;
        ListNode higher = new ListNode(0);
        ListNode h = higher;
        ListNode cur = head;
        while (cur != null){
            if(cur.val < x){
                l.next = cur;
                l = l.next;
            }else {
                h.next = cur;
                h = h.next;
            }
            cur = cur.next;
        }
        h.next = null;
        l.next = higher.next;
        return lower.next;
    }
    public static void main(String[] args){
        Mpartition q = new Mpartition();
        ListNode p = new ListNode(1);
        p.next = new ListNode(4);
        p.next.next = new ListNode(3);
        p.next.next.next = new ListNode(2);
        p.next.next.next.next = new ListNode(5);
        p.next.next.next.next.next = new ListNode(2);
        q.partition(p,3).print();
    }
}
