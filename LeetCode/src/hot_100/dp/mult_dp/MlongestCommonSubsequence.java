package hot_100.dp.mult_dp;

public class MlongestCommonSubsequence {
    //1143. 最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        if(null == text1 || 0 == text1.length())
            return 0;
        if(null == text2 || 0 == text2.length())
            return 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 1 ;i <= text1.length(); ++i){
            for(int j = 1;j <= text2.length();++j){
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length() ][text2.length() ];
    }
    public static void main(String[] args){
        MlongestCommonSubsequence q = new MlongestCommonSubsequence();
        System.out.println(q.longestCommonSubsequence(
                "bsb",
                "b"
        ));
    }
}
