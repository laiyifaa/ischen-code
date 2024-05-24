package leetcode.heap;

import java.util.Arrays;

import java.util.PriorityQueue;

public class HIsChen_findMaximizedCapital {


    //502.IPO
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if(k <= 0 || profits.length == 0 )
            return w;
        int[][] arr = new int[profits.length][2];
        for(int i = 0;i < profits.length;++i){
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr,(a,b) -> a[0]- b[0]);
        int index  = 0 ;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for(int i = 0;i < k ;++i){
            while (index < profits.length && arr[index][0] <= w  ){
                pq.add(arr[index][1]);
                ++index;
            }
            if(!pq.isEmpty()){
                w += pq.poll();
            }else break;;
        }
        return w;
    }

}
