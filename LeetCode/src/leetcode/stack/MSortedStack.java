package leetcode.stack;

import java.util.PriorityQueue;

public class MSortedStack {
    //面试题 03.05. 栈排序
    PriorityQueue<Integer> pq ;
    public MSortedStack() {
        pq = new PriorityQueue<>();
    }

    public void push(int val) {
        pq.add(val);
    }

    public void pop() {
        pq.poll();
    }

    public int peek() {
        if(pq.isEmpty())
            return -1;
        return pq.peek();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }
}
