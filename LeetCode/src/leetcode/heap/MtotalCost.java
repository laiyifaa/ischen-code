package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MtotalCost {
     class Node {
        int val;
        int index;
        int type;
        Node(int _val,int _index,int _type){
            this.val = _val;
            this.index = _index;
            this.type = _type;
        }

     }
    //2462. 雇佣 K 位工人的总代价
    public long totalCost(int[] costs, int k, int candidates) {
        if(null == costs || costs.length == 0)
            return 0l;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.val == o2.val){
                    return o1.index - o2.index;
                }
                return o1.val - o2.val;
            }
        });
        int l = 0;
        int r = costs.length - 1;
        for(;l <  candidates;++l){
            pq.add(new Node(costs[l],l,1));
        }
        for(;r>costs.length  - candidates - 1 && r >= l ;--r){
            pq.add(new Node(costs[r],r,0));
        }
        long ans = 0l;

        while (k > 0){
            Node curNode = pq.poll();
            --k;
            if(curNode.type == 1 && l<=r){
                pq.add(new Node(costs[l],l++,1));
            }else if(curNode.type == 0 && r>=l){
                pq.add(new Node(costs[r],r--,0));
            }
            ans += curNode.val;
        }
        return ans;
    }
    public static void main(String[] args){
        /*PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.val == o2.val){
                    return o1.index - o2.index;
                }
                return o1.val - o2.val;
            }
        });
        pq.add(new Node(1,3));
        pq.add(new Node(2,3));
        pq.add(new Node(1,4));
        pq.add(new Node(2,4));
        while (!pq.isEmpty()){
            Node poll = pq.poll();
            System.out.println(poll.val + "  " + poll.index);
        }*/
        MtotalCost q = new MtotalCost();
        System.out.println( q.totalCost(new int[]{
                2,2,2,2,2,2,1,4,5,5,5,5,5,2,2,2,2,2,2,2,2,2,2,2,2,2
        },7,3));
    }
}
