package leetcode.double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MpairSums {
    //面试题 16.24. 数对和
    public List<List<Integer>> pairSums(int[] nums, int target) {
        if(null == nums || nums.length <= 2)
            return new LinkedList<>();
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        if(nums[l] > target/2)
            return new LinkedList<>();
        List<List<Integer>> ansList = new LinkedList<>();
        while (l < r){
            if(nums[l] + nums[r] == target){
                List<Integer> temp = new ArrayList<>(2);
                temp.add(nums[l]);
                temp.add(nums[r]);
                ansList.add(temp);
                ++l;
                --r;
                continue;
            }
            if(target - nums[r] < nums[l]){
                --r;
            }else{
                ++l;
            }
        }
        return ansList;
    }
}
