package leetcode.greedy;

import java.util.LinkedList;

public class MremoveKdigits {

    //402. 移掉 K 位数字
    //丢弃K 个数字 ，从左到右丢弃单调下降数字
    public String removeKdigits(String num, int k) {
        if(num.length() == k)
            return "0";
        LinkedList<Integer> stack = new LinkedList<>();
        char[] chars = num.toCharArray();
        for(int i = 0;i < chars.length;++i){
            int v = chars[i] - '0';
            if(stack.isEmpty() || k == 0 ||v >= stack.peekFirst()){
                stack.addFirst(v);
                continue;
            }
            while (!stack.isEmpty() && v < stack.peekFirst() && k > 0){
                stack.pollFirst();
                --k;
            }
            stack.addFirst(v);
        }
        while (k > 0){
            stack.pollFirst();
            --k;
        }
        boolean flag = true;
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            Integer v = stack.pollLast();
            if(flag && v == 0)
                continue;
            flag = false;
            res.append(v);
        }
        return res.length() == 0 ? "0":res.toString();
    }
    public static void main(String[] args){
        MremoveKdigits q = new MremoveKdigits();
        System.out.println(
                q.removeKdigits("1432219",3)
        );
    }
}
