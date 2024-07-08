package leetcode.binSearch;

public class MsearchMatrix {
    private int searchCol(int[][] matrix,int target){
        int l = 0;
        int r = matrix.length-1;
        while (l<=r){
            int mid = l + (r - l )/2;
            if(matrix[mid][0] == target)
                return mid;
            else if(matrix[mid][0] > target)
                r = mid - 1;
            else  l = mid + 1;
        }
        return l-1;
    }
    public boolean searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] > target )
                r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || null == matrix[0]){
            return false;
        }
/*        int m = matrix.length;//行数
        int n = matrix[0].length;//列数*/
        int col = searchCol(matrix,target);
        if(col < 0)
            return false;
        return searchInsert(matrix[col],target);
    }
    public static void main(String[] args){
        MsearchMatrix q = new MsearchMatrix();
        System.out.println(
                q.searchMatrix(new int[][]{
                     /*   {1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,60}*/
                        {1}
                },0)
        );
    }
}

