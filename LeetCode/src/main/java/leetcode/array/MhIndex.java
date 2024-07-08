package leetcode.array;

import java.util.TreeMap;

public class MhIndex {
    //274. H 指数
    public int hIndex(int[] citations) {
        if(null == citations || citations.length == 0)
            return 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0;i < citations.length;++i){
            map.put(citations[i],map.getOrDefault(citations[i],0) + 1);
        }
        int ans = -1;
        int preSum[] = new int[map.size() + 1];
        int index = 1;
        for(Integer key : map.keySet()){
            preSum[index] = preSum[index - 1] + map.get(key);
            index ++;
        }
        index = 0;
        for(Integer key : map.keySet()){
            int temp = preSum[map.size()] - preSum[index];
            int value = Math.min(temp,key);
            if(value >= key)
                ++index;
            if(value > ans){
                ans = value;
            }else break;
        }
        return ans;
    }
    public static void main(String[] args){
        MhIndex q = new MhIndex();
        System.out.println(
                q.hIndex(new int[]{
                   100
                })
        );
    }
}
