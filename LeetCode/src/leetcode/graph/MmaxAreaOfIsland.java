package leetcode.graph;

public class MmaxAreaOfIsland {

    //695 岛屿的最大面积
    int dir[][] = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        if(null == grid || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0;i < m;++i){
            for(int j = 0;j < n;++j){
                if(grid[i][j] == 1){
                    int temp = dfs(i,j,grid);
                    if(temp > ans)
                        ans = temp;
                }
            }
        }
        return ans;
    }
    private int dfs(int x,int y,int [][] grid){
        int value = 1;
        grid[x][y] = 0;
        for(int i = 0;i < 4;++i){
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            if((xx >= grid.length || xx < 0) || (yy >= grid[0].length || yy < 0))
                continue;
            if(grid[xx][yy] == 0)
                continue;
            value += dfs(xx,yy,grid);
        }
        return value;
    }
}
