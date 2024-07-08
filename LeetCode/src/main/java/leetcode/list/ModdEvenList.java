package leetcode.list;

public class ModdEvenList {
    ListNode odds ;
    ListNode evens;
    //328. 奇偶链表
    public ListNode oddEvenList(ListNode head) {
        if(null == head || head.next == null || head.next.next == null)
            return head;
        odds = new ListNode(0);
        evens = new ListNode(0);
        fun(odds,evens,head,1);
        return odds.next;
    }
    private void fun(ListNode x,ListNode y,ListNode p ,int k){
        if(p == null){
            y.next = null;
            x.next = evens.next;
            return;
        }
        if((k&1) == 1){
            x.next = p;
            fun(x.next,y,p.next,k+1);
        }else {
            y.next = p;
            fun(x,y.next,p.next,k+1);
        }
    }
    public static void main(String[] args){
        ModdEvenList q = new ModdEvenList();
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(3);
        x.next.next.next = new ListNode(4);
        x.next.next.next.next = new ListNode(5);
        ListNode listNode = q.oddEvenList(x);
        listNode.print();
    }
}
