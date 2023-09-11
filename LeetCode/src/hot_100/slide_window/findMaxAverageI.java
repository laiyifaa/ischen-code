package hot_100.slide_window;

public class findMaxAverageI {
    //643. 子数组最大平均数 I
    public double findMaxAverage(int[] nums, int k) {
        if(null == nums || nums.length == 0 || k<=0)
            return 0.0;
        double sum = 0.0;
        for(int i = 0;i < k;++i){
            sum = sum + nums[i];
        }
        double ans = sum;
        for(int i = k;i<nums.length;++i){
            sum -= nums[i-k];
            sum += nums[i];
            if(sum > ans)
                ans = sum;
        }
        return ans/k;
    }
}
