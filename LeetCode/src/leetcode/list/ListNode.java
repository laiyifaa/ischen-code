package leetcode.list;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
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

