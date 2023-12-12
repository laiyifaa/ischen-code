package leetcode.dp;

public class MwaysToChange {

    //面试题 08.11. 硬币
    //完全背包
    public static int waysToChange(int n) {
        if(n == 0)
            return 0;
        int[] coins = new int[]{1,5,10,25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 0; i < coins.length;++i){
            for(int j = coins[i] ; j <= n;++j){
                dp[j] = dp[j] + dp[j - coins[i]];
                dp[j] %=1000000007;
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(waysToChange(1));
        System.out.println(waysToChange(5));
        System.out.println(waysToChange(10));
    }
}
