package hot_100.martix;

public class MsetZeroes {

    private void setRow(int[][] matrix ,int index){
        int a[] = matrix[index];
        for(int i = 0;i<a.length;i++){
            a[i] = 0;
        }
    }
    private void setCol(int[][] matrix,int index){
        for(int i = 0;i<matrix.length;i++){
            matrix[index][i] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        if(null == matrix || null == matrix[0])
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0;i < m;i ++){


            for(int j = 0;j<n;j++){

            }

        }
    }
}
