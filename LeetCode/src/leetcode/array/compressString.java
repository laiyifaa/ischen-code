package leetcode.array;

public class compressString {
    //面试题 01.06. 字符串压缩
    public String compressString(String S) {
        if(S == null || "".equals(S))
            return S;
        StringBuilder ans = new StringBuilder();
        int cnt = 1;
        char x = S.charAt(0);
        for(int i = 1;i < S.length();++i){
            char a = S.charAt(i);
            if(a == x)
                ++cnt;
            else {
                ans.append(x);ans.append(cnt);
                cnt = 1;
                x = a;
            }
        }
        if(cnt > 0){
            ans.append(x);ans.append(cnt);
        }
        if(ans.length() < S.length())
        return ans.toString();
        else return S;
    }
    public static void main(String[] args){
        compressString q = new compressString();
        System.out.println(
                q.compressString("abbccd")
        );
    }
}
