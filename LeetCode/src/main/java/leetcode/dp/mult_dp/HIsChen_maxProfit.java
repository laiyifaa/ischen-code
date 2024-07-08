package leetcode.dp.mult_dp;

public class HIsChen_maxProfit {
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
/*    public int maxProfit(int[] prices) {
        if(null == prices || 0 == prices.length)
            return 0;
        int ans = 0;
        for(int i = 1;i < prices.length;++i){
            ans += Math.max(0,prices[i] - prices[i - 1]);
        }
        return 0;
    }*/

/*    //123. 买卖股票的最佳时机 III
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length <= 1)
            return 0;
        int cost1 = -prices[0];
        int cost2 = -prices[0];
        int profit1 = 0;
        int profit2 = 0;
        for(int i = 1;i < prices.length; ++i){
            cost1 = Math.max(cost1,-prices[i]);
            profit1 = Math.max(profit1,prices[i]  + cost1);
            cost2 = Math.max(cost2,profit1 - prices[i]);
            profit2 = Math.max(profit2,cost2 + prices[i]);
        }
        return profit2;
    }*/

    //188.买卖股票的最佳时机 IV
    public int maxProfit(int k, int[] prices) {
        if(null == prices || prices.length <= 1)
            return 0;
        k = Math.min(k,prices.length );
        int[] cost = new int[k];
        int[] profit = new int[k];
        for(int i = 0 ;i < k;++i)
            cost[i] = - prices[0];
        for(int i = 1;i < prices.length;++i){
            if(k == 1){
                cost[0] = Math.max(cost[0],-prices[i]);
                profit[0] = Math.max(profit[0],prices[i] + cost[0]);
                continue;
            }
            for(int j = 0;j < k - 1;++j){
                cost[j] = Math.max(cost[j],-prices[i]);
                profit[j] = Math.max(profit[j],prices[i] + cost[j]);
                cost[j + 1] = Math.max(cost[j + 1],profit[j] - prices[i]);
                profit[j + 1] = Math.max(profit[j + 1],cost[j + 1] + prices[i]);
            }
        }
        return profit[k - 1];
    }
    public static void main(String[] args){
        HIsChen_maxProfit q = new HIsChen_maxProfit();
        System.out.println(q.maxProfit(1,new int[]{1,2}));
    }
}
