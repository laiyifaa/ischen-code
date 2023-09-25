package leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MIsChen_maxScore {
    //2542. 最大子序列的分数
    //碰到k 往堆上想
    //子序列 你不能排序
    //排序后保留原来索引
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Integer[] idx  = new Integer[nums1.length];
        for(int i = 0;i < nums1.length;++i){
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> nums2[j] - nums2[i]);
        long ans = 0l;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum1 = 0l;
        for(int id : idx){
            int x = nums1[id];
            int y = nums2[id];
            while (pq.size() >= k){
                sum1 -= pq.poll();
            }
            pq.add(x);
            sum1 -= x;
            if(pq.size() == k){
                long cur = sum1 * y;
                if( cur > ans)
                    ans = cur;
            }
        }
        return ans;
    }
}
