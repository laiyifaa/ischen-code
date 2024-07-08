package leetcode.list;

public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(null == list1)
            return list2;
        if(null == list2)
            return list1;
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        while (null != list1 && null !=list2){
            if(list1.val < list2.val){
                cur.next  = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(null == list1){
            cur.next = list2;
        }else {
            cur.next = list1;
        }
        return  l3.next;
    }
    public static void main(String[] args){
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(4);
        ListNode y = new ListNode(1);
        y.next = new ListNode(3);
        y.next.next = new ListNode(4);
        mergeTwoLists q = new mergeTwoLists();
        System.out.println(q.mergeTwoLists(x,y));
    }
}
