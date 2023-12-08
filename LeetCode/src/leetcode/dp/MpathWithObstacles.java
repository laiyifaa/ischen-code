package leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MpathWithObstacles {
    class node{
        StringBuilder path;
        int x;
        int y;
        node(int _x,int _y){
            x = _x;
            y = _y;
            path = new StringBuilder();
        }

        public node(int _x, int _y, StringBuilder _path, int dir) {
            x = _x;
            y = _y;
            path = new StringBuilder(_path);
            path.append(dir);
        }
    }
    int r,c;
    node ans = null;
    boolean flag ;
    //面试题 08.02. 迷路的机器人
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if(null == obstacleGrid || obstacleGrid[0][0] == 1)
            return new LinkedList<>(new LinkedList<>());
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        node start = new node(0,0);
        flag = false;
        dfs(start,obstacleGrid);
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
        return getPath(ans);
    }

    private void dfs(node curNode,int[][] obstacleGrid) {
        if(flag)
            return;
        if(curNode.x == r - 1 && curNode.y == c - 1){
            ans = curNode;
            flag = true;
            return;
        }
        if(curNode.y < c - 1 && obstacleGrid[curNode.x][curNode.y + 1] == 0){
            //往右是0
            dfs(new node(curNode.x,curNode.y + 1,curNode.path,0),obstacleGrid);
        }
        if(curNode.x < r - 1 && obstacleGrid[curNode.x + 1][curNode.y] == 0){
            //往下是0
            dfs(new node(curNode.x + 1,curNode.y,curNode.path,1),obstacleGrid);
        }
        if(!flag){
            obstacleGrid[curNode.x][curNode.y] = 1;
        }
    }

    private List<List<Integer>> getPath(node ans) {
        if(ans == null){
            return new LinkedList<>(new LinkedList<>());
        }
        String s = ans.path.toString();
        List<List<Integer>> ansList = new ArrayList<>(s.length() + 1);
        int x = 0;
        int y = 0;
        addAnsList(x,y,ansList);
        for(int i = 0; i < s.length();++i){
            char c = s.charAt(i);
            if(c == '0'){
                ++y;
                addAnsList(x,y,ansList);
            } else if (c == '1') {
                ++x;
                addAnsList(x,y,ansList);
            }
        }
        return ansList;
    }

    private void addAnsList(int x, int y, List<List<Integer>> ansList) {
        List<Integer> list = new ArrayList<>(2);
        list.add(x);
        list.add(y);
        ansList.add(list);
    }
    public static void main(String[] args){
        MpathWithObstacles q = new MpathWithObstacles();
        System.out.println(q.pathWithObstacles(new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,0},
                {0,0,0,0,0}
        }));
    }
}
