package leetcode.double_pointer;

import java.util.LinkedList;

public class reverseVowels {
    //345. 反转字符串中的元音字母
    public String reverseVowels(String s) {
        if(null == s || s.length() == 0)
            return s;
        char[] chars = s.toCharArray();
        LinkedList<Character> temp = new LinkedList<>();
        for(int i = 0;i<chars.length;++i){
            if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'
            ||chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U'){
                temp.addFirst(chars[i]);
            }
        }
        for(int i = 0;i < chars.length;++i){
            if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'
                    ||chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U'){
                chars[i] = temp.pollFirst();
            }
        }
        return new String(chars);
    }
}
