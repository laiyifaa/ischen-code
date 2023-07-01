package hot_100.array;

import java.util.*;

public class MIsChen_merge {
    //56. 合并区间 自定义排序加双指针
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        LinkedList<int[]> ansList = new LinkedList<>();
        int i = 0;
        int l = intervals[i][0];
        int r = intervals[i][1];
        ++i;
        while (true){
            if(i >= intervals.length){
                addArray(ansList,l,r);
                break;
            }
            if(intervals[i][0] > r){
                addArray(ansList,l,r);
                l = intervals[i][0];
                r = intervals[i][1];
            }else if(intervals[i][0]<= r && intervals[i][1] >r){
                r = intervals[i][1];
            }
            ++i;
        }
        int[][] ans = new int[ansList.size()][2];
        i = 0;
        for(int[] array : ansList){
            ans[i] = array;
            ++i;
        }
        return ans;
    }
    private void addArray(List<int[]> list,int l, int r){
        int [] array = new int[]{l,r};
        list.add(array);
    }

}
