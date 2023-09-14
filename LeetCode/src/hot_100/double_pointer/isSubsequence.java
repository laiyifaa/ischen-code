package hot_100.double_pointer;

public class isSubsequence {
    //392. 判断子序列
    public boolean isSubsequence(String s, String t) {
        if(s == null ||s.length() == 0)
            return true;
        if(t == null || s.length() > t.length())
            return false;
        if(s.length() == t.length())
            return s == t;
        boolean ans = false;
        for(int i = 0,j = 0;i < t.length();++i){
            if(t.charAt(i) == s.charAt(j)){
                ++j;
            }
            if(j>=s.length()) {
                ans = true;
                break;
            }
        }
        return ans;
    }
}
