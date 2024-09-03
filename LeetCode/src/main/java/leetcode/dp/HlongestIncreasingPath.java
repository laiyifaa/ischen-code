package leetcode.dp;

import java.util.Arrays;

public class HlongestIncreasingPath {

    int[][] dirs = new int[][]{
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
    };
    //329. 矩阵中的最长递增路径
    public int longestIncreasingPath(int[][] matrix) {
        int[][] used = new int[matrix.length][matrix.length];
        for(int i = 0;i < used.length;++i)
            Arrays.fill(used[i],-1);
        int ans = 1;
        for(int i = 0;i < matrix.length;++i){
            for(int j = 0;j < matrix[0].length;++j){
                int temp = solve(i,j,matrix,used);
                if(temp > ans)
                    ans = temp;
            }
        }
        return ans;
    }

    private int solve(int i, int j, int[][] matrix, int[][] used) {
        if(used[i][j] != -1)
            return used[i][j];
        used[i][j] = 1;
        for(int k = 0;k < dirs.length;++k){
            int xx = i + dirs[k][0];
            int yy = j + dirs[k][1];
            if(check(xx,yy,matrix) && matrix[xx][yy] > matrix[i][j]){
                int res = solve(xx,yy,matrix,used) + 1;
                if(res > used[i][j])
                    used[i][j] = res;
            }
        }
        return used[i][j] ;
    }
    private boolean check(int x,int y,int[][] matrix){
        if(x < 0 || y < 0 || x >= matrix.length || y>=matrix[0].length)
            return false;
        return true;
    }
    public static void main(String[] args){  
        HlongestIncreasingPath q = new HlongestIncreasingPath();
        System.out.println(q.longestIncreasingPath(new int[][]{
                {9,9,4},
                {6,6,8},
                {2,1,1}
        }));
    }
}
