package leetcode.dp;

public class findMagicIndex {
    //面试题 08.03. 魔术索引
    public int findMagicIndex(int[] nums) {
        for(int i = 0; i < nums.length;){
            if(i == nums[i])
                return i;
            i = Math.max(i + 1,nums[i]);
        }
        return -1;
    }
}
