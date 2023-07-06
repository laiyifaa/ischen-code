package hot_100.double_pointer;

import java.util.Stack;

public class MIsChen_trap {


    //单调栈
    /*public int trap(int[] height) {
        if(null == height || height.length<=1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0;i < height.length; i++){
            if(stack.isEmpty() || height[stack.peek()] >= height[i]){
                stack.push(i);
                continue;
            }
            //形成凹槽
            if(height[stack.peek()]<= height[i] ){
                int l1 = stack.pop();
                if(stack.isEmpty()){
                    i--;
                    continue;
                }
                while(!stack.isEmpty() && height[stack.peek()] == height[l1]){
                    l1 = stack.pop();
                }
                if(!stack.isEmpty()){
                    ans = ans + (Math.min(height[stack.peek()],height[i])-height[l1])*(i - stack.peek() -1);
                    *//*while(!stack.isEmpty()&&height[stack.peek()]> height[i]){
                        stack.pop();
                    }*//*
                }
                i--;
            }
        }
        return ans;
    }*/
    //42 动态规划（统计左右俩边最大值，取左右最大值的最小值 >=height[i] +=ans）
    public int trap(int[] height) {
        int len = height.length;
        if(len==0||len ==1){
            return 0;
        }
        int ans = 0;
        int lmax[] = new int[len];
        int rmax[] = new int[len];
        lmax[0] = height[0];
        for(int i = 1;i<len;i++){
            lmax[i] = Math.max(lmax[i-1],height[i]);
        }
        rmax[len-1] = height[len-1];
        for(int i = len-2;i>=0;i--){
            rmax[i] = Math.max(rmax[i+1],height[i]);
        }
        for(int i = 1;i<len-1;i++){
            ans +=Math.min(lmax[i],rmax[i])-height[i];
        }
        return ans;
    }

}
