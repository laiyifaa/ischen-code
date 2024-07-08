package leetcode.martix;

public class MsetZeroes {

    private void setRow(int[][] matrix ,int index){
        int a[] = matrix[index];
        for(int i = 1;i<a.length;i++){
            a[i] = 0;
        }
    }
    private void setCol(int[][] matrix,int index){
        for(int i = 1;i<matrix.length;i++){
            matrix[i][index] = 0;
        }
    }
    //面试题 01.08. 零矩阵
    //73. 矩阵置零
    public void setZeroes(int[][] matrix) {
        if(null == matrix || null == matrix[0])
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i = 0;i < n;i ++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }
        for(int i = 0;i < m;i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0;j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1;i < n;i++){
            if(matrix[0][i] == 0)
                setCol(matrix,i);
        }
        for(int i = 1;i< m;i++){
            if(matrix[i][0] == 0)
                setRow(matrix,i);
        }
        if(firstRow)
            for(int i = 0;i<n;i++){
                matrix[0][i] = 0;
            }
        if(firstCol)
            for(int i = 0;i<m;i++){
                matrix[i][0] = 0;
            }
    }
    public static void main(String[] args) {
        MsetZeroes m = new MsetZeroes();
        int[][] a = new int[][]
                {
                     /*   {0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}*/
                        {1,0}
                    };
        m.setZeroes(a);
    }
}
