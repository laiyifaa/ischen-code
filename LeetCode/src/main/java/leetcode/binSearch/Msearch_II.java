package leetcode.binSearch;

public class Msearch_II {

    //81. 搜索旋转排序数组 II
    public boolean search(int[] nums, int target) {
        return divide(0,nums.length -1,nums,target);
    }
    private boolean divide(int l,int r,int[] nums,int target){
        if(l>r)
            return false;
        if(nums[l] < nums[r])
            return binSearch(l,r,nums,target);
        int mid = l + ( r - l) / 2;
        if(nums[mid] == target){
           return true;
        }
        boolean left = divide(l, mid - 1, nums, target);
        boolean right = divide(mid + 1,r,nums,target);
        return left | right;
    }
    private boolean binSearch(int l,int r,int[] nums,int target){
        if(l>r)
            return false;
        while (l<=r){
            int mid = l + ( r - l) / 2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return false;
    }
}
