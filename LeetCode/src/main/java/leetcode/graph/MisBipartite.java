package leetcode.graph;

import java.util.Arrays;


public class MisBipartite {

    //785. 判断二分图
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;
    public boolean isBipartite(int[][] graph) {
        if(null == graph || graph.length == 0)
            return false;
        valid = true;
        color = new int[graph.length];
        Arrays.fill(color,UNCOLORED);
        for(int i = 0;i  < graph.length && valid;++i){
            if(color[i] == UNCOLORED){
                dfs(i,RED,graph);
            }
        }
        return valid;
    }

    private void dfs(int index, int c, int[][] graph) {
        color[index] = c;
        int nextC = c == RED ? GREEN : RED;
        for(int x : graph[index]){
            if(color[x] == UNCOLORED){
                dfs(x,nextC,graph);
                if(valid == false)
                    return;
            }else if(color[x] != nextC){
                valid = false;
                return;
            }
        }
    }


}
