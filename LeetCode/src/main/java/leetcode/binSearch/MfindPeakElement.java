package leetcode.binSearch;

public class MfindPeakElement {
    //162. 寻找峰值
    // 最大值就是峰值 o(n)
    // 或者取随机index 开始爬坡 o(n)
    // 二分查找
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        if(nums[nums.length - 1]>nums[nums.length - 2])
            return nums.length - 1;
        int idx = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
