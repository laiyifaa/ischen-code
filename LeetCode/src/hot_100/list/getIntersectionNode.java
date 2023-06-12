package hot_100.list;

public class getIntersectionNode {
    private int len (ListNode x){
        int len  = 0;
        while(null != x){
            x = x.next;
            len++;
        }
        return len;
    }
    private ListNode run(ListNode x ,int cnt){
        for(int i = 0;i<cnt;i++){
            x = x.next;
        }
        return x;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = len(headA);
        int lb = len(headB);
        if(la==0||lb==0){
            return null;
        }
        if(la>lb){
            headA = run(headA,la - lb);
        }else {
            headB = run(headB,lb - la);
        }
        while(true){
            if(null == headA || null == headB)
                return null;
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
    }
    public static void main(String[] args){
        ListNode x = new ListNode(8);
        ListNode y = new ListNode(4);
        y.next = new ListNode(1);
        getIntersectionNode q = new getIntersectionNode();
        q.getIntersectionNode(x,y);
    }
}
