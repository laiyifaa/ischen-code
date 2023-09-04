package hot_100.dp;

public class Mrob {
    //198. 打家劫舍
    public int rob(int[] nums) {
        if(nums.length > 100 || nums.length < 1)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        int ans = dp[0];
        for(int i = 2; i < nums.length ; ++i){
            dp[i] = Math.max(dp[i-1],dp[i - 2] + nums[i]);
            if(ans < dp[i])
                ans = dp[i];
        }
        return ans;
    }
    public static void main(String[] args){
        Mrob q = new Mrob();
        System.out.println(  q.rob(new int[]{
                1,2,3,1
        }));
    }
}
