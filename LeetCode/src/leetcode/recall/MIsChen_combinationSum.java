package leetcode.recall;

import java.util.*;

public class MIsChen_combinationSum {

    List<List<Integer>> ans ;
    int[] used;
    private void dfs (int[] candidates, int target,int sum,int index){
        if(sum == target){
            List<Integer> list = new LinkedList<>();
            for(int i = 0;i < candidates.length; ++i){
                for(int j = 0; j < used[i];++j){
                    list.add(candidates[i]);
                }
            }
            ans.add(list);
            return;
        }
        for(int i = index ;i < candidates.length;++i){
            if(sum + candidates[i] > target){
                break;
            }
            ++used[i];
            dfs(candidates,target,sum + candidates[i],i);
            --used[i];
        }
    }
    //39. 组合总和
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new LinkedList<>();
        if(null == candidates ||  candidates.length == 0)
            return ans;
        used = new int[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates,target,0,0);
        return ans;
    }
}

