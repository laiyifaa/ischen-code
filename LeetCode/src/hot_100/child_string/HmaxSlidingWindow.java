package hot_100.child_string;


import java.util.LinkedList;


public class HmaxSlidingWindow {
    //239. 滑动窗口最大值 单调队列，
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(null == nums || k == 0||k == 1)
            return nums;
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for(int i = 0;i<nums.length;++i){
            while (!queue.isEmpty()&&nums[queue.getLast()]<=nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            int m = i - k + 1;
            while (queue.getFirst()< m)
                queue.removeFirst();
            if(i>=k-1){
                ans[cnt++] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        HmaxSlidingWindow q = new HmaxSlidingWindow();
        int[] x = q.maxSlidingWindow(new int[]{5,3,4,1},3);
        for(int y : x){
            System.out.println(y+" ");
        }
    }
}
