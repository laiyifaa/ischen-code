package hot_100.binSearch;

public class MIsChen_search {
    //33. 搜索旋转排序数组
    public int search(int[] nums, int target) {
        return divide(0,nums.length -1,nums,target);
    }
    private int divide(int l,int r,int[] nums,int target){
        if(l>r)
            return -1;
        if(nums[l]<nums[r])
            return binSearch(l,r,nums,target);
        int mid = l + (r - l)/2;
        if(nums[mid] == target)
            return mid;
        return Math.max(divide(l,mid-1,nums,target),divide(mid+1,r,nums,target));
    }
    private int binSearch(int l,int r,int[] nums,int target){
        if(l>r)
            return -1;
        while (l<=r){
            int mid = l + (r - l) /2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
