package leetcode.stack;

import java.util.LinkedList;

public class MremoveStars {
    //2390. 从字符串中移除星号
    public String removeStars(String s) {
        if(null == s || s.length() == 0)
            return "";
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0;i < s.length();++i){
            if(s.charAt(i) == '*'){
                stack.pollLast();
                continue;
            }
            stack.addLast(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            char c = stack.pollFirst();
            ans.append(c);
        }
        return ans.toString();
    }
    public static void main(String[] args){
        MremoveStars q = new MremoveStars();
        System.out.println(
                q.removeStars("erase*****")
        );
    }
}
