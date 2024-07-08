package leetcode.list;

public class hasCycle {

    public boolean hasCycle(ListNode head) {
        if(null == head || null == head.next )
            return false;
        ListNode quick = head;
        ListNode slow = head;
        while (true){
            if(slow == null || quick == null)
                return false;

            quick = quick.next;
            if(null != quick)
                quick = quick.next;
            else return false;
            slow = slow.next;
            if(quick == slow)
                return true;
        }
    }
    public static void main(String[] args){  
        hasCycle q = new hasCycle();
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = null;
        System.out.println(q.hasCycle(x));
    }

}
