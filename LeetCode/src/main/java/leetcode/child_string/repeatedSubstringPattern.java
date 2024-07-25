package leetcode.child_string;

import java.util.Arrays;

public class repeatedSubstringPattern {

    //459. 重复的子字符串
    public boolean repeatedSubstringPattern(String s) {
        return kmp(s + s,s);
    }

    private boolean kmp(String t, String s) {
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < s.length()){
            if(k == -1 || s.charAt(j) == s.charAt(k)){
                ++j;
                ++k;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        int i = 0;
        j = 0;
        while (i < t.length()){
            if(j == -1 || s.charAt(i) == t.charAt(j)){
                ++i;
                ++j;
            }else {
                j = next[j];
            }
            if(j == s.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        repeatedSubstringPattern q = new repeatedSubstringPattern();
        System.out.println(q.repeatedSubstringPattern("aba"));
    }
}
