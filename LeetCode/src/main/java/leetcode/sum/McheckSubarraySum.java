package leetcode.sum;

import java.util.HashMap;
import java.util.Map;

public class McheckSubarraySum {

    //523. 连续的子数组和
    public boolean checkSubarraySum(int[] nums, int k) {
        if(null == nums || nums.length < 2)
            return false;
        Map<Integer,Integer> map = new HashMap<>(nums.length / 2);
        map.put(0,-1);
        int sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum = (sum + nums[i]) % k;
            if(map.containsKey(sum)){
                int pre = map.get(sum);
                if(i - pre >= 2)
                    return true;
            }else {
                map.put(sum,i);
            }
        }
        return false;
    }
    public static void main(String[] args){
        McheckSubarraySum q = new McheckSubarraySum();
        System.out.println(q.checkSubarraySum(new int[]{
                5,0,0,0
        },3));
    }
}
