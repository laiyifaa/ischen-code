package hot_100.dp;

public class climbStairs {
        // f(n+1) = f(n) + f(n-1)
   private int fun_matrix(int n){
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    private int[][] pow(int[][]q,int n){
        int[][] e = {{1, 0}, {0, 1}}; //单位矩阵
       while(n > 0){
           if((n&1) == 1){
               e = mult(e,q);
           }
           n >>= 1;
           q = mult(q,q);
       }
       return e;
    }
    private int[][] mult(int [][]a,int [][]b){
       int [][] c = new int[2][2];
       for(int i = 0;i < 2;++i){
           for(int j = 0;j < 2; ++j){
               c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
           }
       }
       return c;
    }
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
        return fun_matrix(n);
    }
}
