package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class IsChen_isIsomorphic {
    //205. 同构字符串
    // 映射 = a->b b->a
    public boolean isIsomorphic(String s, String t) {
        if(null == s || null == t || s.length() != t.length())
            return false;
        Map<Character,Character> s2tMap = new HashMap<>(s.length() >> 2);
        Map<Character,Character> t2sMap = new HashMap<>(s.length() >> 2);
        for(int i = 0;i < s.length();++i){
            char c = s.charAt(i);
            char v = t.charAt(i);
            Character map_v = s2tMap.get(c);
            Character map_c = t2sMap.get(v);
            if(null == map_c && null == map_v){
                s2tMap.put(c,v);
                t2sMap.put(v,c);
                continue;
            }
            if(map_c == null || map_v == null)
                return false;
            if(c != map_c || v != map_v)
                return false;
        }
        return true;
    }

}
