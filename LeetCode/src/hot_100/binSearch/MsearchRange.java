package hot_100.binSearch;

public class MsearchRange {
    private int binSearch(int [] nums,int target){
        int l = 0;
        int r = nums.length - 1;
        while (l<=r){
            int mid = l + (r - l) / 2;
            if(nums[mid ] == target)
                return mid;
            else if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        if(l<0)
            return 0;
        if(l>=nums.length)
            return nums.length-1;
        return l;
    }
    //34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if(null == nums || 0 == nums.length)
            return ans;
        int index = binSearch(nums,target - 1);
        while (index<nums.length-1&&nums[index]<target)
            ++index;
        ans[0] = nums[index]!=target?-1:index;
        index = binSearch(nums,target + 1);
        while (index>0&&nums[index]>target)
            --index;
        ans[1] = nums[index]!=target?-1:index;
        return ans;
    }
    public static void main(String[] args){  
        int[] a = new int[]{6,8,8,8,8,8,8,8,8,11};
        MsearchRange q = new MsearchRange();
        q.searchRange(new int[]{1},0);
    }
}
