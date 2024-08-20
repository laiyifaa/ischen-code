package leetcode.array;

import java.util.Arrays;

public class MfindSmallestInteger {
    //2598. 执行操作后的最大 MEX
    //同余
    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value];
        for(int i = 0;i < nums.length ; ++i){
            int x = nums[i];
            int t  = (x % value + value) % value ;
            int y = value * cnt[t]++ + t;
            nums[i] = y;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;++i){
            if(i != nums[i])
                return i;
        }
        return nums.length;
    }
}
