package hot_100.greedy;

public class maxProfit {
    //121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0)
            return 0;
        int ans = 0;
        int cnt = prices[0];
        for(int i = 1;i < prices.length;++i){
            int temp = prices[i];
            if(temp > cnt){
                ans = Math.max(ans,temp - cnt);
            }else if(temp < cnt){
                cnt = temp;
            }
        }
        return ans;
    }
}
