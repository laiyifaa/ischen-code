package leetcode.list;

public class MdeleteDuplicates {

    //82. 删除排序链表中的重复元素 II
    public ListNode deleteDuplicates(ListNode head) {
        if(null == head || head.next == null)
            return head;
        int[] used = new int[205];
        ListNode p = head;
        while (p != null){
            ++used[p.val + 100];
            p = p.next;
        }
        p = head;
        ListNode pre = new ListNode(0);
        ListNode ans = pre;
        pre.next = head;
        while (p != null){
            if(used[p.val + 100] == 1){
                pre = p;
                p = p.next;
                continue;
            } else {
                ListNode q = p;
                int cnt = used[p.val + 100];
                for(int i = 0;i < cnt;++i){
                    q = q.next;
                }
                pre.next = q;
                p = q;
            }
        }
        return ans.next;
    }
    public static void main(String[] args){
        MdeleteDuplicates q  = new MdeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next.next = new ListNode(5);
        ListNode listNode = q.deleteDuplicates(head);
        listNode.print();
    }
}
