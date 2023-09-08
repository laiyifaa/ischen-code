package hot_100.graph;

import java.util.LinkedList;

public class MorangesRotting {

    class Node{
        int x;
        int y;
        Node(int _x,int _y){
            x = _x;
            y = _y;
        }
    }
    private boolean check(int x,int y,int[][] grid){
        if(x < 0 ||y< 0 ||x >=grid.length || y>=grid[0].length || grid[x][y] == 0 ||grid[x][y] ==2)
            return false;
        return true;
    }
    //994. 腐烂的橘子
    public int orangesRotting(int[][] grid) {
        if(null == grid || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dir = new int[][]{
                {-1,0},
                {1,0},
                {0,1},
                {0,-1}
        };
        LinkedList<Node> queue = new LinkedList<>();
        for(int  i = 0;i < rows; ++i){
            for(int j = 0;j < cols;++j){
                if(grid[i][j] == 2){
                    queue.addLast(new Node(i,j));
                    grid[i][j] = 0;
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count > 0){
                --count;
                Node curNode = queue.pollFirst();
                for(int i = 0;i<4;++i){
                    int X = curNode.x + dir[i][0];
                    int Y = curNode.y + dir[i][1];
                    if(check(X,Y,grid)){
                        queue.addLast(new Node(X,Y));
                        grid[X][Y] = 0;
                    }
                }
            }
            if(queue.size()!=0)
                ans++;
        }
        for(int i = 0;i<rows;++i){
            for(int j = 0;j<cols;++j){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        MorangesRotting q = new MorangesRotting();
        System.out.println(
                q.orangesRotting(new int[][]{
                        {2,2},
                        {1,1,},
                        {0,0},
                        {2,0}
                })
        );
    }
}
