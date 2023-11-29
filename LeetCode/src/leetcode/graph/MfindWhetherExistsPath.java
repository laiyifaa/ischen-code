package leetcode.graph;


import java.util.*;

public class MfindWhetherExistsPath {
    //面试题 04.01. 节点间通路
    /*LinkedList<HashSet<Integer>> table;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if(start == target || n == 0)
            return true;
        init(n,graph);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] used = new boolean[n];
        while (!queue.isEmpty()){
            Integer cur = queue.pollFirst();
            used[cur] = true;
            if(cur == target)
                return true;
            for(Integer end : table.get(cur)){
                if(!used[end])
                queue.addLast(end);
            }
        }
        return false;
    }

    private void init(int n, int[][] graph) {
        table = new LinkedList<>();
        for(int i = 0;i < n;++i){
            table.addLast(new HashSet<>());
        }
        for(int[] edge : graph){
            table.get(edge[0]).add(edge[1]);
        }
    }*/

    boolean[] used ;
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        used = new boolean[graph.length];
        return dfs(graph,start,target);

    }

    private boolean dfs(int[][] graph, int start, int target) {
        if(start == target)
            return true;
        int cnt = 0;
        for(int[] vector : graph){
            if(vector[1] == target && !used[cnt]){
                used[cnt] = true;
                boolean ans = dfs(graph,start,vector[0]);
                if(ans)
                    return true;
                used[cnt] = false;
            }
            ++cnt;
        }
        return false;
    }

    public static void main(String[] args){
        MfindWhetherExistsPath q = new MfindWhetherExistsPath();
        q.findWhetherExistsPath(4,
                new int[][]{{2,3},{0,2},{2,0},{1,3}},1,3);
    }

}
