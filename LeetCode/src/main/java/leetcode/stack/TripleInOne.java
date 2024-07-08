package leetcode.stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class TripleInOne {
    //面试题 03.01. 三合一
    ArrayList<LinkedList<Integer>> stackList ;
    int size = 0;
    public TripleInOne(int stackSize) {
        stackList = new ArrayList<>(3);
        for(int i = 0;i < 3; ++i){
            stackList.add(new LinkedList<>());
        }
        size = stackSize;
    }
    public void push(int stackNum, int value) {
        LinkedList<Integer> stack = stackList.get(stackNum);
        if(stack.size() >= size)
            return;
        stackList.get(stackNum).addFirst(value);
    }

    public int pop(int stackNum) {
        LinkedList<Integer> stack = stackList.get(stackNum);
        if( stack.isEmpty())
            return -1;
        return stack.pollFirst();
    }

    public int peek(int stackNum) {
        LinkedList<Integer> stack = stackList.get(stackNum);
        if( stack.isEmpty())
            return -1;
        return stack.peekFirst();
    }

    public boolean isEmpty(int stackNum) {
        return stackList.get(stackNum).isEmpty();
    }
    public static void main(String[] args){  
        TripleInOne t = new TripleInOne(1);
        t.push(0,1);
        t.push(0,2);
        System.out.println(t.pop(0));
        System.out.println(t.pop(0));
        System.out.println(t.pop(0));

    }
}
