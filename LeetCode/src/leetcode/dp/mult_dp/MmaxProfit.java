package leetcode.dp.mult_dp;

public class MmaxProfit {
    //714. 买卖股票的最佳时机含手续费
    public int maxProfit(int[] prices, int fee) {

        return 0;
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
