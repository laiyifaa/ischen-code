package leetcode.child_string;


public class HminWindow {
    private void fill_p(String x,int l,int r,int[] nums){
        for(int i = l;i<=r;++i){
            ++nums[x.charAt(i)];
        }
    }
    private boolean check(int[] a,int[] b){
        for(int i = 0;i<128;++i){
            if(b[i] == 0)
                continue;
            else if(b[i] > a[i])
                return false;
        }
        return true;
    }
    //76. 最小覆盖子串 思路就是滑动窗口，滑到符合，开始缩小l区间（++l），不符合则扩大区间（++r）
    public String minWindow(String s, String t) {
        if(null == s ||null == t)
            return null;
        String ans = "";
        int m = s.length();
        int n = t.length();
        if(n>m)
            return ans;
        int[] usedT = new int[128];
        int[] usedS = new int[128];
        fill_p(t,0,n-1,usedT);
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;
        int minR = -1;
        while (true){
            if(r>=m )
                break;
            ++usedS[s.charAt(r++)];
            while (check(usedS,usedT)){
                if((r - l +1)<minLen){
                    minLen = r - l +1;
                    minL = l;
                    minR = r;
                }
                --usedS[s.charAt(l++)];
            }
        }
        if(minR>=minL)
            ans =  s.substring(minL,minR);
        return ans;
    }
    public static void main(String[] args){
        HminWindow q = new HminWindow();
        System.out.println(q.minWindow("ADOBECODEBANC","ABC"));
    }
}
