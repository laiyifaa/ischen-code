package hot_100.greedy;

import java.util.*;

public class MpartitionLabels {
    public List<Integer> partitionLabels(String s) {
        LinkedList<Integer> ans = new LinkedList<>();
        if(null == s || s.length() == 0){
            return ans;
        }
        Map<Character,Integer[]> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); ++i){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                Integer[] temp = map.get(c);
                if(temp[1]  < i){
                    temp[1] = i;
                }
            }else {
                map.put(c,new Integer[]{i,i});
            }
        }
        int l = -1;
        int r = 0;
        for(Map.Entry<Character,Integer[]> entry : map.entrySet()){
            Character key = entry.getKey();
            Integer[] value = entry.getValue();
            if(l == -1){
                l = value[0];
            }
            if(value[0] > r){
                ans.add( r - l + 1);
                l = value[0];
                r = value[1];
            }else if(value[1] > r){
                r = value[1];
            }
        }
        if(r >= l)
            ans.add(r - l + 1);
        return ans;
    }
    public static void main(String[] args){  
        MpartitionLabels q = new MpartitionLabels();
        List<Integer> list = q.partitionLabels("eaaaabaaec");
        for(int i = 0;i<list.size();++i){
            System.out.println(list.get(i));
        }
    }
}
