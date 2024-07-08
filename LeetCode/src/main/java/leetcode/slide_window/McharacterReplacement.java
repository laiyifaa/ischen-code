package leetcode.slide_window;

import java.util.*;

public class McharacterReplacement {
    private int getLen(int k,String s,char c){
        int l = 0;
        int r = 0;
        int ans = 0;
        while (r < s.length()){
            if(s.charAt(r) != c){
                --k;
            }
            while (k < 0){
                if (s.charAt(l) != c){
                    ++k;
                }
                ++l;
            }
            int temp = r - l + 1;
            if(temp > ans){
                ans = temp;
            }
            ++r;
        }
        return ans;
    }
    //424. 替换后的最长重复字符
    public int characterReplacement(String s, int k) {
        if( s.length() <= k)
            return s.length();
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < s.length();++i){
            char c = s.charAt(i);
            set.add(c);
        }
        int ans = 0;
        for(Character c : set){
            int temp = getLen(k,s,c);
            if(temp > ans){
                ans = temp;
            }
        }
        return ans;
    }
    public static void main(String[] args){  
        McharacterReplacement q = new McharacterReplacement();
        System.out.println(q.characterReplacement("AABABBA",1));
    }
}
