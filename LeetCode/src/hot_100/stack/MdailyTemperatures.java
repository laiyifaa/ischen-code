package hot_100.stack;

import java.util.LinkedList;

public class MdailyTemperatures {

    //739. 每日温度 单调栈
    public int[] dailyTemperatures(int[] temperatures) {
        if(null == temperatures || temperatures.length == 0)
            return new int[]{};
        int[] ans = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0 ; i < temperatures.length; ++i){
            Integer x = temperatures[i];
            if(stack.isEmpty()){
                stack.addFirst(i);
                continue;
            }
            Integer top = stack.peekFirst();
            while (!stack.isEmpty() && temperatures[top] < x){
                ans[top] = (i - top);
                stack.removeFirst();
                top = stack.peekFirst();
            }
            if( stack.isEmpty() || x <= temperatures[top]){
                stack.addFirst(i);
            }
        }
        return ans;
    }
    public static void main(String[] args){  
        MdailyTemperatures q = new MdailyTemperatures();
        int a[] = q.dailyTemperatures(new int[]{
                30,40,50
        });
        for(int i = 0; i < a.length; ++ i){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
