package leetcode.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MIsChen_pathWithObstacles {
    int r,c;
    boolean flag ;
    //面试题 08.02. 迷路的机器人
    //BFS 不行 DFS行
    //这里用StringBuilder记录路径，也可以用List<List<Integer>> 回溯记录答案
    //还可以逆向找解从终点开始找解
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if(null == obstacleGrid || obstacleGrid[0][0] == 1)
            return new LinkedList<>(new LinkedList<>());
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        flag = false;
        List<List<Integer>> res = new LinkedList<>(new LinkedList<>());
        dfs(0,0,obstacleGrid,res);
        /*LinkedList<node> queue = new LinkedList<>();
        queue.addLast(new node(0,0));
        while (!queue.isEmpty()){
            node curNode = queue.pollFirst();
            if(curNode.x == r - 1 && curNode.y == c - 1){
                ans = curNode;
                break;
            }
            if(curNode.y < c - 1 && obstacleGrid[curNode.x][curNode.y + 1] == 0){
                //往右是0
                queue.addLast(new node(curNode.x,curNode.y + 1,curNode.path,0));
            }
            if(curNode.x < r - 1 && obstacleGrid[curNode.x + 1][curNode.y] == 0){
                //往下是0
                queue.addLast(new node(curNode.x + 1,curNode.y,curNode.path,1));
            }
        }*/
        return res;
    }

    private void dfs(int x,int y,int[][] obstacleGrid,List<List<Integer>> res) {
        if(flag)
            return;
        if(x == r - 1 && y == c - 1){
            res.add(Arrays.asList(x,y));
            flag = true;
            return;
        }
        res.add(Arrays.asList(x,y));
        if(y < c - 1 && obstacleGrid[x][y + 1] == 0){
            //往右是0
            dfs(x,y + 1,obstacleGrid,res);
        }
        if(x < r - 1 && obstacleGrid[x + 1][y] == 0){
            //往下是0
            dfs(x + 1,y,obstacleGrid,res);
        }
        if(!flag){
            res.remove(res.size() - 1);
            obstacleGrid[x][y] = 1;
        }
    }
}
