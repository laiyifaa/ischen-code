package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MfindCheapestPrice {

    //787. K 站中转内最便宜的航班
    //bfs + 标记最小数组实现 k次中转最短路
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(n == 0 || flights.length == 0)
            return 0;
        if(src == dst)
            return 0;
        List<List<Integer[]>> edges = new ArrayList<>(n);
        for(int i = 0;i < n;++i){
            edges.add(new LinkedList<>());
        }
        for(int[] flight : flights){
            edges.get(flight[0]).add(new Integer[]{flight[1],flight[2]});//to,cost
        }
        int[] used = new int[n];
        used[src] = 0;
        Arrays.fill(used,Integer.MAX_VALUE);
        LinkedList<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{src,0,0});//当前点，当前step，当前花费
        //used[src] =  true;
        Integer ans  = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            Integer[] cur = queue.pollFirst();
            if(cur[0] == dst && ans > cur[2])
                    ans = cur[2];
            for(Integer[] edge : edges.get(cur[0])){
                if(cur[2] + edge[1] < used[edge[0]] && cur[1] + 1 <= k + 1){
                    queue.add(new Integer[]{edge[0],cur[1] + 1,cur[2] + edge[1]});
                    used[edge[0]] = cur[2] + edge[1];
                }
            }
        }
        if(ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
    public static void main(String[] args){  
        MfindCheapestPrice q = new MfindCheapestPrice();
        System.out.println(q.findCheapestPrice(
                3,new int[][]{
                        {0,1,2},
                        {1,2,1},
                        {2,0,10}
                },1,2,1
        ));
    }
}
