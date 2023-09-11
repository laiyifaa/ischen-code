package hot_100.list;

public class MdeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        if(null == head || null == head.next)
            return null;
        ListNode quick = head;
        ListNode slow = head;
        ListNode pre  = null;
        while (null != quick.next){
            pre = slow;
            slow = slow.next;
            quick = quick.next;
            if(null != quick.next)
                quick = quick.next;
        }
        pre.next = slow.next;
        return head;
    }
    public static void main(String[] args){  
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        MdeleteMiddle q = new MdeleteMiddle();
        head = q.deleteMiddle(head);
        head.print();
    }
}
