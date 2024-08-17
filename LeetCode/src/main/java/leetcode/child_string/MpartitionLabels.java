package leetcode.child_string;

import java.util.*;

public class MpartitionLabels {

    //763. 划分字母区间
    public List<Integer> partitionLabels(String s) {
        if(null == s || "".equals(s))
            return new LinkedList<>();
        List<Integer> ansList = new LinkedList<>();
        Map<Character,List<Integer>> map = new LinkedHashMap<>(26);
        char[] chars = s.toCharArray();
        for(int i = 0;i < chars.length;++i){
            char c = chars[i];
            if(map.containsKey(c)){
                map.get(c).add(i);
            }else {
                List<Integer> tempList = new ArrayList<>(s.length() / 26);
                tempList.add(i);
                map.put(c,tempList);
            }
        }

        int l = 0;
        int r = 0;
        for(Map.Entry<Character,List<Integer>> entry : map.entrySet()){
            List<Integer> valueList = entry.getValue();
            if(valueList.size() == 1){
                int x = valueList.get(0);
                if(x > r){
                    ansList.add(r - l + 1);
                    l = x;
                    r = x;
                }
                continue;
            }
            if(valueList.size() > 1){
                int L = valueList.get(0);
                int R = valueList.get(valueList.size() - 1);
                if(L > r){
                    ansList.add(r - l + 1);
                    l = L;
                    r = R;
                }
                if(R > r){
                    r = R;
                }

            }
        }
        ansList.add(r - l + 1);
        return ansList;
    }
    public static void main(String[] args){
        MpartitionLabels q = new MpartitionLabels();
        List<Integer> list = q.partitionLabels("eaaaabaaec");
        System.out.println(list);
    }
}
