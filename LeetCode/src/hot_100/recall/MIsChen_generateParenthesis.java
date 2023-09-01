package hot_100.recall;

import java.util.LinkedList;
import java.util.List;

public class MIsChen_generateParenthesis {

    List<String> ans ;
    private Integer maxLen;
    private void dfs(int l,int r,String s){
        if(s.length() == maxLen){
            ans.add(s);
            return;
        }
        if(l < (maxLen>>1)){
            dfs(l + 1,r,s + "(");
        }
        if(r < l && r <(maxLen >> 1)){
            dfs(l,r + 1,s + ")");
        }

    }
    //22. 括号生成
    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<>();
        if(n > 8 || n < 1)
            return ans;
        maxLen = 2 * n;
        dfs(0,0,"");
        return ans;
    }

}
