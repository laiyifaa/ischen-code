package leetcode.list;

public class MpairSum {
    ListNode p ;
    int ans = -1;
    boolean flag = false;
    //2130. 链表最大孪生和
    //放数组 或者 递归
    public int pairSum(ListNode head) {
        if(null == head || head.next == null)
            return 0;
        p = head;
        flag = false;
        fun(head);
        return ans;
    }
    private  void fun (ListNode q){
        if(q == null){
            return;
        }
        fun(q.next);
        if(flag)
            return;
        ans = Math.max(ans,p.val + q.val);
        if(p.next == q){
            flag = true;
        }
        p = p.next;
    }
}
