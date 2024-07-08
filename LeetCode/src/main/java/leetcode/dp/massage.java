package leetcode.dp;

public class massage {
    //面试题 17.16. 按摩师
    public int massage(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int ans = dp[1];
        for(int i = 1;i < nums.length;++i){
            dp[i + 1] = Math.max(dp[i - 1] + nums[i],dp[i]);
            ans = Math.max(ans,dp[i + 1]);
        }
        return ans;
    }
    public static void main(String[] args){  
        massage q = new massage();
        System.out.println(
                q.massage(new int[]{
                        2,1,4,5,3,1,1,3
                })
        );
    }
}
