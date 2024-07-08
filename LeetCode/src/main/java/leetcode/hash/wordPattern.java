package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class wordPattern {

    //290. 单词规律
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null)
            return false;
        if(pattern.length() == 0 || s.length() == 0)
            return false;
        Map<Character,String> p2sMap = new HashMap<>(pattern.length() >> 1);
        Map<String,Character> s2pMap = new HashMap<>(pattern.length() >> 1);
        int j = 0;
        int i = 0;
        for(i = 0;i < pattern.length();++i){
            Character c = pattern.charAt(i);
            if(i >= pattern.length() || j >= s.length())
                break;
            int l = j;
            while (j < s.length() && s.charAt(j) != ' ' ){
                ++j;
            }
            String word = s.substring(l,j++);
            String map_word = p2sMap.get(c);
            Character map_c = s2pMap.get(word);
            if(map_c == null && map_word == null){
                p2sMap.put(c,word);
                s2pMap.put(word,c);
                continue;
            }
            if(null == map_c || null == map_word)
                return false;
            if(c != map_c || !word.equals(map_word))
                return false;
        }
        if(i >= pattern.length()  && j>= s.length() )
            return true;
        return false;
    }
    public static void main(String[] args){  
        String s = "jquery";
        String pattern = "jquery";
        wordPattern q = new wordPattern();
        System.out.println(q.wordPattern(pattern,s));

    }
}
