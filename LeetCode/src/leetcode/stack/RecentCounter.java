package leetcode.stack;

import java.util.LinkedList;

public class RecentCounter {
    LinkedList<Integer> queue;
    //933. 最近的请求次数
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        if(queue.isEmpty())
            queue.addLast(t);
        else if(queue.peekFirst() + 3000 >= t)
            queue.addLast(t);
        else {
            while (!queue.isEmpty()){
                if(queue.peekFirst() + 3000 < t)
                    queue.pollFirst();
                else break;
            }
            queue.addLast(t);
        }
        return queue.size();
    }
}
