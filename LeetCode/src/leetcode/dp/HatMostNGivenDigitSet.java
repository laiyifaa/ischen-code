package leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;

public class HatMostNGivenDigitSet {
    char[] s;
    int [][] dp;
    HashSet<Integer> set;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        //902. 最大为 N 的数字组合
        s = Integer.toString(n).toCharArray();
        dp = new int[s.length][s.length];
        for(int i = 0;i < s.length;++i)
            Arrays.fill(dp[i],-1);
        set = new HashSet<>(digits.length);
        for(String digit : digits){
            set.add(Integer.parseInt(digit));
        }
        return dfs(0,0,true);
    }

    private int dfs(int index, int cnt, boolean flag) {
        if(index + cnt  == s.length){
            return 1;
        }
        if(!flag && dp[index][cnt] != -1)
            return dp[index][cnt];
        int res = 0;
        for(int d = 0,max_num = flag ? s[index + cnt] - '0':9;d <= max_num;++d){
            if(set.contains(d))
                res += dfs(index + 1,cnt,flag && s[index + cnt] - '0' == d);
        }
        if(index == 0 && cnt != s.length - 1)
            res+= dfs(index ,cnt + 1,false);
        if(!flag)
            dp[index][cnt] = res;
        return res;
    }


    public static void main(String[] args){
        HatMostNGivenDigitSet q = new HatMostNGivenDigitSet();
        System.out.println(q.atMostNGivenDigitSet(new String[]{
                "1","4","9"
        },1000000000));
    }
}
