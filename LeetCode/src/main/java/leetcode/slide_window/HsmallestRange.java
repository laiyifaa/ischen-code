package leetcode.slide_window;

import java.util.*;

public class HsmallestRange {

    //632. 最小区间
    public int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer,Set<Integer>> map = new TreeMap<>();
        for(int i = 0;i < nums.size();++i){
            List<Integer>curList = nums.get(i);
            for(int j = 0;j < curList.size();++j){
                int num = curList.get(j);
                if(map.containsKey(curList.get(j))){
                    map.get(num).add(i);
                }else {
                    Set<Integer> tempList = new HashSet<>(nums.size());
                    tempList.add(i);
                    map.put(num,tempList);
                }
            }
        }
        int l = 0;
        int r = 10000005;
        int[] used = new int[nums.size()];
        int curL = 10000005;
        int curR = -1 * 10000005;
        List<Integer> numList = new ArrayList<>(map.keySet());
        LinkedList<Integer> windows = new LinkedList();
        for(int i = 0; i < numList.size();++i){
            Integer num = numList.get(i);
            if(num < curL)
                curL = num;
            if(num > curR)
                curR = num;
            Set<Integer> indexList = map.get(num);
            if(indexList.size() == nums.size())
                return new int[]{num,num};
            windows.addLast(i);
            for(Integer x : indexList){
                ++used[x];
            }
            while (check(used)){
                if(curR - curL + 1 < r - l + 1){
                    l = curL;
                    r = curR;
                }
                num = numList.get(windows.pollFirst());
                curL =  numList.get(windows.peekFirst());
                curR =  numList.get(windows.peekLast());

                indexList = map.get(num);
                for(Integer x : indexList){
                    --used[x];
                }
            }


        }
        return new int[]{l,r};
    }
    private boolean check(int[] used) {
        for (int i = 0;i < used.length;++i){
            if(used[i] == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        int[][] array = {
                {4,10,15,24,26},
                {0,9,12,20},
                {5,18,22,30}
        };

        List<List<Integer>> nums = new ArrayList<>();

        for (int[] subArray : array) {
            List<Integer> list = new ArrayList<>();
            for (int num : subArray) {
                list.add(num);
            }
            nums.add(list);
        }

        System.out.println(nums);
        HsmallestRange q = new HsmallestRange();
        int[] ints = q.smallestRange(nums);
        System.out.println(ints[0] + "  " + ints[1]);
    }
}
