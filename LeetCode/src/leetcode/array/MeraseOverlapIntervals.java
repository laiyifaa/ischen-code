package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class MeraseOverlapIntervals {
    //435. 无重叠区间
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cnt = 0;
        //int l = intervals[0][0];
        int r = intervals[0][1];
        for(int i = 1;i < intervals.length; ++i){
            if(intervals[i][0] < r){
                ++cnt;
            }else {
                r = intervals[i] [1];
            }

        }
        return cnt;
    }
}
