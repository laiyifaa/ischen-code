package leetcode.array;

public class MIsChen_maxSubarraySumCircular {

    //918. 环形子数组的最大和
    //其实就2个情况：第一个情况子数组没有跨过边界 这个情况简单 参考 maxSubArray,求出maxS
    //第2个情况 子数组越过了边界，那么求他的剩余部分和minS最小即可，然后总和-minS = 子数组跨过边界的最大和
    //子数组跨过边界即头尾相连
    public int maxSubarraySumCircular(int[] nums) {
        if(null == nums || 0 == nums.length)
            return  0;
        int maxS = Integer.MIN_VALUE; // 最大子数组和，不能为空
        int minS = Integer.MAX_VALUE; // 最小子数组和，可以为空
        int allSum = 0;
        int sum = 0;
        for(int x : nums){
            sum += x;
            allSum += x;
            if(sum > maxS)
                maxS = sum;
            if(sum < 0){
                sum = 0;
            }
        }
        sum = 0;
        for(int x : nums){
            sum += x;
            if(sum < minS){
                minS = sum;
            }
            if(sum > 0){
                sum = 0;
            }
        }
        if(minS == allSum)
            return maxS;
        return  Math.max(maxS,allSum - minS);
    }
    public static void main(String[] args){  
        MIsChen_maxSubarraySumCircular q = new MIsChen_maxSubarraySumCircular();
        int i = q.maxSubarraySumCircular(new int[]{
                -3,-2,-3
        });
        System.out.println(i);
    }

}
