package leetcode.skill;

public class IsChen_missingNumber {
    //面试题 17.04. 消失的数字
    //暴力 哈希 高斯求和
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }
}
