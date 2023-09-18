package leetcode.binSearch;

public class MfindMin {
    //153. 寻找旋转排序数组中的最小值
    public int findMin(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        int l = 0;
        int r = nums.length - 1;
        if(1 == nums.length || (nums[l]<nums[r]))
            return nums[0];
        while(l<=r){
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }else {
                --r;
            }
        }
        return nums[l];
    }
}
