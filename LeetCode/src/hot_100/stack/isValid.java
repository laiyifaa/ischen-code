package hot_100.stack;

import java.util.LinkedList;

public class isValid {
    //20. 有效的括号
    public boolean isValid(String s) {
        if (null == s || s.length() == 0)
            return true;
        int len = s.length();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.addFirst(c);
                continue;
            } else if (stack.isEmpty())
                return false;
            if (c == ')' && stack.getFirst() == '(') {
                stack.removeFirst();
                continue;
            }
            if (c == '}' && stack.getFirst() == '{') {
                stack.removeFirst();
                continue;
            }
            if (c == ']' && stack.getFirst() == '[') {
                stack.removeFirst();
                continue;
            }
            return false;
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        isValid V = new isValid();
        System.out.println(V.isValid("()"));
    }
}
