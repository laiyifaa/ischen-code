package leetcode.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class McombinationSum_III {

    List<List<Integer>> ans ;
    int[] used;
    int N;
    int K;
    private void dfs(int step,int cnt,int sum){
        if(cnt == K && sum == N){
            List<Integer> list = new ArrayList<>(9);
            for(int i = 1; i < 10;++i){
                if(used[i] == 0)
                    continue;
                list.add(i);
            }
            ans.add(list);
            return;
        }
        if(step > 9 || step < 1)
            return;
        used[step] = 1;
        dfs(step + 1,cnt + 1,sum + step);
        used[step] = 0;
        dfs(step + 1,cnt,sum);
    }
    //216. 组合总和 III
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new LinkedList<>();
        used = new int[10];
        N = n;
        K = k;
        dfs(1,0,0);
        return ans;
    }
    public static void main(String[] args){
        McombinationSum_III q = new McombinationSum_III();
        q.combinationSum3(4,1);
        System.out.println(q.ans);
    }
}
