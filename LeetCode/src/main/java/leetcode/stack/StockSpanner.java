package leetcode.stack;

import java.util.LinkedList;

public class StockSpanner {

    LinkedList<Integer []> stack ;
    int cnt ;
    //901. 股票价格跨度
    public StockSpanner() {
        stack = new LinkedList<>();
        cnt = 0;
        stack.addFirst(new Integer[]{-1,-1});
    }
    public int next(int price) {
      if(!stack.isEmpty()){
          while (!stack.isEmpty() && price >= stack.peekFirst()[0]){
              stack.pollFirst();
          }
      }
      int x = stack.isEmpty()?-1:stack.peekFirst()[1];
      stack.addFirst(new Integer[]{price,cnt});
      ++cnt;
      return stack.peekFirst()[1] - x;
    }
}
