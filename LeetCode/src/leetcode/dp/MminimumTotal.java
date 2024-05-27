package leetcode.dp;

import java.util.List;

public class MminimumTotal {

    //120.三角形最小路径和
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for(int i = 1;i < n; ++i){
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1;j < i;++j){
                f[i][j] = Math.min(f[i - 1][j - 1],f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1 ][i - 1] + triangle.get(i).get(i);
        }
        int ans = f[n - 1][0];
        for(int i = 1;i < n;++i){
            ans = Math.min(ans,f[n - 1][i]);
        }
        return ans;
    }
}
