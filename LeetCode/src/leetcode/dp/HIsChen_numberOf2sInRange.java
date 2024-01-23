package leetcode.dp;

import java.util.Arrays;

public class HIsChen_numberOf2sInRange {
    //面试题 17.06. 2出现的次数
    //数位dp
    char s[];
    int dp[][];
    public int numberOf2sInRange(int n) {
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length][s.length];
        for(int i = 0;i < dp.length;++i)
            Arrays.fill(dp[i],-1);
        return dfs(0,0,true);
    }
    private int dfs(int i,int cnt2,boolean flag){
        if(i == s.length)
            return cnt2;
        if(!flag && dp[i][cnt2] != -1)
            return dp[i][cnt2];
        int res = 0;
        for (int d = 0, max_num = flag ? s[i] - '0' : 9; d <= max_num; ++d){    // 枚举要填入的数字 d
            res += dfs(i + 1,cnt2 + (d == 2 ? 1 : 0) ,flag && d == max_num);
        }
        if(!flag)
            dp[i][cnt2] = res;
        return res;
    }


}
