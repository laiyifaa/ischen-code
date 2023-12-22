package leetcode.sum;

public class McorpFlightBookings {
    //1109. 航班预订统计
    //差分数组
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if(null == bookings || n <= 0 ||bookings.length == 0 || bookings[0].length == 0 )
            return new int[]{};
        int[] diff = new int[n ];
        for(int[] booking : bookings){
            int l = booking[0] - 1;
            int r = booking[1] ;
            int cnt = booking[2];
            diff[l] += cnt;
            if(r >= n)
                continue;
            diff[r] -=cnt;
        }
        int[] ans = new int[n + 1];
        ans[0] = diff[0];
        for(int i = 1;i < n; ++i){
            ans[i] = ans[i - 1] + diff[i];
        }
        return ans;
    }
}
