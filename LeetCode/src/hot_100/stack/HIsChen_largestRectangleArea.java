package hot_100.stack;

import java.util.LinkedList;

public class HIsChen_largestRectangleArea {
    //84. 柱状图中最大的矩形
    //单调栈
    public int largestRectangleArea(int[] heights) {
        if(null == heights || heights.length == 0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; ++i){
            while (stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]){
                int temp = heights[stack.pollFirst()] * (i - stack.peekFirst() - 1);
                ans = Math.max(ans,temp);
            }
            stack.addFirst(i);
        }
        while (stack.peekFirst() != -1){
            int temp = heights[stack.pollFirst()] * (heights.length - stack.peekFirst() - 1);
            ans = Math.max(ans,temp);
        }
        return ans;
    }
    public static void main(String[] args){
        HIsChen_largestRectangleArea q = new HIsChen_largestRectangleArea();
        System.out.println(q.largestRectangleArea(new int[] {
                2,1,5,6,2,3
        }));
    }
}
