package hot_100.graph;

public class MnumIslands {
    int[][]dir;
    public boolean check(int x,int y,char[][] grid){

        if(x<0||y<0||x>=grid.length||y>=grid[0].length){
            return false;
        }
        if(grid[x][y]=='0'){
            return false;
        }
        return true;
    }
    public void dfs(int x,int y,char[][] grid){


        for(int i = 0;i<dir.length;i++){
            int tx = x+dir[i][0];
            int ty = y+dir[i][1];
            if(check(tx,ty,grid)){
                grid[tx][ty] = '0';
                dfs(tx,ty,grid);
            }
        }
    }
    //200. 岛屿数量
    public int numIslands(char[][] grid) {
        dir = new int[][]{{-1,0},{1,0,},{0,1},{0,-1}};
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    grid[i][j] = '0';
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
}
