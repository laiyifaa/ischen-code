package leetcode.hash;


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LFUCache {
    //460. LFU 缓存
    int size = 0;
    PriorityQueue<Integer[]> pq; //key value frequency index
    HashMap<Integer,Integer[]>map;
    int index = -1;
    public LFUCache(int capacity) {
        pq = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[2] == o2[2])
                    return o1[3]-o2[3];
                return o1[2]-o2[2];
            }
        });
        map = new HashMap<>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Integer[] element = map.get(key);
            pq.remove(element);
            ++element[2];
            element[3] = ++index;
            pq.add(element);
            return element[1];
        }
        return -1;
    }

    public void put(int key, int value) {
        Integer[] element;
        if(pq.size() < size || (pq.size() == size && map.containsKey(key))){
            if(map.containsKey(key)){
                element = map.get(key);
                pq.remove(element);
                element[1] = value;
                ++element[2];
                element[3] = ++index;
            }else {
                element = new Integer[]{key,value,1,++index};
                map.put(key,element);
            }
            pq.add(element);
        }else {
            element = pq.poll();
            map.remove(element[0]);
            put(key,value);
        }
    }
    public static void main(String[] args){
       /* PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        pq.add(new Integer[]{0,0,1});
        pq.add(new Integer[]{0,1,1});
        pq.add(new Integer[]{0,1,2});
        while (!pq.isEmpty()){
            Integer[] poll = pq.poll();
            for(Integer x : poll){
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }*/
        LFUCache lfu = new LFUCache(3);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        lfu.put(4, 4);
        System.out.println(lfu.get(4));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        lfu.put(5, 5);
        System.out.println(lfu.get(1));      // 返回 -1（未找到）
        System.out.println(lfu.get(2));      // 返回 -1（未找到）
        System.out.println(lfu.get(3));      // 返回 -1（未找到）
        System.out.println(lfu.get(4));      // 返回 -1（未找到）
        System.out.println(lfu.get(5));      // 返回 -1（未找到）
    }
}
