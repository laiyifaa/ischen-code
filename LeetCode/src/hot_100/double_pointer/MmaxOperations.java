package hot_100.double_pointer;

import java.util.Arrays;
import java.util.HashMap;

public class MmaxOperations {
    //1679. K 和数对的最大数目
/*    public int maxOperations(int[] nums, int k) {
        if(null == nums || nums.length < 2)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i = 0;i < nums.length; ++i){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else {
                map.put(nums[i],1);
            }
        }
        int cnt = 0;
        for(int i = 0;i < nums.length;++i){
            int x = nums[i];
            Integer v1 = map.get(x);
            if(v1 <= 0)
                continue;
            int y = k - x;
            Integer v2 = map.get(y);
            if(null == v2 || v2 <= 0)
                continue;
            if(x == y && v1 < 2)
                continue;
            ++cnt;
            if(x == y){
                map.put(x,v1 - 2);
            }else {
                map.put(x,v1 - 1);
                map.put(y,v2 - 1);
            }
        }
        return cnt;
    }*/
    //双指针
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int res=0;
        int left=0;
        int right=nums.length-1;

        while(left < right){
            long val=nums[left]+nums[right];

            // 大于目标值则右边界移动
            if(val > k)
            { --right; }
            // 小于目标值则左区间移动
            else if(val < k)
            { ++left; }
            else{
                ++res;
                ++left;
                --right;
            }
        }
        return res;
    }
    public static void main(String[] args){
        MmaxOperations q = new MmaxOperations();
        System.out.println( q.maxOperations(new int[]{
                3,1,3,4,3
       },6));
    }
}
