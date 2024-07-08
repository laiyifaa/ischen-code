package leetcode.dp.mult_dp;

public class MuniquePaths {
    //62. 不同路径
    public int uniquePaths(int m, int n) {
        if(m > 100 || n > 100)
            return 0;
        if(n < 1 || m < 1)
            return 0;
        int[][] dp = new int[m + 1][ n + 1];
        for(int i = 1;i<=n;++i)
            dp[1][i] = 1;
        for(int i = 1;i<=m;++i)
            dp[i][1] = 1;
        for(int i = 2;i<=m;++i){
            for(int j = 2;j<=n;++j){
                dp[i][j] = dp[i-1][j]+ dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
