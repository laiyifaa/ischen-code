package leetcode.hash;

import java.util.*;

public class MIshChen_groupAnagrams {

    //素数思想 用来配乘积
    int[]  words = new int[]{
            2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101
    };

    private Long getValueByWord(String str){
        Long temp  = 1l;
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            temp *= words[c-'a'];
            temp %= Long.MAX_VALUE;
        }
        return temp;
    }

    /**
     * 思路：使用素数去配置26个字母
     * @param strs
     * @return
     */
    //面试题 10.02. 变位词组
    public List<List<String>> groupAnagrams(String[] strs) {
        if(null == strs){
            return null;
        }
        Map<Long,List<String>>  map = new HashMap<>(strs.length);
        for(int i = 0;i<strs.length;i++){
            String temp = strs[i];
            Long value = getValueByWord(temp);
            if(map.containsKey(value)){
                map.get(value).add(temp);
            }else {
                List<String> strList = new LinkedList<>();
                strList.add(temp);
                map.put(value,strList);
            }
        }
        return new ArrayList<>(map.values());
    }

}
