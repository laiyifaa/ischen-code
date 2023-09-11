package hot_100.list;

public class MdeleteMiddle {
    //2095. 删除链表的中间节点
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
}
