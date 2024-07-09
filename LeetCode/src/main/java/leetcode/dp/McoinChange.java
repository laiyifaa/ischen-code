package leetcode.dp;

public class McoinChange {
    //322. 零钱兑换
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

    //518.零钱兑换II
    //完全背包
    public int change(int amount, int[] coins) {
        if(null == coins || coins.length == 0 )
            return 0;
        int []dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0;i<coins.length;++i){
            for(int j = coins[i];j<=amount;++j){
                   dp[j] =  dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){  
        McoinChange q = new McoinChange();
        System.out.println(q.change(
                0
                ,new int[]{
                       7
                }));
    }
}
