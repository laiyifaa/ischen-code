package leetcode.dp;

import java.util.Arrays;

public class HnumDupDigitsAtMostN {
    //1012. 至少有 1 位重复的数字
    char s[];
    int[][] dp;
    public int numDupDigitsAtMostN(int n) {
        if(n < 10)
            return 0;
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length][1 << 10];
        for(int i = 0;i < dp.length;++i){
            Arrays.fill(dp[i],-1);
        }
        return n - dfs(0,true,false,0);
    }
    private int dfs(int index,boolean isLimit,boolean isNum,int mask){
        if(index == s.length){
            return isNum ? 1 : 0;
        }
       if(!isLimit && dp[index][mask] != -1 && isNum){
            return dp[index][mask];
        }
        int res = 0;
        if(!isNum)//1.前面不填数字，那么可以跳过当前数位，也不填数字
            // 2.isLimit 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
            // 3.isNum 仍然为 false，因为没有填任何数字
            res = dfs(index + 1,false,false,mask);
        for(int d = isNum ? 0 : 1 ,max_num = isLimit?s[index] -'0':9;d <= max_num;++d){
            if((mask >> d & 1) == 0)
            res += dfs(index + 1,isLimit && d == s[index] - '0',true,mask | (1<<d));
        }
       if(!isLimit && isNum){
            dp[index][mask] = res;
        }
        return res;
    }
    public static void main(String[] args){
        HnumDupDigitsAtMostN q = new HnumDupDigitsAtMostN();
        System.out.println(q.numDupDigitsAtMostN(1000));
    }
}
