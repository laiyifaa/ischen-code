package leetcode.array;


import java.util.Comparator;

import java.util.PriorityQueue;

public class MsmallestDifference {
    class node{
        int val;
        int type;
        node(){

        }
        node(int _val,int _type){
            this.val = _val;
            this.type = _type;
        }
    }
    //面试题 16.06. 最小差
    public int smallestDifference(int[] a, int[] b) {
        PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0; i < a.length;++i){
            pq.add(new node(a[i],0));

        }
        for(int i = 0; i < b.length;++i){
            pq.add(new node(b[i],1));

        }
        long ans = Integer.MAX_VALUE;
        node cur = pq.poll();
        while (!pq.isEmpty()){
            node temp = pq.poll();
            if(cur.type != temp.type){
                long res = Math.abs(cur.val - temp.val);
                if(res < ans )
                    ans = res;
            }
            cur = temp;
        }
        return (int)ans;
    }
    public static void main(String[] args){
        MsmallestDifference q = new MsmallestDifference();
        System.out.println( q.smallestDifference(new int[]{
                1,2,11,15
        },new int[]{
                4,12,19,23,127,11
        }));
    }

}
