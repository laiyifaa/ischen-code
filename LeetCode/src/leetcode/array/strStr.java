package leetcode.array;

public class strStr {

    //28. 找出字符串中第一个匹配项的下标
    public int strStr(String haystack, String needle) {
        if(null == haystack || needle == null)
            return -1;
        if(haystack.length() < needle.length())
            return -1;
        int ans = -1;
        for(int i = 0;i < haystack.length();++i){
            int cnt = 0;
            for(int j = i,k = 0;j < haystack.length() && k < needle.length();++j,++k){
                if(haystack.charAt(j) != needle.charAt(k))
                    break;
                else ++cnt;
            }
            if(cnt == needle.length()){
                ans = i;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        strStr q = new strStr();
        System.out.println(q.strStr("hello","ll"));
    }
}
