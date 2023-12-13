package leetcode.dp;

import java.util.Arrays;

public class MIsChen_countEval {
    //面试题 08.14. 布尔运算
    //区间dp

    char[] ch;
    int[][][] dp;
    public int countEval(String s, int result) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return (s.charAt(0) - '0') == result ? 1 : 0;
        }
        ch = s.toCharArray();
        //定义状态
        dp = new int[ch.length][ch.length][2];
        //base case
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0' || ch[i] == '1') {
                dp[i][i][ch[i] - '0'] = 1;
            }
        }
        // 划分区间
       for(int len = 2;len < ch.length;len += 2){
           //遍历起点
           for(int i = 0; i < ch.length - len;i+=2){
               //终点
               int j = i + len;
               //遍历符号
               for(int k = i + 1;k < j;k += 2){
                   if(ch[k] == '&'){
                       dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0]
                               + dp[i][k - 1][0] * dp[k + 1][j][1]
                               + dp[i][k - 1][1] * dp[k + 1][j][0];
                       dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];
                   }
                   else if(ch[k] == '|'){
                       dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];
                       dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1]
                               + dp[i][k - 1][1] * dp[k + 1][j][0]
                               + dp[i][k - 1][1] * dp[k + 1][j][1];
                   }
                   else if(ch[k] == '^'){
                       dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][1] * dp[k + 1][j][1];
                       dp[i][j][1] += dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0];
                   }
               }
           }
       }
      /* for(int i = 0;i < ch.length;++i){
           for(int j = 0; j < ch.length;++j){
               Arrays.fill(dp[i][j],-1);
           }
       }*/
        return dp[0][ch.length - 1][result];
    }

    private int dfs(int start, int end, int result) {
        if(start == end){
            return ch[start] - '0' == result ? 1 : 0;
        }
        if(dp[start][end][result] != -1)
            return dp[start][end][result];
        int ansCount = 0;
        for(int k = start; k < end;k+=2){
            char op = ch[k + 1];
            for(int i = 0; i <= 1;i++){
                for(int j = 0; j <= 1;j++){
                    if(getResult(i,j,op) == result){
                        ansCount += dfs(start,k,i) * dfs(k + 2,end,j);
                    }
                }
            }
        }
        dp[start][end][result] = ansCount;
        return ansCount;
    }

    private int getResult(int i, int j, char op) {
        switch (op){
            case '&':
                return i & j;
            case '|':
                return i | j;
            case '^':
                return i ^ j;
        }
        return i & j;
    }
    public static void main(String[] args){
        MIsChen_countEval q = new MIsChen_countEval();
        System.out.println( q.countEval("1^0|0|1",0));
    }
}
