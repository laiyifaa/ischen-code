package leetcode.list;

public class deleteDuplicates {
    //83.删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        while (p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
        return head;
    }
    public static void main(String[] args){
        deleteDuplicates q = new deleteDuplicates();
        ListNode p = new ListNode(1);
        p.next = new ListNode(1);
        p.next.next = new ListNode(2);
        p.next.next.next = new ListNode(3);
        p.next.next.next.next = new ListNode(3);
        System.out.println(q.deleteDuplicates(p));
    }
}
