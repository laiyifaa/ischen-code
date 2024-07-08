package leetcode.list;

public class HreverseKGroup {

    private ListNode fun(ListNode head){
        ListNode x = head;
        int cnt  = 0;
        boolean flag = false;
        while (null != x){
            ++cnt;
            if(cnt == ak){
                flag = true;
                break;
            }
            x = x.next;
        }
        ListNode q = null;
        ListNode p = null;
        ListNode r = head;
        if(flag){
            while (null != head && cnt != 0){
                --cnt ;
                p = head.next;
                head.next = q;
                q = head;
                head = p;
            }
        }else return head;
        r.next = fun(head);
        return q;
    }
    private int ak = 0;
    public ListNode reverseKGroup(ListNode head, int k) {
        if(null == head || null == head.next || k == 1)
            return head;
        ak = k;
        return fun(head);
    }
    public static void main(String[] args){
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(3);
        x.next.next.next = new ListNode(4);
        x.next.next.next.next = new ListNode(5);
        HreverseKGroup q = new HreverseKGroup();
        ListNode listNode = q.reverseKGroup(x,3);
        while(null != listNode){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
