package hot_100.recall;

import java.util.LinkedList;
import java.util.List;

public class Mpartition {
    List<List<String>> ans;
    int[] used;
    int len = 0;
    private void dfs(int step,String s){
        if(step == len - 1){
            List<String> list = getList(s);
            for(String x : list){
                if (!check(x)){
                    return;
                }
            }
            ans.add(list);
            return;
        }
        used[step] = 1;
        dfs(step + 1,s);
        used[step] = 0;
        dfs(step + 1,s);
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
    private List<String>  getList(String s){
        List<String> list = new LinkedList<>();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < used.length - 1; ++i){
            temp.append(s.charAt(i));
            if(used[i] == 1){
                list.add(new String(temp));
                temp = new StringBuilder();
            }
        }
        temp.append(s.charAt(used.length - 1));
        list.add(new String(temp));
        return list;
    }
    //131. 分割回文串
    public List<List<String>> partition(String s) {
        ans = new LinkedList<>();
        if(null == s || s.length() == 0)
            return ans;
        len = s.length();
        used = new int[len];
        dfs(0,s);
        return ans;
    }
    public static void main(String[] args){
        Mpartition q = new Mpartition();
        List<List<String>> list = q.partition("a");
        for(List<String> l : list){
            for(String  x  : l){
                System.out.print(x);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
