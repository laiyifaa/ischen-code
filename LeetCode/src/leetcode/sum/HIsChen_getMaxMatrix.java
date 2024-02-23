package leetcode.sum;

import java.util.Arrays;

public class HIsChen_getMaxMatrix {

    //面试题 17.24. 最大子矩阵
    //dp 前缀和 + 最长子序和
    public int[] getMaxMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
      //二维列求和
        int[][] preSum = new int[n ][m ];
        for(int i = 0; i < n ; i ++) {
            for(int j = 0;j < m; ++j){
                if(i == 0)
                    preSum[i][j] = matrix[i][j];
                else {
                    preSum[i][j] = preSum[i - 1][j] + matrix[i][j];
                }
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int[] dp = new int[m];
        int[] ans = new int[4];
        for(int r1 = 0; r1 < n;++r1){
            for(int r2 = r1;r2 < n;++r2){
                Arrays.fill(dp,0);
                for(int c2 = 0;c2 < m; ++c2){
                    if(r1 == 0)
                        dp[c2] = preSum[r2][c2];
                    else
                        dp[c2] = preSum[r2][c2] - preSum[r1 - 1][c2];
                }
                int c1 = 0;
                int temp = Integer.MIN_VALUE;
                for(int c2 = 0; c2 < m;++c2){
                    if(temp > 0)
                        temp += dp[c2];
                    else {
                        temp = dp[c2];
                        c1 = c2;
                    }
                    if(temp > maxSum){
                        maxSum = temp;
                        ans = new int[]{r1,c1,r2,c2};
                    }
                }
            }
        }
        return ans;
    }
}
