package leetcode.skill;

import java.util.HashMap;
import java.util.Map;

public class MsingleNumber {


    //137. 只出现一次的数字 II
    public int singleNumber(int[] nums) {
        if(null == nums || nums.length == 0)
            return -1;
        Map<Integer,Integer> map = new HashMap<>(nums.length / 3 + 1);
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }
/*
      位运算
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }*/

}
