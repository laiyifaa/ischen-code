package leetcode.dp;

public class MlengthOfLIS {
    //300. 最长递增子序列
    public int lengthOfLIS(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int[]dp = new int[nums.length];
        for(int i = 0; i < nums.length ;++i){
            dp[i] = 1;
        }
        for(int i = 0;i < nums.length; ++i){
            for (int j = i + 1;j<nums.length;++j){
                if(nums[j]>nums[i]){
                    dp[j] = Math.max(dp[i] + 1,dp[j]);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i < nums.length; ++i){
            if(ans < dp[i])
                ans = dp[i];
        }
        return ans;
    }
    public static void main(String[] args){
        MlengthOfLIS q = new MlengthOfLIS();
        System.out.println(q.lengthOfLIS(new int[]{
                7,7,7,7,7,7,7
        }));
    }
}
