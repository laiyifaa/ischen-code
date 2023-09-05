package hot_100.dp;



public class MIsChen_numSquares {
    //279. 完全平方数
    public int numSquares(int n) {
        int ans = 0;
        int v = (int)Math.sqrt(n * 1.0);
        int[]dp = new int[n + 1];
        for(int i = 1;i < n + 1; ++i){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1;i<=v;++i){
            for(int j = i * i; j <= n; ++j){
                dp[j] = Math.min(dp[j - i * i] + 1,dp[j]);
            }
        }
        return dp[n];
    }

}
