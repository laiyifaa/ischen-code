package leetcode.list;

public class isPalindrome {


    //234. 回文链表
    //面试题 02.06. 回文链表
    //快慢指针 + 颠倒
    public boolean isPalindrome(ListNode head) {
        if(null == head || null == head.next)
            return true;
        ListNode quick = head;
        ListNode slow = head;
        //快慢
        while(null != quick && null != quick.next){
            quick = quick.next.next;
            slow = slow.next;
        }
        //逆置
        ListNode  p  = null;
        while(null != slow){
            ListNode temp = slow.next;
            slow.next = p;
            p = slow;
            slow = temp;
        }
        while(null != head  && null != p){
            if(head.val != p.val)
                return false;
            head = head.next;
            p = p.next;
        }
        return true;
    }
    public static void main(String[] args){
        isPalindrome q = new isPalindrome();
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(2);
        x.next.next.next = new ListNode(1);
       // x.next.next.next.next = new ListNode(1);
       System.out.println( q.isPalindrome(x));
    }

}
