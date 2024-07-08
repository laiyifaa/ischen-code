package leetcode.dp.mult_dp;

public class HminDistance {

    public int minDistance(String word1, String word2) {
        if(null == word1 || null == word2)
            return 0;
        if(word1.length() == 0)
            return word2.length();
        if(word2.length() == 0)
            return word1.length();
        int dp[][] = new  int[word1.length() + 1][ word2.length() + 1];
        for(int i = 1;i<= word1.length();++i){
            dp[i][0] = i ;
        }
        for(int i = 1;i<=word2.length();++i){
            dp[0][i] = i ;
        }
        for (int i = 1;i<= word1.length();++i){
            for(int j = 1;j<= word2.length();++j){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] ;
                }else {
                    // 删除 替换 插入
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i - 1][j - 1] ),dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
