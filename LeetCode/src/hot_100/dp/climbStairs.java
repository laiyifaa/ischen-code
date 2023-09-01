package hot_100.dp;

public class climbStairs {
        // f(n+1) = f(n) + f(n-1)
/*    private int fun_matrix(int n){
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }*/
    private int fun_dp(int n){
        if(n == 1 || n == 2)
            return n;
        int a = 1;
        int b = 2;
        for(int i = 3;i<=n;++i){
            int x = b;
            b = a + b;
            a = x;
        }
        return b;
    }
    //70. 爬楼梯
    public int climbStairs(int n) {
        return fun_dp(n);
    }
}
