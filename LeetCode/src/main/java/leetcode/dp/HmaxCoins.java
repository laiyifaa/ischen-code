package leetcode.dp;

import java.util.Arrays;

public class HmaxCoins {

    //312. 戳气球
    //逆反思想
    //记忆化搜索
    int[] val;
    int[][] used;
    public int maxCoins(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        val = new int[nums.length  + 2];
        for (int i = 1; i <= nums.length; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[nums.length + 1] = 1;
        used = new int[val.length][val.length];
        for(int i = 0;i < used.length;++i)
            Arrays.fill(used[i],-1);
        return solve(0,nums.length + 1);
    }

    private int solve(int left, int right) {
        if(left >= right - 1 )
            return 0;
        if(used[left][right] != -1)
            return used[left][right];
        for(int i = left + 1;i < right;++i){
            int sum = val[left] * val[i] * val[right];
            sum += solve(left,i)  + solve(i ,right);
            used[left][right] = Math.max(used[left][right],sum);
        }
        return used[left][right];
    }
}
