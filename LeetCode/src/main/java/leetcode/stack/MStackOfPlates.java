package leetcode.stack;

import java.util.*;

public class MStackOfPlates {
    //面试题 03.03. 堆盘子
    LinkedList<LinkedList<Integer>> stackList ;
    int len ;
    public MStackOfPlates(int cap) {
        stackList = new LinkedList<>();
        len = cap;
    }

    public void push(int val) {
        if(len == 0)
            return;
       addVal(val);
    }

    private void addVal(int val) {
        int minSize = len;
        LinkedList<Integer> minStack  = null;
        for(LinkedList<Integer> stack : stackList){
            if(stack.isEmpty()){
                minStack = stack;
                break;
            }
            if(stack.size() < minSize ){
                minSize = stack.size();
                minStack = stack;
            }
        }
       if(null != minStack){
           minStack.add(val);
           return;
       }
       LinkedList<Integer> stack = new LinkedList<>();
       stack.addLast(val);
       stackList.addLast(stack);
       return ;
    }


    public int pop() {
        if(len == 0 || stackList.isEmpty())
            return -1;
        LinkedList<Integer> lastStack = stackList.peekLast();
        if(lastStack.isEmpty())
            return -1;
        int ans = lastStack.pollLast();
        if(lastStack.isEmpty()){
           stackList.pollLast();
        }
        return ans;
    }

    public int popAt(int index) {
        if(len == 0)
            return  -1;
        if(index < 0 || index >= stackList.size())
            return -1;
        LinkedList<Integer> stack = stackList.get(index);
        Integer ans = stack.pollLast();
        if(stack.isEmpty())
            stackList.remove(index);
        return ans;
    }
    public static void main(String[] args){  
        MStackOfPlates s = new MStackOfPlates(6);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.popAt(1));
        System.out.println(s.popAt(3));
        System.out.println(s.pop());
        s.push(40);
        s.push(10);
        s.push(44);
        s.push(44);
        System.out.println(s.pop());
        s.push(24);
        s.push(42);
        System.out.println(s.popAt(4));
        System.out.println(s.pop());
        System.out.println(s.popAt(0));
        s.push(42);
        System.out.println(s.popAt(5));
        System.out.println(s.pop());
        s.push(29);
    }
}
