package leetcode.dp;

public class waysToStep {
    //面试题 08.01. 三步问题
    public int waysToStep(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int x = 0;
        for(int i = 4;i <= n;++i){
            x = (a + b) % 1000000007;
            x = (x + c) % 1000000007;
            a = b;
            b = c;
            c = x;
        }
        return x;
    }

}
