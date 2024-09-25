package leetcode.binSearch;

public class HsplitArray {
    //410. 分割数组的最大值
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for(int i = 0;i < nums.length;++i){
            r += nums[i];
            if(nums[i] > l)
                nums[i] = l;
        }
        while (l < r){
            int mid = l + (r - l) / 2;
            if(check(nums,mid,k)){
                r = mid;
            }else {
                l = mid  + 1;
            }
        }
        return l;
    }
    public boolean check(int[] nums,int x,int m){
        int sum = 0;
        int cnt = 1;
        for(int i = 0;i < nums.length;++i){
            if( sum + nums[i] > x){
                ++cnt;
                sum = nums[i];
            }else {
                sum += nums[i];
                ++cnt;
            }
        }
        return cnt <= m;
    }
}
