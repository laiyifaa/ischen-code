package hot_100.dp;

public class McoinChange {
    public int coinChange(int[] coins, int amount) {
        if(null == coins || coins.length == 0 || amount == 0)
            return 0;
        long []dp = new long[amount + 1];
        for(int i = 1;i <= amount; ++i){
            dp[i] = Integer.MAX_VALUE*10000l + 1;
        }
         for(int i = 0;i< coins.length;++i){
               for(int j = coins[i];j<=amount;++j){
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);

            }
        }
        if(dp[amount] == (Integer.MAX_VALUE*10000l + 1)|| dp[amount] < 0)
            return -1;
        return (int)dp[amount];
    }
    public static void main(String[] args){  
        McoinChange q = new McoinChange();
        System.out.println(q.coinChange(
                new int[]{
                   2
                }
                ,3));
    }
}
