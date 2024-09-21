package leetcode.dp;

public class MstoneGame {

    //877. 石子游戏
    //区间dp
    public boolean stoneGame(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0 ;i < nums.length; ++i){
            dp[i][i] = nums[i];
        }
        for(int len = 1; len < nums.length; ++ len){
            for(int i = 0; i + len < nums.length;++i){
                dp[i][i + len] = Math.max(nums[i] - dp[i + 1][i + len],nums[i + len] - dp[i][i + len - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
