package leetcode.dp.mult_dp;

public class MuniquePathsWithObstacles {

    //63.不同路径II
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n  = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n ][m ];
        int temp  = 1;
        for(int i = 0;i < m;++i){
            if(obstacleGrid[0][i] == 1)
                temp = 0;
            dp[0][i] = temp;

        }
        temp = 1;
        for(int i = 0;i < n;++i){
            if(obstacleGrid[i][0] == 1)
                temp = 0;
            dp[i][0] = temp;
        }
        for(int i = 1;i < n;++i){
            for(int j = 1;j < m;++j){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
    public static void main(String[] args){  
        MuniquePathsWithObstacles q = new MuniquePathsWithObstacles();
        ;
        System.out.println(q.uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        }));
    }
}
