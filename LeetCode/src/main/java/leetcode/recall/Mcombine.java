package leetcode.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Mcombine {


    boolean[] used;
    private ArrayList<List<Integer>> ansList;
    int K;
    int N;
    //77. 组合
    public List<List<Integer>> combine(int n, int k) {
        if(k > n)
            return new LinkedList<>();
        if(n < 1 || k < 1)
            return new LinkedList<>();
        used = new boolean[n + 1];
        K = k;
        N = n;
        ansList = new ArrayList<>( n * k);
        dfs(1,0);
        return  ansList;
    }

    private void dfs(int index, int cnt) {
        if(cnt == K){
            List<Integer> tempList = new ArrayList<>(K);
            for(int i = 1;i <= N;++i){
                if(used[i])
                    tempList.add(i);
            }
            ansList.add(tempList);
            return;
        }
        if(index > N)
            return;
        if(cnt + N - index + 1 < K)
            return;
        for(int i = index;i <= N;++i){
            if(used[i])
                continue;
            used[i] = true;
            dfs(i + 1,cnt + 1);
            used[i] = false;
        }
    }
    public static void main(String[] args){
        Mcombine q = new Mcombine();
        List<List<Integer>> combine = q.combine(7,3 );
        System.out.println(combine);
    }

}
