package leetcode.dp;

public class HfindSquare {

    //面试题 17.23. 最大黑方阵
    //通过dp记录上和做的连续黑方块
    public int[] findSquare(int[][] matrix) {
        if(null == matrix || matrix.length == 0)
            return new int[]{0};
        int n = matrix.length;
        int ansR = -1;
        int ansC = -1;
        int[][][] dp = new int[n][n][2];//[0]代表左连续 [1] 代表上连续
        int len = 0;
        for(int i = 0;i < n; ++i){
            for(int j = 0;j < n; ++j){
                if(matrix[i][j] == 0){
                    dp[i][j][0] = 1 + (j > 0 ? dp[i][j - 1][0] : 0);
                    dp[i][j][1] = 1 + (i > 0 ? dp[i - 1][j][1] : 1);
                }
                for(int size = Math.min(dp[i][j][0],dp[i][j][1]); size >= 1; --size){
                    if(dp[i][j - size + 1][1] >= size && dp[i - size + 1][j][0] >= size){
                        if(size > len){
                            len = size;
                            ansR = i - size + 1;
                            ansC = j - size + 1;
                            break;
                        }
                    }
                }
            }
        }
        if(ansR == -1 || ansC == -1 || len == 0)
            return new int[0];
        return new int[]{ansR,ansC,len};
    }

}
