package hot_100.child_string;

import java.util.HashMap;
import java.util.Map;

public class MIsChen_subarraySum {

    /*o(n2) o(n)
    public int subarraySum(int[] nums, int k) {
        if(null == nums )
            return 0;
        int[] sums = new int[nums.length];
        int ans = 0;
        for(int i = 0;i < nums.length;i++){
            sums[i] = (i==0?0:sums[i-1]) + nums[i];
            if(sums[i] == k)
                ans++;
        }
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(sums[j] - sums[i] == k)
                    ans++;
            }
        }
        return ans;
    }*/

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        //key = 和 value = 次数
        Map<Integer,Integer> map = new HashMap<>(nums.length/2);
        map.put(0,1);
        int preSum = 0;
        for(int num : nums){
            preSum += num;
            if(map.containsKey(preSum - k)){
                ans += map.get(preSum - k);
            }
            //getOrDefault 存在则返回 不存在则返回0
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }

        return ans;
    }

}
