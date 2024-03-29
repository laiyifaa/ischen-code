package leetcode.martix;

public class MIsChen_searchMatrix {
    /*public boolean searchMatrix(int[][] matrix, int target) {
        if(0 == matrix.length || 0 == matrix[0].length){
            return false;
        }
        for(int i = 0;i<matrix.length;i++){
            int l = 0;
            int r = matrix[i].length-1;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(matrix[i][mid] == target)
                    return true;
                else if (matrix[i][mid] < target){
                    l = mid+1;
                }
                else r = mid-1;
            }
        }
        return false;
    }*/
    //面试题 10.09. 排序矩阵查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if(0 == matrix.length || 0 == matrix[0].length){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0,y = n-1;
        while(x<m && x>=0 && y>=0 &&y<n){
            if(matrix[x][y] == target)
                return true;
            else if(matrix[x][y]>target){
                --y;
            }else {
                ++x;
            }
        }
        return false;
    }

}
