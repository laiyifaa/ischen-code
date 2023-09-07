package hot_100.dp.mult_dp;

public class MminPathSum {
    //64. 最小路径和
    public int minPathSum(int[][] grid) {
        if(null == grid || grid.length == 0)
            return 0;
        int m = grid.length;
        if(null == grid[0] || grid[0].length == 0)
            return 0;
        int n = grid[0].length;
        int[][]dp = new int[m + 1][ n + 1];
        dp[0][0] = grid[0][0];
        for(int i = 1;i<m;++i){

            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int i = 1;i<n;++i){
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
         for(int i = 1;i < m; ++i){
             for (int j = 1;j<n;++j){
                 dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j],dp[i][j - 1] + grid[i][j]);
             }
         }
         return dp[m - 1][n - 1];
    }
    public static void main(String[] args){
        MminPathSum q = new MminPathSum();
        System.out.println(
                q.minPathSum(new int[][]{
                        {1,2,3},
                        {4,5,6}
                })
        );
    }
}
