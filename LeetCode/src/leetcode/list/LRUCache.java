package leetcode.list;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer,Integer> map ;
    int size = 0;
    public LRUCache(int capacity) {
        map  = new LinkedHashMap(capacity);
        size = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            /*  Iterator<Integer> iterator = map.keySet().iterator();*/
            int v = map.get(key);
            map.remove(key);
            map.put(key,v);
        }
        return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
          /*  Iterator<Integer> iterator = map.keySet().iterator();*/
            map.remove(key);
        }
        map.put(key,value);
        if(map.size()>size){
              Iterator<Integer> iterator = map.keySet().iterator();
              map.remove(iterator.next());
        }
    }
    public static void main(String[] args){
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1); // 缓存是 {1=1}
      System.out.println(  lRUCache.get(1));   // 返回 1

    }
}
