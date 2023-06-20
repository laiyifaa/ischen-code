package hot_100.list;

public class MIsChen_swapPairs {

    public ListNode swapPairs(ListNode head) {
        if(null == head || null == head.next)
            return head;
        ListNode next = head.next;
        head.next =  swapPairs(next.next);
        next.next =head;
        return next;
    }
}
