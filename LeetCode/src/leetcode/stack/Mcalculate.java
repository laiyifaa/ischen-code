package leetcode.stack;

import java.util.HashMap;
import java.util.LinkedList;

public class Mcalculate {
    //面试题 16.26. 计算器
    HashMap<Character,Integer> opMap = new HashMap<>(4);
    public int calculate(String s) {
        if(null == s || s.length() == 0)
            return 0;
        opMap.put('+',0);
        opMap.put('-',0);
        opMap.put('*',1);
        opMap.put('/',1);
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<Character> opStack = new LinkedList<>();
        int tempNum = 0;
        for(int i = 0; i < s.length();){
            char c = s.charAt(i);
            ++i;
            if(c == ' '){
                continue;
            }
            if(checkOp(c)){
                numStack.addFirst(tempNum);
                tempNum = 0;
                while (!opStack.isEmpty() &&equalOp(opStack.peek(),c)){
                    Integer a = numStack.pollFirst();
                    Integer b = numStack.pollFirst();
                    numStack.addFirst(cal(a,b,opStack.pollFirst()));

                }
                opStack.addFirst(c);
            }else {
                tempNum = tempNum * 10 + c - '0';
            }

        }
        if(tempNum >= 0)
            numStack.addFirst(tempNum);
        while (!opStack.isEmpty()){
            numStack.addFirst(cal(numStack.pollFirst(),numStack.pollFirst(),opStack.pollFirst()));
        }
        return numStack.pollFirst();
    }
    private Integer cal(Integer a, Integer b, Character c) {
        if(c == '+')
            return a + b;
        if(c == '-')
            return b - a;
        if(c == '*')
            return a * b;
        if(c == '/')
            return b / a;
        return 0;
    }
    private boolean equalOp(char a,char b){
        return (opMap.get(a) - opMap.get(b)) >= 0;
    }
    private boolean checkOp(char c){
        if(c == '+' || c == '-' || c == '*' || c =='/')
            return true;
        return false;
    }
    public static void main(String[] args){  
        Mcalculate q = new Mcalculate();
        System.out.println(q.calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
