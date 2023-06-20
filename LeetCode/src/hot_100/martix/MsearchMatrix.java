package hot_100.martix;

public class MsearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || null == matrix[0]){
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
    }
    public static void main(String[] args){
        MsearchMatrix q = new MsearchMatrix();
        System.out.println(q.searchMatrix(new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        },5));
    }
}
