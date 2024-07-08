package leetcode.heap;

import java.util.*;

public class MkSmallestPairs {

    class Node{
        int value;
        int x;
        int y;
        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
    //373. 查找和最小的 K 对数字
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(k <= 0 || null == nums1 || null == nums2)
            return new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        for(int i = 0;i < nums1.length;++i){
            for(int j = 0;j < nums2.length;++j){
                int x = nums1[i];
                int y = nums2[j];
                int value = x + y;
                if(pq.size() < k){
                    pq.add(new Node(value,x,y));
                    continue;
                }
                if(pq.peek().value > value){
                    pq.poll();
                    pq.add(new Node(value,x,y));
                }else{
                    break;
                }
            }
        }
        LinkedList<List<Integer>> ans = new LinkedList<>();
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            List<Integer> pair = new ArrayList<>(2);
            pair.add(cur.x);
            pair.add(cur.y);
            ans.addFirst(pair);
        }
        return ans;
    }
    public static void main(String[] args){
        MkSmallestPairs q = new MkSmallestPairs();
        List<List<Integer>> lists = q.kSmallestPairs(new int[]{
                1, 7, 11
        }, new int[]{
                2, 4, 6
        }, 3);
        System.out.println(lists);
    }
}
