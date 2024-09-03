package leetcode.recall;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class McanMeasureWater {

    //烧水壶
    public boolean canMeasureWater(int x, int y, int target) {
        LinkedList<Integer[]> queue = new LinkedList<>();
        queue.addLast(new Integer[]{0,0});
        Map<Integer,Boolean> map = new HashMap<>();
        while (!queue.isEmpty()){
            Integer[] cur = queue.pollFirst();
            int hash = cur[0] * 1000000 + cur[1];
            if(map.containsKey(hash))
                continue;
            map.put(hash,true);
            if(cur[0] + cur[1] == target)
                return true;
            queue.addLast(new Integer[]{x,cur[1]});
            queue.addLast(new Integer[]{cur[0],y});
            queue.addLast(new Integer[]{cur[0],0});
            queue.addLast(new Integer[]{0,cur[1]});
            int xx = Math.min(x - cur[0],cur[1]);
            int yy = Math.min(y - cur[1],cur[0]);
            queue.addLast(new Integer[]{cur[0] + xx,cur[1] - xx});
            queue.addLast(new Integer[]{cur[0] - yy,cur[1] + yy});
        }
        return false;
    }
    public static void main(String[] args){  
        McanMeasureWater q = new McanMeasureWater();
        System.out.println(q.canMeasureWater(1,2,3));
    }
}
