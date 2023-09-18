package leetcode.list;

public class MremoveNthFromEnd {
    private int cnt = 0;
    private void go(ListNode head){
        if(null != head.next)
            go(head.next);
        cnt--;
        if(cnt == -1)
            head.next = head.next.next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(null == head ||0 == n)
            return head;
        if(null == head.next && 1 ==n){
            return null;
        }
        cnt = n;
        go(head);
        if(0 == cnt)
            return head.next;
        return head;
    }

    public static void main(String[] args){  
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
/*        x.next = new ListNode(2);
        x.next.next = new ListNode(3);
        x.next.next.next = new ListNode(4);
        x.next.next.next.next = new ListNode(5);*/
        MremoveNthFromEnd q = new MremoveNthFromEnd();
        System.out.println(q.removeNthFromEnd(x,2));
    }
}
