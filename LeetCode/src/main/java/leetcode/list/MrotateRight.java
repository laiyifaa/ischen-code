package leetcode.list;

public class MrotateRight {
    //61. 旋转链表
    public ListNode rotateRight(ListNode head, int k) {
        if(null == head || head.next == null || k <= 0)
            return head;
        int len = getLen(head);
        k = k % len;
        if(k == 0)
            return head;
        ListNode ans = new ListNode(0);
        ListNode q = head;
        ListNode pre = null;
        for(int i = 0;i < len - k;++i){
            pre = q;
            q = q.next;
        }
        pre.next = null;
        ans.next = q;
        while (q.next != null)
            q = q.next;
        q.next = head;
        return ans.next;
    }

    private int getLen(ListNode head) {
        int cnt = 0;
        ListNode q =  head;
        while (q != null){
            ++cnt;
            q = q.next;
        }
        return cnt;
    }
    public static void main(String[] args){
        MrotateRight q = new MrotateRight();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
/*        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*/
        q.rotateRight(head,1).print();
    }
}
