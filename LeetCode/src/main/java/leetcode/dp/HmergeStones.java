package leetcode.dp;

import java.util.Arrays;

public class HmergeStones {

    //1000. 合并石头的最低成本
    //区间dp
    //dfs(i,j,p) 表示把stones[i]到stones[j]合并成p堆的最小成本
    //dfs(i,j,1) = dfs(i,j,k) + sum [for(int q = i;q <=j;++q)sum+=stones[q])
    //dfs(i,j,p) = min{dfs(i,m,1) + dfs(m + 1,j,p -1 )}   p >=2  m = i + (k - 1)x
    //dfs(i,i,1) = 0 边界
    //dfs(0,n-1,1) 入口
    private int[][][] memo;
    private int[] s;
    private int k;
    public int mergeStones(int[] stones, int k) {
        if((stones.length - 1) % (k - 1) != 0) //每次合并减少k-1,得保证 n-1整除k-1
            return -1;
        s = new int[stones.length + 1];
        for(int i = 0; i < stones.length;++i){
            s[i + 1] = s[i] +stones[i];
        }
        this.k = k;
        memo = new int[stones.length][stones.length][k + 1];
        for(int i = 0;i < stones.length;++i){
            for(int j = 0;j < stones.length;++j){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return dfs(0,stones.length - 1,1);
    }

    private int dfs(int i, int j, int p) {
        if(memo[i][j][p] != -1)
            return memo[i][j][p];
        if(p == 1){
            if(i == j){
                memo[i][j][p] = 0;
                return memo[i][j][p];
            }else {
                memo[i][j][p] = dfs(i,j,k) + s[j + 1] - s[i];
                return memo[i][j][p];
            }
        }
        int res = Integer.MIN_VALUE;
        for(int m = i;m < j; m += k - 1){
            res = Math.max(res,dfs(i,m,1) + dfs(m + 1,j,p - 1));
        }
        memo[i][j][p] = res;
        return memo[i][j][p];
    }
    public static void main(String[] args){
        HmergeStones q = new HmergeStones();
        System.out.println(q.mergeStones(new int[]{
                10,7,2,6,5,11,8
        },4));
    }
}