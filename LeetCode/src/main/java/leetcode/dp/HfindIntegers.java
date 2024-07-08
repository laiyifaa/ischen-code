package leetcode.dp;

import java.util.Arrays;

public class HfindIntegers {
    //600. 不含连续1的非负整数
    //数位dp
    char[] s;
    int[][] dp;
    public int findIntegers(int n) {
        if(n < 0 )
            return 0;
        s = Integer.toBinaryString(n).toCharArray();
        dp = new int[s.length][s.length];
        for(int i = 0;i < s.length;++i)
            Arrays.fill(dp[i],-1);
        return dfs(0 ,0,true);
    }

    private int dfs(int index, int preNum, boolean flag) {
        if(index == s.length)
            return 1;
        if(!flag && dp[index][preNum] != -1)
            return dp[index][preNum];
        int res = 0;
        for(int d = 0,max_num = flag ? s[index] - '0':1;d <= max_num;++d){
           if(preNum * d == 0 ){
               res += dfs(index + 1,d,flag && d == s[index] - '0');
           }
        }
        if(!flag)
            dp[index][preNum] = res;
        return res;
    }
    public static void main(String[] args){
        HfindIntegers q = new HfindIntegers();
        System.out.println(q.findIntegers(5));
    }
}
