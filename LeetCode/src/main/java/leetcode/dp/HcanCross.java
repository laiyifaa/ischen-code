package leetcode.dp;

import java.util.Arrays;

public class HcanCross {

    //403. 青蛙过河
    public boolean canCross(int[] stones) {
        if(stones.length < 2)
            return false;
        if(stones[0] == 0 && stones[1] == 1){
            Boolean[][] used = new Boolean[stones.length][stones.length];
            return dfs(stones,used,1,1);
        }
        return false;
    }

    private boolean dfs(int[] stones, Boolean[][] used, int cur, int step) {
        if(cur == stones.length - 1)
            return true;
        if(used[cur][step] != null)
            return used[cur][step];
        for(int curStep = step - 1;curStep <= step + 1 ;++curStep){
            if(curStep > 0){
                int j = Arrays.binarySearch(stones,cur + 1,stones.length,stones[cur] + curStep);
                if(j >= 0 && dfs(stones,used,j,curStep)){
                    used[j][curStep] = true;
                    return used[j][curStep];
                }
            }
        }
        used[cur][step] = false;
        return used[cur][step];
    }
    public static void main(String[] args){  
        HcanCross q = new HcanCross();
        System.out.println(q.canCross(new int[]{
                0,1,3,5,6,8,12,17
        }));
    }
}
