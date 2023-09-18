package leetcode.list;

public class MIsChen_sortList {

    public ListNode sortList(ListNode head) {
        if(null == head || null == head.next)
            return head;
        ListNode slow = head;
        ListNode quick = head;
        ListNode pre = null;
        while(null != quick && null != quick.next){
            pre = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode rList = sortList(pre.next);
        pre.next = null;
        ListNode lList = sortList(head);
        return mergeTwoLists(lList,rList);
    }
    //merge sorted List
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
}
