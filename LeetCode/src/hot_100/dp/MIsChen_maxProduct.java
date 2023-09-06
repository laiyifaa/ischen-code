package hot_100.dp;

public class MIsChen_maxProduct {
    //152. 乘积最大子数组
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int fmax = nums[0];
        int fmin = nums[0];
        int ans = nums[0];
        for(int i = 1;i < nums.length;++i){
            if(nums[i]>=0){
                fmax = Math.max(nums[i],nums[i] * fmax);
                fmin = Math.min(nums[i],fmin * nums[i]);
            }else{
                Integer x = fmin;
                Integer y = fmax;
                fmax = Math.max(x * nums[i],nums[i]);
                fmin = Math.min(y * nums[i],nums[i]);
            }
            ans = Math.max(ans,fmax);
        }
        return ans;
    }

}
