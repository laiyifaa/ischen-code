package leetcode.slide_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HmedianSlidingWindow {

    //俩个堆 动态求中位数
    //init
    //将前K个元素全部插入到small堆中。从small堆中弹出K/2个元素到big堆中
    //这样，当K为奇数，则small堆元素比big堆元素多1；当K为偶数，两个堆元素相等。
    //start
    //我们的插入操作可以保证每次优先插入到small堆中，因此small堆中的元素个数大于等于big堆的元素个数。
    //当K为奇数时候，中位数是元素数量较多的small堆 堆顶元素。
    //当K为偶数时候，中位数是small堆和big堆的堆顶元素平均值。

    PriorityQueue<Integer> minHeap ;//存大数
    PriorityQueue<Integer> maxHeap ;//存小数
    HashMap<Integer,Integer> map;
    //480. 滑动窗口中位数
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(null == nums || nums.length == 0 || k == 0)
            return new double[]{};
        minHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxHeap = new PriorityQueue<>();
        double[] ans = new double[nums.length - k + 1];
        int index = 0;
        //init
        for(int i = 0;i < k;++i){
            minHeap.add(nums[i]);
        }
        for(int i = 0;i < k/2;++i){
            maxHeap.add(minHeap.poll());
        }
        ans[index++] = findMid(k);
        map = new HashMap<>(nums.length);
        for(int i = k;i < nums.length;++i){
            int temp = nums[i];
            int balance = 0;
            int l = nums[i - k];
            map.put(l,map.getOrDefault(l,0) + 1);
            if(!minHeap.isEmpty() && l <= minHeap.peek()){
                --balance;
            }else ++balance;
            if(!minHeap.isEmpty() && temp <= minHeap.peek()){
                minHeap.add(temp);
                ++balance;
            }else {
                maxHeap.add(temp);
                --balance;
            }
            if(balance > 0){
                maxHeap.add(minHeap.poll());
            }
            if(balance < 0){
                minHeap.add(maxHeap.poll());
            }
            while (!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(),0) > 0){
                map.put(minHeap.peek(),map.getOrDefault(minHeap.peek(),0) - 1);
                minHeap.poll();
            }
            while (!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(),0) > 0){
                map.put(maxHeap.peek(),map.getOrDefault(maxHeap.peek(),0) - 1);
                maxHeap.poll();
            }
            ans[index++] = findMid(k);
        }
/*      超时
        int[] temp = new int[k];
        int l = 0;
        int r = k - 1 ;

        while (r < nums.length){
            for(int i = l,j = 0;i <= r;++i,++j)
                temp[j]=nums[i];
            Arrays.sort(temp);
            if(k % 2 == 1)
                ans[index++] = temp[k / 2];
            else ans[index++] = ((long)temp[k / 2 ] + (long)temp[k / 2 - 1]) / 2.0;
            ++l;
            ++r;
        }*/
        return ans;
    }
    private double findMid(int k ) {
        if(k % 2 == 1) return minHeap.peek();
        else return ((long)minHeap.peek()+maxHeap.peek())*0.5;

    }

    public static void main(String[] args){
        HmedianSlidingWindow  q = new HmedianSlidingWindow();
        double[] ans = q.medianSlidingWindow(new int[]{
                -2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648
        }, 2);
        for(double x : ans)
            System.out.print(x + " ");
        System.out.println();
    }
}
