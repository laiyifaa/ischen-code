package leetcode.array;

public class MproductExceptSelf {

    //可以理解左右乘积相乘即 nums[i] = l[i-1]*r[i+1] 需要开空间
    //若先乘左边nums[i]不乘
    //再从右边乘起
  /*  public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }*/
    ///238. 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        if(null  == nums)
            return null;
        int val = 1;
        boolean zflag = false;
        for(int i = 0;i<nums.length;++i){
            if(nums[i] == 0 &&!zflag){
                zflag = true;continue;
            }

            val*=nums[i];
        }
        for(int i = 0;i<nums.length;++i){
            if(nums[i] == 0)
                nums[i] = val;
            else {
                nums[i] = zflag?0:val/nums[i];
            }
        }
        return nums;
    }
    public static void main(String[] args){
        int[]a = new int[]{0,4,0};
        MproductExceptSelf q = new MproductExceptSelf();

    }
}
