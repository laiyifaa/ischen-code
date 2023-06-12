package hot_100.list;

public class reverseList {

    public ListNode reverseList(ListNode head) {
        if(null == head)
            return null;
        ListNode p =  null;
        ListNode q = null;
        while(null != head.next){
            p = head.next ;
            head.next = q;
            q = head;
            head = p;
        }
        head.next = q;
        return head;
    }
    public static void main(String[] args){
        ListNode x = new ListNode(1);
        ListNode y = new ListNode(2);
        x.next = y;
        reverseList r = new reverseList();
        x = r.reverseList(x);
        while(null != x){
            System.out.println(x.val);
            x = x.next;
        }
    }

}
