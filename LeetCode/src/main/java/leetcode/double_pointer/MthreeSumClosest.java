package leetcode.double_pointer;


import java.util.Arrays;


public class MthreeSumClosest {


    //16. 最接近的三数之和
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        int absMIN = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length-2;i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(i<j && j <k ){
                int temp = nums[i] + nums[j] + nums[k];
                int newAbs  = Math.abs(target - temp);
                if( newAbs < absMIN){
                    ans = temp;
                    absMIN = newAbs;
                }
                if (temp == target){
                    return target;
                }
                else if(temp < target ){
                    j++;
                }else k--;

            }
        }
        return ans;
    }
}
