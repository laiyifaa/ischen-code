package leetcode.dp;

public class MIsChen_maximalSquare {
    //221.最大正方形

    /*暴力
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0;i < r;++i){
            for(int j = 0;j < c; ++j){
                if(matrix[i][j] == '1'){
                    maxSide = Math.max(maxSide,1);
                    int curSide = Math.min(r - i,c - j);//可能的最大边长
                    for(int k = 1;k < curSide;++k){
                        boolean flag = true;
                        if(matrix[i + k][j + k] == '0')
                            break;
                        for(int m = 0;m < k;++m){
                            if(matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            maxSide = Math.max(maxSide,k + 1);
                        }else break;
                    }
                }
            }
        }
        return maxSide * maxSide;
    }*/
    //dp
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(dp[i - 1][j],Math.min(dp[i][j - 1],dp[i - 1][j - 1])) + 1;
                    }
                    if(dp[i][j] > maxSide)
                        maxSide = dp[i][j];
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }


}
