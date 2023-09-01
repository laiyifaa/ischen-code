package hot_100.recall;

import java.util.LinkedList;
import java.util.List;

public class Mpartition {
    List<List<String>> ans ;
    List<String> path = new LinkedList<>();
    private void dfs(int step,String s){
        if(step == s.length()){
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int i = step ; i < s.length(); ++i){
            String temp = s.substring(step, i + 1);
            if(check(temp)){
                path.add(temp);
                dfs(i + 1,s);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean check(String  x){
        if(x.length() == 1 )
            return true;
        int l = 0;
        int r = x.length() - 1;
        while (l < r){
            if(x.charAt(l) != x.charAt(r))
                return false;
            ++l;
            --r;
        }
        return true;
    }
    //131. 分割回文串
    public List<List<String>> partition(String s) {
        ans = new LinkedList<>();
        if(null == s || s.length() == 0)
            return ans;
        dfs(0,s);
        return ans;
    }
    public static void main(String[] args){
        Mpartition q = new Mpartition();
        List<List<String>> list = q.partition("aab");
        for(List<String> l : list){
            for(String  x  : l){
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
