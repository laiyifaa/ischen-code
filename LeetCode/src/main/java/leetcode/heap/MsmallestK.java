package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MsmallestK {

    //面试题 17.14. 最小K个数
    public int[] smallestK(int[] arr, int k) {
        if(null == arr || arr.length == 0)
            return new int[0];
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        //大顶堆 放小元素
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}
