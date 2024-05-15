package leetcode.array;

public class MIsChen_sortArray {
    //912. 排序数组
    //快排模板
    public int[] sortArray(int[] nums) {
        if(null == nums || nums.length <= 1)
            return nums;
        quickSort(nums,0,nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if(l < r){
            int p = partition(nums,l,r);
            quickSort(nums,l,p - 1);
            quickSort(nums,p + 1,r);
        }
    }

    // 5 7 9 8 4 6
     // 4 7 9 8 7 6
     // 4 5 9 8 7 6
    private int partition(int[] nums,int l,int r){
        int temp = nums[l];
        while (l < r){
            while (l < r && temp <= nums[r])
                --r;
            if(l < r)
                nums[l] = nums[r];
            while (l < r && temp >= nums[l])
                ++l;
            if(l < r)
                nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }

}
