package leetcode.recall;

public class  Mpermutation {
    //面试题 08.07. 无重复字符串的排列组合
    String[] ans;
    boolean[] used;
    int cnt ;
    public String[] permutation(String S) {
        ans = new String[getLen(S.length())];
        used = new boolean[S.length()];
        cnt = 0;
        dfs(new StringBuilder(),S);
        return ans;
    }

    private void dfs(StringBuilder temp,String S) {
        if(temp.length()  == S.length()){
            ans[cnt++] = temp.toString();
            return;
        }

        for(int i = 0 ; i < S.length() ;++i){
            if(used[i] == true)
                continue;
            StringBuilder y = new StringBuilder(temp.append(S.charAt(i)));
            used[i] = true;
            dfs(y,S);
            used[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    private int getLen(int length) {
        int x = 1;
        for(int i = 1;i <= length;++i){
            x*=i;
        }
        return x;
    }
    public static void main(String[] args){
        Mpermutation q = new Mpermutation();
        String[] qwes = q.permutation("qwe");
        for(String x : qwes){
            System.out.println(x);
        }
    }
}
