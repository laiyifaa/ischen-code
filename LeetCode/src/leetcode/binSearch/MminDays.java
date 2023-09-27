package leetcode.binSearch;

public class MminDays {
    //1482. 制作 m 束花所需的最少天数
    //二分答案 满足的值 最小 或者最大适用二分答案
    public int minDays(int[] bloomDay, int m, int k) {
        int maxDay = 0;
        int minDay = Integer.MAX_VALUE;
        for(int i = 0;i < bloomDay.length;++i){
            if(bloomDay[i] > maxDay)
                maxDay = bloomDay[i];
            if(bloomDay[i] < minDay)
                minDay = bloomDay[i];
        }
        int l = minDay;
        int r = maxDay;
        while (l<=r){
            int mid = l + (r - l)/2;
            long temp = getFlowers(bloomDay,mid,k);
            if(temp  >= m ){
                r = mid - 1;
            }else l = mid + 1;
        }
        if(l > maxDay)
            return -1;
        return l;
    }
    private long getFlowers(int[] bloomDay,int target,int k){
        long ans = 0;
        int cnt = 0;
        for(int i = 0;i<bloomDay.length;++i){
            if(bloomDay[i] <= target ){
                ++cnt;
            }else {
                cnt = 0;
            }
            if(cnt == k){
                ++ans;
                cnt = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args){  
        MminDays q = new MminDays();
        System.out.println(
                q.minDays(new int[]{
                        1,10,3,10,2
                },3,2)
        );
    }
}
