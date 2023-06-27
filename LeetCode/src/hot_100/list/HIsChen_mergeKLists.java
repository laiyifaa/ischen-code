package hot_100.list;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HIsChen_mergeKLists {
    //23. 合并 K 个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || 0 == lists.length )
            return null;
        if(1 == lists.length)
            return lists[0];
        Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(int i = 0;i<lists.length;i++){
            if(null != lists[i])
                pq.add(lists[i]);
        }
        ListNode x = new ListNode(0);
        ListNode ans = x;
        while(!pq.isEmpty()){
            ListNode cntNode = pq.poll();
            if(null != cntNode.next)
            pq.add(cntNode.next);
            x.next =cntNode;
            x = cntNode;
        }
        return ans.next;
    }
}
