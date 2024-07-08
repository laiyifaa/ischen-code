package leetcode.skill;

public class IsChen_majorityElement {
    //169. 多数元素
    //面试题 17.10. 主要元素
    //摩尔投票
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int num = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(num==nums[i]){
                cnt++;
            }
            else {
                cnt--;
            }
            if(cnt<0){
                num = nums[i];
                cnt = 1;
            }
        }
        cnt = 0;
        for(int x : nums){
            if(x == num)
                ++cnt;
        }
        return cnt * 2 > nums.length?num:-1;
    }

}
