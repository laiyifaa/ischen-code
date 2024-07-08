package leetcode.heap;

import java.util.*;

public class MSmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    //2336. 无限集中的最小数字
    public MSmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        for(int i = 1;i<=1000;++i){
            pq.add(i);
        }
    }

    public int popSmallest() {
        Integer top = pq.poll();
        return top;
    }

    public void addBack(int num) {
        if( !pq.contains(num)  ){
            pq.add(num);
        }
    }
    public static void main(String[] args){
        MSmallestInfiniteSet q = new MSmallestInfiniteSet();
        q.addBack(2);
        System.out.println(q.popSmallest());
        System.out.println(q.popSmallest());
        System.out.println(q.popSmallest());
        q.addBack(1);
        System.out.println(q.popSmallest());
        System.out.println(q.popSmallest());
        System.out.println(q.popSmallest());
    }

}
