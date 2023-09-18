package leetcode.array;

public class MincreasingTriplet {
    //334. 递增的三元子序列
    public boolean increasingTriplet(int[] nums) {
        if(null == nums || nums.length < 3)
            return false;
        int l[] = new int[nums.length];
        int r[] = new int[nums.length];
        l[0] = nums[0];
        for(int i = 1;i<nums.length;++i){
            l[i] = Math.min(nums[i],l[i - 1]);
        }
        r [nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length -2;i>=0;--i){
            r[i] = Math.max(nums[i],r[i + 1]);
        }
        for(int i = 1;i<nums.length - 1;++i){
            if(l[i-1] < nums[i] && nums[i] < r[i+1])
                return true;
        }
        return false;
    }
}
