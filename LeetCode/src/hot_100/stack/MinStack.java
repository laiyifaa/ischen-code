package hot_100.stack;

import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        if(val<=minStack.getFirst()){
            minStack.push(val);
        }
    }

    public void pop() {
        int val  = stack.removeFirst();
        if(val == minStack.getFirst()){
            minStack.removeFirst();
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }
}
