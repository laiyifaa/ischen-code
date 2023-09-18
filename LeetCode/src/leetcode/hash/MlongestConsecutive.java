package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class MlongestConsecutive {



    private int addConsecutiveCnt(Map<Integer,Integer> map,int key,int s){
        int cnt = 0;
        int i = 1;
        while (null != map.get(key+s*i)  && map.get(key+s*i)== 1){
            map.put(key+s*i,0);
            i++;
            cnt++;
        }
        return cnt;
    }
    public int longestConsecutive(int[] nums) {
        if(null == nums || 0 == nums.length){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
        }
        int ans = 0;
        for(Integer key : map.keySet()){
            if(0 == map.get(key)){
                continue;
            }
            int cnt = 1;
            map.put(key,0);
            while(true){
                int rcnt = addConsecutiveCnt(map,key,1);
                int lcnt = addConsecutiveCnt(map,key,-1);
                if(lcnt == 0 && rcnt == 0)
                    break;
                cnt += rcnt;
                cnt += lcnt;
            }
            if(cnt > ans){
                ans = cnt;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        MlongestConsecutive q = new MlongestConsecutive();

        System.out.println(q.longestConsecutive(new int[]{}));
    }
}
