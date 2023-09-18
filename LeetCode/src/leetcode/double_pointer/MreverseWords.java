package leetcode.double_pointer;

import java.util.LinkedList;

public class MreverseWords {
    //151. 反转字符串中的单词
    public String reverseWords(String s) {
        if(null == s || 0 == s.length() || 1 == s.length())
            return s;
        LinkedList<StringBuilder> temp = new LinkedList<>();
        s = s.trim();
        StringBuilder c = new StringBuilder();
        for(int i = 0;i<s.length();++i){
            char x = s.charAt(i);
            if(x == ' '){
                if(c.length() > 0){
                    temp.addFirst(c);
                    c = new StringBuilder();
                }
                continue;
            }else {
                c.append(x);
            }
        }
        c = c.length() == 0 ?new StringBuilder():new StringBuilder(c);
        for (int i = 0; i < temp.size();++i){
            c.append(' ');
            c.append(temp.get(i));
        }
        return c.toString();
    }
    public static void main(String[] args){
        MreverseWords q = new MreverseWords();
        System.out.println(q.reverseWords(
                "the sky is blue"
        ));
    }
}
