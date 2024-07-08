package leetcode.array;


import java.util.LinkedList;

public class Minsert {
    //57. 插入区间
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(null == intervals || intervals.length == 0)
            return newInterval == null ? new int[0][0] : new int[][]{
                    newInterval
            };
        LinkedList<Integer[]> ansList = new LinkedList<>();
        int targetL = newInterval[0];
        int targetR = newInterval[1];
        boolean changeFlag = false;
        if(targetL > intervals[intervals.length - 1][1] ){
            for(int [] cur : intervals)
                ansList.add(new Integer[]{cur[0],cur[1]});
            ansList.add(new Integer[]{targetL,targetR});
        }

        else if(targetR < intervals[0][0]){
            for(int [] cur : intervals)
                ansList.add(new Integer[]{cur[0],cur[1]});
            ansList.addFirst(new Integer[]{targetL,targetR});
        }
        else{
            for(int i = 0;i < intervals.length; ++i){
                int curL = intervals[i][0];
                int curR = intervals[i][1];
                if(i > 0 &&targetL > intervals[i - 1][1] && targetR < intervals[i][0] ){
                    ansList.add(new Integer[]{targetL,targetR});
                }
                if(targetL > curR || targetR < curL){
                    if(changeFlag ){
                        ansList.add(new Integer[]{targetL,targetR});
                        changeFlag = false;
                    }
                    ansList.add(new Integer[]{curL,curR});
                    continue;
                }
                changeFlag = true;
                if(targetL >= curL && targetL <= curR){
                    targetL = Math.min(targetL,curL);
                }
                if(curR >= targetR)
                    targetR = curR;
            }

            if(changeFlag){
                ansList.add(new Integer[]{targetL,targetR});
            }
        }
        int[][] ans = new int[ansList.size()][2];
        int i = 0;
        for(Integer[] array : ansList){
            ans[i][0] = array[0];
            ans[i++][1] = array[1];
        }
        return ans;
    }
    public static void main(String[] args){
        Minsert q = new Minsert();
        q.insert(new int[][]{{
            3,5
        },{12,15}},new int[]{
               6,6
        });
    }
}
