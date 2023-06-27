package hot_100.list;

public class MaddTwoNumbers {
    private int getSum(ListNode l1,ListNode l2){
        return l1.val+l2.val;
    }
    private int getSum(ListNode l1){
        return l1.val;
    }

    //2. 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s = 0;
        ListNode y = new ListNode(0);
        ListNode ans = y;
        while(null != l1 && null != l2){
            int c = getSum(l1,l2) + s;
            if( c >= 10){
                s = 1;c%=10;
            }
            else s = 0;
            ListNode z = new ListNode(c);
            y.next = z;
            y = z;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (null != l1){
            int c = getSum(l1) + s;
            if(c >= 10){
                s = 1;c%=10;
            }else s = 0;
            ListNode z = new ListNode(c);
            y.next = z;
            y = z;
            l1 = l1.next;
        }
        while(null != l2){
            int c = getSum(l2) + s;
            if(c >= 10){
                s = 1;c%=10;
            }else s = 0;
            ListNode z = new ListNode(c);
            y.next = z;
            y = z;
            l2 = l2.next;
        }
        if(s == 1){
            ListNode z = new ListNode(s);
            y.next = z;
        }
        return ans.next;
    }
    public static void main(String[] args){
        ListNode x = new ListNode(9);
        ListNode y = new ListNode(2);
        MaddTwoNumbers q = new MaddTwoNumbers();
        ListNode listNode = q.addTwoNumbers(x, y);
        listNode.print();
    }
}
