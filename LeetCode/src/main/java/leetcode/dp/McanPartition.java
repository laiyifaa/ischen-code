package leetcode.dp;

public class McanPartition {
    //416. 分割等和子集
    public boolean canPartition(int[] nums) {
        if(null == nums || nums.length == 0 || nums.length == 1)
            return false;
        int sum = 0;
        for(int i = 0;i < nums.length; ++i){
            sum +=nums[i];
        }
        if((sum&1) == 1)
            return false;
        sum >>= 1;
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for(int i = 0;i < nums.length;++i){
            for(int j = sum;j >= nums[i];--j){
                dp[j] = Math.max(dp[j],dp[j - nums[i]]);
                //dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[sum] == 1 ? true : false;
    }
    public static void main(String[] args){  
        McanPartition q = new McanPartition();
        System.out.println(q.canPartition(new int[]{
            1,2,3,5
        }));
    }
}
