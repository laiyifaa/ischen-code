package hot_100.hash;


import java.util.HashMap;
import java.util.Map;

public class twoSum {
     public int[] twoSum(int[] nums, int target) {
         if(nums.length<2 || nums.length>1e4){
             return new int[]{};
         }
         Map<Integer,Integer> map = new HashMap(nums.length);
         int ans[] = new int[2];
         for(int i = 0;i<nums.length;i++){
             int temp = target - nums[i];
             if(map.containsKey(temp)){
                 ans[0] = i;
                 ans[1] = map.get(temp);
                 break;
             }
             map.put(nums[i],i);
         }
         return ans;
     }
}



