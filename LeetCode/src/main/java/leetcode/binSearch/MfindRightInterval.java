package leetcode.binSearch;

import java.util.Arrays;
import java.util.Comparator;

public class MfindRightInterval {
    //436.寻找右区间
    public int[] findRightInterval(int[][] intervals) {
        int[][] startIntervals = new int[intervals.length][2];
        for(int i = 0;i < intervals.length;++i){
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, Comparator.comparingInt(o -> o[0]));
        int [] ans = new int[intervals.length];
        for(int i = 0;i < intervals.length;++i){
            int l = 0;
            int r = intervals.length - 1;
            int target = -1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(startIntervals[mid][0] >= intervals[i][1]){
                    target = startIntervals[mid][1];
                    r = mid - 1;
                }else l = mid + 1;
                ans[i] = target;
            }
        }
        return ans;
    }

}
