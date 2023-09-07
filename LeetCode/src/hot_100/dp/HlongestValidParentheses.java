package hot_100.dp;

import java.util.LinkedList;

public class HlongestValidParentheses {
    //32. 最长有效括号
    public int longestValidParentheses(String s) {
        if(null == s || s.length() == 0)
            return 0;
        int ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0;i < s.length();++i){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else {
                stack.pollFirst();
                if(stack.isEmpty()){
                    stack.push(i);
                    continue;
                }
                ans = Math.max(ans,i - stack.peekFirst());
            }
        }
        return ans;
    }
    public static void main(String[] args){
        HlongestValidParentheses q = new HlongestValidParentheses();
        System.out.println(q.longestValidParentheses(
                "()((())"
        ));
    }
}
