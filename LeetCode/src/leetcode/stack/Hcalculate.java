package leetcode.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Hcalculate {

    //224. 基本计算器
    Map<Character,Integer> opMap = new HashMap<>(4);
    private void init(){
        opMap.put('+',0);
        opMap.put('-',0);
        opMap.put('*',1);
        opMap.put('/',1);
    }
    private boolean isNum(char c){
        if(c  >= '0' && c <= '9')
            return true;
        return false;
    }
    public int calculate(String s) {
        if(null == s || s.length() == 0)
            return 0;
        init();
        LinkedList<Character> opStack = new LinkedList<>();
        LinkedList<Integer> numStack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int num = 0;
        for(int i = 0;i < chars.length;++i){
            char c = chars[i];
            if(c == ' ')
                continue;
            if(isNum(c)){
                num = num * 10 + c - '0';
                continue;
            }
            if(c == '('){
                opStack.addLast(c);
                continue;
            }
            if(c == ')'){
                if(num >= 0){
                    numStack.addLast(num);
                }
                while (!opStack.isEmpty()){
                    char op = opStack.pollLast();
                    if(op == '(')
                        break;
                    numStack.addLast(cal(numStack.pollLast(),numStack.pollLast(),op));
                }
                num = -1;
            }
            if(opMap.containsKey(c)){
                if(num >= 0){
                    numStack.addLast(num);
                }

                num = 0;
                while ( !opStack.isEmpty()   ){
                    char op = opStack.getLast();
                    if(op == '(')
                        break;
                    if(opMap.get(op) < opMap.get(c)){
                        break;
                    }
                    Integer a = numStack.pollLast();
                    Integer b = numStack.pollLast();
                    numStack.addLast(cal(a,b,opStack.pollLast()));
                }
                opStack.addLast(c);
            }

        }
        if(num >= 0 ){
            numStack.addLast(num);
        }

        while (!opStack.isEmpty()){
            numStack.addLast(cal(numStack.pollLast(),numStack.pollLast(),opStack.pollLast()));
        }
        return numStack.pollLast();
    }

    private Integer cal(Integer a, Integer b, Character c) {
        if(c == '-')
            return b - a;
        if(c == '+')
            return a + b;
        if(c == '*')
            return a * b;
        if(c == '/')
            return b / a;
        return 0;
    }
    public static void main(String[] args){
        Hcalculate q = new Hcalculate();
        System.out.println(q.calculate("- (3 + (4 + 5))"));
    }
}
