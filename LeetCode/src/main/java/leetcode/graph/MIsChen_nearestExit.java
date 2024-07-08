package leetcode.graph;

import java.util.LinkedList;

public class MIsChen_nearestExit {
    class node{
        int x;
        int y;
        int step;
        node(int _x,int _y,int _step){
            x = _x;
            y = _y;
            step = _step;
        }
    }
    int[][] dir = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    boolean[][] used;
    private boolean check(char[][] maze,int x,int y){

        if(x < 0 || x >= maze.length || y < 0 || y>=maze[0].length)
            return false;
        if(used[x][y])
            return false;
        if(maze[x][y] == '+')
            return false;
        return true;
    }
    //1926. 迷宫中离入口最近的出口 判断放在里面，
    // 放在外面因为节点交叉出现会超时这个算法没加标记数组
    public int nearestExit(char[][] maze, int[] entrance) {
        if(null == maze || maze.length == 0)
            return -1;
        LinkedList<node> queue = new LinkedList<>();
        int ans = -1;
        queue.addLast(new node(entrance[0],entrance[1],0));

        used = new boolean[maze.length][maze[0].length];
        used[entrance[0]][entrance[1]] = true;
        maze[entrance[0]][entrance[1]] = '+';
        /*while (! queue.isEmpty()){
            node curNode = queue.pollFirst();
            for(int i = 0 ; i < dir.length;++i){
                int xx = curNode.x + dir[i][0];
                int yy = curNode.y + dir[i][1];
                if(check(maze,xx,yy)){
                    if(xx == 0 || xx == maze.length-1 || yy == 0 || yy == maze[0].length-1){
                        if(maze[xx][yy] == '.'){
                            return curNode.step + 1;
                        }
                    }
                    maze[xx][yy] = '+';
                    queue.addLast(new node(xx,yy,curNode.step + 1));
                }
            }
        }*/
        while (! queue.isEmpty()){
            node curNode = queue.pollFirst();
            if(curNode.x == 0 || curNode.x == maze.length-1 || curNode.y == 0 || curNode.y == maze[0].length-1){
                if(  maze[curNode.x][curNode.y] == '.'){
                    ans = curNode.step;
                    break;
                }
            }
            for(int i = 0 ; i < dir.length;++i){
                int xx = curNode.x + dir[i][0];
                int yy = curNode.y + dir[i][1];
                if(check(maze,xx,yy)){
                    used[xx][yy] = true;
                    queue.addLast(new node(xx,yy,curNode.step + 1));
                }
            }
        }
        return ans;
    }

}
