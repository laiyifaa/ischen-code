package leetcode.skill;

import java.util.LinkedList;
import java.util.List;

public class MfindDuplicates {


    //442. 数组中重复的数据
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                ans.add(x);
            }
        }
        return ans;
    }

    public static void main(String[] args){  
        MfindDuplicates q = new MfindDuplicates();
        System.out.println(q.findDuplicates(new int[]{
                4,3,2,7,8,2,3,1
        }));
    }
}
