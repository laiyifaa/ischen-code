package leetcode.dp.mult_dp;

public class MIsChen_maxProfit {
    //714. 买卖股票的最佳时机含手续费
    //0 和 1 代表是否持股
    public int maxProfit(int[] prices, int fee) {
        int[][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -1 * prices[0];
        for(int i = 1;i < prices.length;++i){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    //122. 买卖股票的最佳时机 II
    public int maxProfit(int[] prices) {
        if(null == prices || 0 == prices.length)
            return 0;
        int ans = 0;
        for(int i = 1;i < prices.length;++i){
            ans += Math.max(0,prices[i] - prices[i - 1]);
        }
        return 0;
    }

}
