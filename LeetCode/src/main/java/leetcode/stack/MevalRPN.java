package leetcode.stack;


import java.util.LinkedList;

public class MevalRPN {

    //150. 逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        if(null == tokens || tokens.length == 0)
            return 0;
        LinkedList<Integer> numStack = new LinkedList<>();
        for(String token : tokens){
           int opFlag = -1;
           if(token.length() == 1 ){
               if("/".equals(token) ){
                   opFlag = 3;
               }
               if( "*".equals(token) ){
                   opFlag = 2;
               }
               if("+".equals(token)){
                   opFlag = 1;
               }
               if( "-".equals(token)){
                   opFlag = 0;
               }
           }
           if(opFlag < 0){
               Integer x = Integer.parseInt(token);
               numStack.addFirst(x);
           }else  {
               Integer y = numStack.pollFirst();
               Integer x = numStack.pollFirst();
               if(opFlag == 0){
                   numStack.addFirst(x - y);
               }
               if(opFlag == 1){
                   numStack.addFirst(x + y);
               }
               if(opFlag == 2){
                   numStack.addFirst(x * y);
               }
               if(opFlag == 3){
                   numStack.addFirst(x / y);
               }
           }
        }
        return numStack.pollFirst();
    }
    public static void main(String[] args){  
        MevalRPN q = new MevalRPN();
        System.out.println(q.evalRPN(new String[]{
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        }));
    }
}
