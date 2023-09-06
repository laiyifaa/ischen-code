package hot_100.dp;

import java.util.ArrayList;
import java.util.List;

public class MwordBreak {
    //139. 单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        if(null == s || s.length() == 0)
            return false;
        if(null == wordDict || wordDict.size() == 0)
            return false;
        int[]dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1;i<=s.length();++i){

            for (int j = 0; j < wordDict.size();++j){
                String temp = wordDict.get(j);
                if(i < temp.length())
                    continue;
                if(dp[i - temp.length()] == 1 && check(i - temp.length(),temp,s)){
                    dp[i] = 1;
                }
            }
        }
        return  dp[s.length()] == 1 ? true: false;
    }
    private boolean check(int i,String temp,String s){
        for(int k = i,l = 0;l<temp.length();++k,++l){
            if(s.charAt(k) != temp.charAt(l))
                return false;
        }
        return true;
    }
    public static void main(String[] args){  
        MwordBreak q = new MwordBreak();
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println( q.wordBreak(s,wordDict));
    }
}
