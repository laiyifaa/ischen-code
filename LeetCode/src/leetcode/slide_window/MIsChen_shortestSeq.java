package leetcode.slide_window;

import java.util.HashMap;
import java.util.Map;

public class MIsChen_shortestSeq {
    //面试题 17.18. 最短超串
    // 滑动窗口：l指向窗口左边界，r指向窗口右边界
    Map<Integer,Integer> targetMap ;
    Map<Integer,Integer> tempMap ;

    public int[] shortestSeq(int[] big, int[] small) {
        if(null == big || null == small)
            return new int[0];
        if(big.length == 0 || small.length == 0)
            return new int[0];
        init(small);
        int l = findIndex(big,0);
        int r = l;
        if(l == -1)
            return new int[0];
        int cnt = 0;
        int ansL = 0;
        int ansR = big.length;
        int ansLen = ansR - ansL + 1;
        boolean flag = false;
        while (true){
            if(r >= big.length || r == -1)
                break;
            if(targetMap.containsKey(big[r])){
                tempMap.put(big[r],tempMap.getOrDefault(big[r],0) + 1);
                if(tempMap.get(big[r]) == 1)
                    ++cnt;
                while (cnt == small.length ){
                    if(r - l + 1 < ansLen){
                        ansL = l;
                        ansR = r;
                        ansLen = ansR - ansL + 1;
                        flag =true;
                    }
                    if(targetMap.containsKey(big[l])){
                        Integer value = tempMap.get(big[l]);
                        --value;
                        tempMap.put(big[l],value);
                        if(value == 0)
                            --cnt;
                    }
                    ++l;
                }
            }
            ++r;
        }
        return flag ? new int[]{ansL,ansR} : new int[]{};
    }

    private int findIndex(int[] big,int index) {
        for(int i = index;i < big.length;++i){
            if(targetMap.containsKey(big[i]))
                return i;
        }
        return -1;
    }

    private void init(int[] small) {
        targetMap = new HashMap<>(small.length);
        tempMap = new HashMap<>(small.length);
        for(int i = 0; i < small.length;++i)
            targetMap.put(small[i],targetMap.getOrDefault(small[i],0) + 1);
    }

}
