package leetcode.dp;

import java.util.Arrays;

public class MIsChen_bestSeqAtIndex {
    //面试题 17.08. 马戏团人塔
    class people {
        public int h ;
        public int w ;
        public people() {
             h = 0;
             w = 0;
        }
        public people(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
    public int bestSeqAtIndex(int[] height, int[] weight) {
        if(null == height || weight == null)
            return 0;
        if(height.length != weight.length)
            return 0;
        int n = height.length;
        //存储height 和 weight
        people[] peoples = new people[n];
        for(int i = 0;i < n;++i){
            people p = new people(height[i],weight[i]);
            peoples[i] = p;
        }
        Arrays.sort(peoples, (o1, o2) -> {
            if(o1.h == o2.h)
                return o2.w - o1.w;
            return o1.h - o2.h;
        });
        //优化LIS的 辅助二分数组
        people[] temp = new people[n];
        //辅助数组长度
        int len = 0;
        for(int i = 0;i < n; ++i){
           int index = find(temp,peoples[i],len);
           if(index <= len && index >=0 )
           temp[index] = peoples[i];
           if(index == len)
               ++len;
        }
        /*for(int i = 0;i < n;++i){
           for(int j = i + 1;j < n;++j){
               if(peoples[j].h > peoples[i].h && peoples[j].w > peoples[i].w){
                   dp[j] = Math.max(dp[i] + 1,dp[j]);
               }
           }
        }
        int ans = 0;
        for(int i = 0;i < n; ++i){
            if(ans < dp[i])
                ans = dp[i];
        }*/
        return len ;
    }

    private int find(people[] temp, people p, int len) {
        int l = 0;
        int r = len - 1 ;
        while (l <= r){
            int mid = l + (r - l) / 2;
            people q = temp[mid];
            if(q.w > p.w ){
                r = mid - 1;
            }else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args){
        MIsChen_bestSeqAtIndex q = new MIsChen_bestSeqAtIndex();
        System.out.println(
                q.bestSeqAtIndex(new int[]{
                        2868,5485,1356,1306,6017,8941,7535,4941,6331,6181
                },new int[]{
                        5042,3995,7985,1651,5991,7036,9391,428,7561,8594
                })
        );
 /*       [1, 2, 2, 2, 3]
[4, 5, 6, 7, 8]*/
    }
}
