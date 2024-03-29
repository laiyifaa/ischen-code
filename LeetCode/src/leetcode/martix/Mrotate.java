package leetcode.martix;

public class Mrotate {
    //面试题 01.07. 旋转矩阵
    //48. 旋转图像
    public void rotate(int[][] matrix) {
        if(null == matrix || null == matrix[0])
            return;
        int m = matrix.length;//rows
        int n = matrix[0].length;//cols
        int[][] temp = new int[m][n];
        for(int i = 0;i<m;i++){
            int l = 0;
            for(int j = 0;j<n;j++){
                temp[l++][n-1-i]  = matrix[i][j];
            }
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
