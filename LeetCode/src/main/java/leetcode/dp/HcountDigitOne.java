package leetcode.dp;

import java.util.Arrays;

public class HcountDigitOne {
    //233. 数字 1 的个数
    //数位DP
    char s[];
    int dp[][];
    public int countDigitOne(int n) {
        if(n<=0)
            return 0;
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length][s.length];
        for(int i = 0; i < dp.length;++i)
            Arrays.fill(dp[i],-1);
        return dfs(0,0,true);
    }

    private int dfs(int i, int cnt, boolean flag) {
        if(i == s.length)
            return cnt;
        if(!flag && dp[i][cnt] != -1)
            return dp[i][cnt];
        int res = 0;
        for(int d = 0,max_num = flag ? s[i] - '0' : 9;d <= max_num;++d){
            res += dfs(i + 1,cnt + (d == 1 ? 1 : 0),flag && d == s[i] - '0');
        }
        if(!flag)
            dp[i][cnt] = res;
        return res;
    }
    public static void main(String[] args){
        HcountDigitOne q = new HcountDigitOne();
        System.out.println(q.countDigitOne(13));
    }
}
