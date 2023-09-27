package leetcode.binSearch;

import java.util.Arrays;

public class MIsChen_minEatingSpeed {
    // 二分答案
    //875. 爱吃香蕉的珂珂
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        if(h == piles.length)
            return piles[h - 1];
        int l = 1;
        int r = piles[piles.length - 1];
        while (l <= r){
            int mid = l + ( r - l) / 2;
            long temp = getTimes(piles,mid);
            if(temp > h){
               l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
    private long getTimes(int[] piles,int k){

        int l = 0;
        int r = piles.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if(piles[mid] > k){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        long ans = l;
        for(int i = l;i < piles.length;++i){
            ans += piles[i]/k;
            if(piles[i] % k != 0)
                ++ans;
        }
        return ans;
    }

}
