package hot_100.heap;

import java.util.*;

public class MtopKFrequent {

    public class Barrel{
        Integer num;
        Integer count;

        public Barrel(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }
    }
    //347. 前 K 个高频元素
    //优先队列
    public int[] topKFrequent(int[] nums, int k) {
        if(null == nums || nums.length == 0){
            return  new int[]{};
        }
        int[] ans = new int[k];
        Map<Integer,Integer>  map = new HashMap<>();
       /* PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
*/
        for(int i = 0 ;i < nums.length ;++i){
            int temp = map.getOrDefault(nums[i],0);
            map.put(nums[i],temp + 1);
        }
        Barrel[] barrels = new Barrel[k];
        int cnt = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(cnt < k){
                barrels[cnt++] = new Barrel(num,count);
                if(cnt == k){
                    for(int i = barrels.length / 2 - 1;i >= 0; --i){
                        adjustHeap(barrels,i,barrels.length);
                    }
                }
            }else {
                if(barrels[0].count < count){
                    barrels[0].count = count;
                    barrels[0].num = num;
                    adjustHeap(barrels,0,barrels.length);
                }
            }
            /*
            if(pq.size() < k){
                pq.add(new int[]{count,num});
            }else {
                if(count > pq.peek()[0]){
                    pq.poll();
                    pq.add(new int[]{count,num});
                }
            }*/
        }
        for(int i = 0; i < barrels.length; ++i){
            ans[i] = barrels[i].num;
        }
      /*  while (! pq.isEmpty()){
            ans[cnt++] = pq.poll()[1];
        }*/
        return ans;
    }
    private void  adjustHeap(Barrel[] arr,int i,int len){
        Barrel temp = arr[i];
        for(int j = 2 * i + 1;j < len;j = j * 2 + 1){
            if ( j + 1 < len && arr[j].count > arr[j + 1].count)
                ++j;
            if (arr[j].count < temp.count){
              arr[i] = arr[j];
              i = j;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
    public static void main(String[] args){  
        MtopKFrequent q = new MtopKFrequent();
        int[] ints = q.topKFrequent(new int[]{1,1,1,2,2,3,3,3,3}, 2);
        for(int i = 0;i < ints.length;++i){
            System.out.print(ints[i]+" ");
        }
    }
}
