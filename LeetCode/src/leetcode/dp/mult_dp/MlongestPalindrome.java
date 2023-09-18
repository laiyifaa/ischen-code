package leetcode.dp.mult_dp;

public class MlongestPalindrome {

    int ansLen ;
    int L;
    int R;
    private void fun(int l,int r,String s){
        if(l > r)
            return;
        while ( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            --l;
            ++r;
        }
        if((l < 0 || r>=s.length()) ||s.charAt(l) != s.charAt(r)){
            ++l;
            --r;
        }
        if( (r - l + 1) > ansLen){
            L = l;
            R = r;
            ansLen = (r - l + 1);
        }
        
    }
    //5. 最长回文子串
    public String longestPalindrome(String s) {
        if(null == s || s.length() == 0)
            return "";
        if(s.length() == 1)
            return s;
        ansLen = 0;
        for(int i = 0;i< s.length();++i){
            int r = i;
            while ((r + 1)<s.length() && s.charAt(r) == s.charAt(r + 1)){
                 ++r;
            }
            fun(i,r,s);
        }
        return s.substring(L,R+1);
    }
    public static void main(String[] args){  
        MlongestPalindrome q = new MlongestPalindrome();
        System.out.println(q.longestPalindrome(
                "ac"
        ));

    }
}
