package leetcode.sum;

public class pivotIndex {
    //724. 寻找数组的中心下标
    public int pivotIndex(int[] nums) {
        if(null  == nums || nums.length <= 1)
            return -1;
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for(int i = 1;i < nums.length;++i){
            f[i] = f[i - 1] + nums[i];
        }
        if(f[0] == f[nums.length - 1])
            return 0;
        for(int i = 1;i<nums.length;++i){
            if(f[i-1] == f[nums.length - 1] - f[i])
                return i;
        }
        return -1;
    }
}
