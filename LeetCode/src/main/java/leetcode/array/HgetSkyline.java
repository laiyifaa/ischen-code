package leetcode.array;

import java.util.*;

public class HgetSkyline {
    //218. 天际线问题
    //优先队列维护最高
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(null == buildings || buildings.length == 0 ||buildings[0].length != 3)
            return new LinkedList<>();
        LinkedList<List<Integer>> ansList = new LinkedList<>();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        List<Integer> boundaries = new ArrayList<>(buildings.length / 2);
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);
        int idx = 0;
        for (int boundary : boundaries) {
            while (idx < buildings.length && boundary >= buildings[idx][0]){
                pq.add(new Integer[]{buildings[idx][1],buildings[idx][2]});
                idx++;
            }
            while (pq.size() > 0 && pq.peek()[0] <= boundary){
                pq.poll();
            }
            int maxn = pq.isEmpty() ? 0 : pq.peek()[1];
            if(ansList.size() == 0 || maxn != ansList.get(ansList.size() - 1).get(1)){
                ansList.addLast(Arrays.asList(new Integer[]{boundary,maxn}));
            }
        }
        return ansList;
    }

    public static void main(String[] args){  
        HgetSkyline q = new HgetSkyline();
        System.out.println(q.getSkyline(new int[][]{
                {2,9,10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        }));
    }
}
