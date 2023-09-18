package leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class uniqueOccurrences {
    //1207. 独一无二的出现次数
    public boolean uniqueOccurrences(int[] arr) {
        if(null == arr || arr.length == 0 || arr.length == 1)
            return true;
        Map<Integer,Integer> map = new HashMap<>(arr.length);
        Set<Integer> set = new HashSet<>(arr.length);
        for(int i = 0;i < arr.length;++i){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i]) + 1);
            }else {
                map.put(arr[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(set.contains(entry.getValue()))
                return false;
            set.add(entry.getValue());
        }
        return true;
    }
    public static void main(String[] args){
        uniqueOccurrences q = new uniqueOccurrences();
        System.out.println(q.uniqueOccurrences(new int[]{
                -3,0,1,-3,1,1,1,-3,10,0
        }));
    }
}
