package leetcode.child_string;

public class isFlipedString {
    //面试题 01.09. 字符串轮转
   /* public boolean isFlipedString(String s1, String s2) {
        if(s1 == null || s2 == null )
            return true;
        int len1 = s1.length() ;
        int len2 = s2.length() ;
        if(len1 != len2)
            return false;
        if(len1 == 0)
            return true;
        String s3 = s1 + s1;
        boolean ans = false;
        for(int i = 0;i < s3.length() - len1;++i){
            if(ans)
                break;
            for(int j = i,k = 0;j < i + len1;++j,++k){
                if(s3.charAt(j) != s2.charAt(k)){
                    break;
                }
                if(k == len1 - 1)
                    ans = true;
            }
        }
      return ans;
    }*/
   // KMP
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
    public static void main(String[] args){
        isFlipedString q = new isFlipedString();
        System.out.println(
                q.isFlipedString("waterbottle",
                        "erbottlewat")
        );
    }
}
