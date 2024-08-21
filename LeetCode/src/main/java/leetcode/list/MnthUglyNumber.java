package leetcode.list;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MnthUglyNumber {
    //264. 丑数 II
    public int nthUglyNumber(int n) {
        if(n == 1)
            return  1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        HashSet<Long> set = new HashSet<>(2 * n);
        set.add(1L);
        int ans = 0;
        int[] factors = {2, 3, 5};
        for(int i = 0;i < n;++i){
            long curr = pq.poll();
            ans = (int)curr;
            for(int factor : factors){
                long next = curr * factor;
                if(set.add(next)){
                    pq.add(next);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        MnthUglyNumber q = new MnthUglyNumber();
        System.out.println(q.nthUglyNumber(1407));
    }
}
