package leetcode.hash;

import java.util.*;

public class McloseStrings {
    //1657. 确定两个字符串是否接近
    public boolean closeStrings(String word1, String word2) {
        if(null == word1 || null == word2)
            return false;
        if(word1.length() != word2.length())
            return false;
        int[]usedA = new int[26];
        int[]usedB = new int[26];
        for(int i = 0;i<word1.length();++i){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            ++usedA[c1 - 'a'];
            ++usedB[c2 - 'a'];
        }
        for(int i = 0;i<26;++i){
            if(usedA[i] == 0 || usedB[i] == 0){
                if(usedA[i] + usedB[i] != 0)
                    return false;
            }
        }
        Arrays.sort(usedA);
        Arrays.sort(usedB);
        for(int i = 0;i<26;++i){
            if(usedA[i] != usedB[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args){  
        McloseStrings q = new McloseStrings();
        System.out.println(q.closeStrings(
                "abc",
                "bca"
        ));
    }
}
