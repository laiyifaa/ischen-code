package leetcode.dp;

public class HcalculateMinimumHP {


    //174 地下城游戏
    public int calculateMinimumHP(int[][] dungeon) {
        if(null == dungeon || dungeon.length == 0)
            return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        if (dungeon[m-1][n-1] >= 0) dp[m-1][n-1] = 1;
        else dp[m-1][n-1] = 1 - dungeon[m-1][n-1];
        for(int i = m - 2 ;i >= 0;--i){
            dp[i][n - 1] = cal(dp[i + 1][n - 1],dungeon[i][n - 1]);
        }
        for(int i = n - 2;i >= 0;--i){
            dp[m - 1][i] = cal(dp[m - 1][i + 1],dungeon[m - 1][i]);
        }
        for(int i = m - 2;i>=0;--i){
            for(int j = n - 2;j>=0;--j){
                dp[i][j] = Math.min(cal(dp[i + 1][j],dungeon[i][j]),cal(dp[i][j + 1],dungeon[i][j]));
            }
        }
        return dp[0][0] > 0?dp[0][0]:1;
    }

    private int cal(int a, int b) {
        if(a <= 0 && b < 0)
            return 1 - b;
        return a - b;
    }
}
