package hot_100.list;



public class MIsChen_detectCycle {
    // tip1 : 简单map集合
/*
    public ListNode detectCycle(ListNode head) {
        if(null == head ||null == head.next )
            return null;
        Set<ListNode> map = new HashSet<>();
        while( null != head){
            if(map.contains(head)){
                return head;
            }else {
                map.add(head);
            }
            head = head.next;
        }
        return null;
    }*/
    // tip2 : 快慢指针 跑2次快慢指针（代码我留着，题解看懂，但我肯定想不到）
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
