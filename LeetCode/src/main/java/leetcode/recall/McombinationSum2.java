package leetcode.recall;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class McombinationSum2 {
    List<List<Integer>> ans ;
    boolean[] used;
    //40. 组合总和II
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new LinkedList<>();
        if(null == candidates ||  candidates.length == 0)
            return ans;
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        dfs(candidates,target,0,0);
        return ans;
    }

    private void dfs (int[] candidates, int target,int sum,int index){
        if(sum == target){
            List<Integer> list = new LinkedList<>();
            for(int i = 0;i < candidates.length; ++i){
                if(used[i])
                    list.add(candidates[i]);
            }
            ans.add(list);
            return;
        }
        int oldNum = -1;
        for(int i = index ;i < candidates.length;++i){
            if(sum + candidates[i] > target){
                break;
            }
            if(oldNum == candidates[i])
                continue;
            used[i] = true;
            dfs(candidates,target,sum + candidates[i],i + 1);
            used[i] = false;
            oldNum = candidates[i];
        }
    }
    public static void main(String[] args){
        McombinationSum2 q = new McombinationSum2();
        System.out.println(q.combinationSum2(new int[]{
                10,1,2,7,6,1,5
        },8));

    }
}
