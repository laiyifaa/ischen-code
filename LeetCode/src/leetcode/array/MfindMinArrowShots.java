package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class MfindMinArrowShots {
    //452. 用最少数量的箭引爆气球
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int l = points[0][0];
        int r = points[0][1];
        int cnt = 1;
        for(int i = 1;i < points.length; ++i){
            if(points[i][0] <= r &&r <= points[i][1]){
                l = Math.max(l,points[i][0]);
            }else {
                ++cnt;
                l = points[i][0];
                r = points[i][1];
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        MfindMinArrowShots q = new MfindMinArrowShots();
        System.out.println(
                q.findMinArrowShots(new int[][]{

                })
        );
    }
}
