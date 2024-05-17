package leetcode.binSearch;

public class search {

    //二分查找
    //二分模板
    public int search(int[] nums, int target) {
        if(null == nums)
            return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2 ;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
