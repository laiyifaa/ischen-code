package leetcode.dp;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MIsChen_getKthMagicNumber {
    //面试题 17.09. 第 k 个数
  /*  public int getKthMagicNumber(int k) {
        if(k == 0 || k < 0)
            return 0;
        if(k == 1)
            return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>(k);
        pq.add(1L);
        set.add(1L);
        long temp = 0;
        for(int i = 1;i <= k;++i){
            long cur = pq.poll();
            temp = cur;
            long curA = cur * 3;
            long curB = cur * 5;
            long curC = cur * 7;
            if( !set.contains(curA) ){
                pq.offer(curA);
                set.add(curA);
            }
            if(  !set.contains(curB)  ){
                pq.offer(curB);
                set.add(curB);
            }
            if(  !set.contains(curC)  ){
                pq.offer(curC);
                set.add(curC);
            }
        }
        return (int)temp;
    }*/
    //面试题 17.09. 第 k 个数
    public int getKthMagicNumber(int k) {
        if(k == 0 || k < 0)
            return 0;
        if(k == 1)
            return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>(k);
        pq.add(1);
        set.add(1);
        Integer temp = 0;
        for(int i = 1;i <= k;++i){
            Integer cur = pq.poll();
            if(cur == 615234375)
                System.out.println(123);
            temp = cur;
            Integer curA = cur * 3;
            Integer curB = cur * 5;
            Integer curC = cur * 7; //Integer * 7 不一定是负数 也可能爆到正数了 因此得用Long
            if(!set.contains(curA) && curA > 0){
                pq.add(curA);
                set.add(curA);
            }
            if(!set.contains(curB) && curB > 0){
                pq.add(curB);
                set.add(curB);
            }
            if(!set.contains(curC) && curC > 0){
                pq.add(curC);
                set.add(curC);
            }
        }
        return temp;
    }

}
