package leetcode.slide_window;

public class MlengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if(null == s || 0 == s.length()){
            return 0;
        }
        int ans = 0;
        int l = 0;
        int r = 0;
        byte[] used = new byte[128];
        int temp = 0;
        while (l<=r  ){
            if(r == s.length()){
                break;
            }
            if(used[s.charAt(r) ] == 0){
                used[s.charAt(r)]++;
                temp++;
                r++;
            }else{
                used[s.charAt(l) ]--;
                l++;
                temp--;
            }
            if(temp > ans)
                ans = temp;
        }
        return ans;
    }
    public static void main(String[] args){  
        MlengthOfLongestSubstring q = new MlengthOfLongestSubstring();
        System.out.println(  q.lengthOfLongestSubstring(" "));
    }
}
