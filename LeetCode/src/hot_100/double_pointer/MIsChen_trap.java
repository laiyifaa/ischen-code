package hot_100.double_pointer;

import java.util.Stack;

public class MIsChen_trap {

    public int trap(int[] height) {
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
                    /*while(!stack.isEmpty()&&height[stack.peek()]> height[i]){
                        stack.pop();
                    }*/
                }
                i--;
            }
        }
        return ans;
    }

}
