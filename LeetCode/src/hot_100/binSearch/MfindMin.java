package hot_100.binSearch;

public class MfindMin {
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
    public static void main(String[] args){
        MfindMin q = new MfindMin();
        System.out.println(q.findMin(new int[]{3,4,5,1,2}));
        System.out.println(q.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(q.findMin(new int[]{11,13,15,17}));
    }
}
