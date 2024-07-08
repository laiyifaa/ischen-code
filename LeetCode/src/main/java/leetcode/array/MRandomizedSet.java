package leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MRandomizedSet {
    //380. O(1) 时间插入、删除和获取随机元素
    int[] nums = new int[200005];
    int index = 0;
    Map<Integer,Integer> map = new HashMap<>();
    Random random = new Random();
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val,index);
        nums[index++] = val;
        return true;
    }
    // 最后一个元素 与要删的位置换
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int cur = map.remove(val);
        if(cur != index - 1)
            map.put(nums[index - 1],cur);
        nums[cur] = nums[index - 1];
        index--;
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(index )];
    }
    public static void main(String[] args){
        MRandomizedSet q = new MRandomizedSet();
        System.out.println( q.insert(0));
        System.out.println(q.getRandom());
        System.out.println(q.remove(0));
        System.out.println(q.insert(0));
    }
}
