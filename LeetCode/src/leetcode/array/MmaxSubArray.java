package leetcode.array;

public class MmaxSubArray {

    public int maxSubArray(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(dp[i-1]<0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1]+nums[i];
            }
        }
        int res = dp[0];
        for(int i = 1;i<nums.length;i++){
            if(res<dp[i])
                res = dp[i];
        }
        return res;
    }
    /*public int maxSubArray(int[] nums) {
        if(null == nums || 0 == nums.length)
            return  0;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum = sum + nums[i];
            if(sum > ans)
                ans = sum;
            if(sum < 0){
                sum = 0;
            }
        }
        return ans;
    }*/
    public static void main(String[] args){
        MmaxSubArray  q = new MmaxSubArray();
        System.out.println(q.maxSubArray(new int[]{
     -2,1
        }));
    }
}
