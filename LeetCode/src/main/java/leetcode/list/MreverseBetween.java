package leetcode.list;

public class MreverseBetween {

    //92. 反转链表 II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(null == head || head.next == null)
            return head;
        if(left >= right)
            return head;
        ListNode pPre = null;
        ListNode p = head;//左开头
        ListNode pre = null;
        ListNode q = head;
        ListNode qNext =null;
        int cnt = 0;
        ListNode cur = head;
        while(cur != null){
            ++cnt;
            if(cnt == left){
                pPre = pre;
                p = cur;
            }
            if(cnt == right){
                q = cur;
                qNext = q.next;
            }
            pre = cur;
            cur = cur.next;
        }
        int len = right - left;
        cnt = 0;
        while (cnt <= len){
            q = p.next;
            p.next = qNext;
            qNext = p;
            p = q;
            ++cnt;
        }
        if(null == pPre){
            return qNext;
        }
        pPre.next = qNext;
        return head;
    }
    public static void main(String[] args){  
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
/*        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);*/
        head.print();
        System.out.println("----------------------");
        MreverseBetween q = new MreverseBetween();
        ListNode listNode = q.reverseBetween(head, 1, 2);
        listNode.print();
    }
}
