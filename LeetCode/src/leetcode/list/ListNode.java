package leetcode.list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
        next = null;
    }
    void print(){
        ListNode x = this;
        while (null != x){
            System.out.println(x.val);
            x = x.next;
        }
    }
}

