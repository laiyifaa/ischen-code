package leetcode.heap;


import java.util.PriorityQueue;

public class HIsChen_MedianFinder {

    //俩个堆 动态求中位数
    PriorityQueue<Integer> minHeap ;//存大数
    PriorityQueue<Integer> maxHeap ;//存小数
    //295. 数据流的中位数
    //面试题 17.20. 连续中值
    public HIsChen_MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        if(minHeap.isEmpty() || num >= minHeap.peek()){
            minHeap.add(num);
        }else {
            maxHeap.add(num);
        }
        if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }else if(maxHeap.size() > minHeap.size()){
            minHeap.add(maxHeap.poll());
        }

    }

    public double findMedian() {
       if(minHeap.size() == maxHeap.size())
           return  (maxHeap.peek() + minHeap.peek())*1.0 /2;
       else return minHeap.peek();
    }
    public static void main(String[] args){  
        HIsChen_MedianFinder q = new HIsChen_MedianFinder();
        
    }
}
