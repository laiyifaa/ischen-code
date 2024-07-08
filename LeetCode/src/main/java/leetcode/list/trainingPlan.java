package leetcode.list;

public class trainingPlan {

    //LCR 140. 训练计划 II
    public ListNode trainingPlan(ListNode head, int cnt) {
        if(null == head || cnt <=0 )
            return head;
        ListNode q = head;
        int index = 0;
        while (index < cnt){
            q = q.next;
            ++index;
        }
        ListNode p = head;
        while (true){
            if(q == null)
                break;
            p = p.next;
            q = q.next;
        }
        return p;
    }
    public static void main(String[] args){  

    }
}
