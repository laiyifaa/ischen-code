package leetcode.skill;

public class singleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }
}
