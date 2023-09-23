package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MIsChen_minReorder {
    List<List<Integer>> graph ;
    private int count ;
    boolean[] used ;
    public int minReorder(int n, int[][] connections) {
        if(n <= 0 || null == connections || connections.length<=1)
            return 0;
        count = 0;
        build(n,connections);
        used = new boolean[n];
        dfs(0);
        return count;
    }
    private void dfs(int index){
        if(!used[index]){
            used[index] = true;
            List<Integer> neighbors = graph.get(index);
            for(Integer neighbor : neighbors){
                if(!used[Math.abs(neighbor)]){
                    if(neighbor > 0)
                        ++count;
                    dfs(Math.abs(neighbor));
                }
            }
        }
    }
    private void build(int n, int[][] connections) {
        graph = new ArrayList<>(n);
        for(int i = 0;i < n;++i){
            graph.add(new LinkedList<>());
        }
        for(int i = 0;i< connections.length;++i){
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
            graph.get(to).add(-1 * from);
        }
    }
}
