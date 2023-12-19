package leetcode.array;

import java.util.Arrays;
import java.util.List;

public class MwiggleSort {
    //面试题 10.11. 峰与谷
    public void wiggleSort(int[] nums) {
        if(null == nums || nums.length <= 1)
            return;
        Arrays.sort(nums);
        int l = nums.length - 1;
        int r = 0;
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length;++i){
            if((i&1) == 1){
                temp[i] = nums[r++];
            }else {
                temp[i] = nums[l--];
            }
        }
        for(int i = 0; i < nums.length;++i){
            nums[i] = temp[i];
        }
    }
}
