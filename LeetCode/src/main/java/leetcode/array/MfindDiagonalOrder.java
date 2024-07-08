package leetcode.array;

public class MfindDiagonalOrder {

    //498.对角线遍历
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans  = new int[m * n];
        int k = 0;
        int i = 0;
        int j = 0;
        int dir = 1;
        while (k < ans.length){
            if((i < 0 || i >= m ) || (j < 0 || j >= n)){
                if(dir == 1){
                    ++i;
                    --j;
                    dir = -1;
                    if(j == n - 1)
                        ++i;
                    else ++j;
                }else if(dir == -1){
                    ++j;
                    --i;
                    dir = 1;
                    if(i + 1 < m){
                        ++i;
                    }else {
                        ++j;
                    }
                }
                continue;
            }
            ans[k++] = mat[i][j];
            if(dir == 1){
                --i;
                ++j;
            }else {
                --j;
                ++i;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        MfindDiagonalOrder q = new MfindDiagonalOrder();
        int[] diagonalOrder = q.findDiagonalOrder(new int[][]{
                {1, 2},
                {3,4}
        });
        for(int x : diagonalOrder){
            System.out.println(x);
        }
    }
}
