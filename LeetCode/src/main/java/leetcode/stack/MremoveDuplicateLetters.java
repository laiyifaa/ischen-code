package leetcode.stack;

import java.util.LinkedList;

public class MremoveDuplicateLetters {


    //316. 去除重复字母
    public String removeDuplicateLetters(String s) {
        if(null == s || s.length() <= 1)
            return s;
        char[] chars = s.toCharArray();
        int[] num = new int[26];
        for(char c : chars){
            ++num[c - 'a'];
        }
        StringBuilder sb = new StringBuilder(26);
        boolean[] used = new boolean[26];
        for(int i = 0;i < chars.length;++i){
            char c = chars[i];
            --num[c - 'a'];
            if(used[c - 'a'])
                continue;
            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && num[sb.charAt(sb.length() - 1) - 'a'] > 0){
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            used[c - 'a'] = true;
        }
        return sb.toString();
    }
    public static void main(String[] args){  
        MremoveDuplicateLetters q = new MremoveDuplicateLetters();
        System.out.println(q.removeDuplicateLetters("cbacdcbc"));
    }
}
