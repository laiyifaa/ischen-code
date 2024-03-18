package leetcode.hash;

import java.util.Arrays;

public class isAnagram {

    //242 有效字母异或
    public boolean isAnagram(String s, String t) {
        if(null == s || t == null || s.length() != t.length())
            return false;
        int[] usedS = new int[26];
        int[] usedT = new int[26];
        for(int i = 0;i < s.length();++i){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            ++usedS[c1 - 'a'];
            ++usedT[c2 - 'a'];
        }
        for(int i = 0;i < 26;++i){
            if(usedS[ i] != usedT[ i])
                return false;
        }
        return true;
    }
}
