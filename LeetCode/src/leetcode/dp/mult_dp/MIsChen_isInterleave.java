package leetcode.dp.mult_dp;

public class MIsChen_isInterleave {

    //97交错字符串
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int t = s3.length();
        if(n + m != t)
            return false;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        for(int i = 0;i <= n;++i){
            for(int j = 0;j <= m;++j){
                int p = i + j - 1;
                boolean flag;
                if(i > 0){
                    flag = f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p);
                    f[i][j] = f[i][j] || flag;
                }
                if(j > 0){
                    flag = f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                    f[i][j] = f[i][j] || flag;
                }
            }
        }
        return f[n][m];
    }

}
