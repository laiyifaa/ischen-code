package leetcode.heap;

import java.util.*;

public class MSmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    Map<Integer,Boolean> map;
    //2336. 无限集中的最小数字
    public MSmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        map = new HashMap<>();
        for(int i = 1;i<=1000;++i){
            pq.add(i);
            map.put(i,true);
        }
    }

    public int popSmallest() {
        Integer top = pq.poll();
        map.put(top,false);
        return top;
    }

    public void addBack(int num) {
        if( !map.get(num)  ){
            map.put(num,true);
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
