package leetcode.array;

public class removeElement {
    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        if(null == nums || nums.length == 0)
            return 0;
        int len = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] != val){
                nums[len] = nums[i];
                ++len;
            }
        }
        return len;
    }
}
