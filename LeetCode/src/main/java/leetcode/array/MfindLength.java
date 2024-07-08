package leetcode.array;

public class MfindLength {
    //718最长重复子数组
    public int findLength(int[] nums1, int[] nums2) {
        if(null == nums1 || null == nums2)
            return 0;
        int[] a = nums1; //短的数组
        int[] b = nums2; //长的数组
        if(nums1.length > nums2.length){
            a = nums2;
            b = nums1;
        }
        int maxLen = 0;
        for(int i = 0;i + maxLen < a.length;++i){
            int x  = a[i];
            for(int j = 0;j + maxLen  < b.length;++j){
                int y = b[j];
                if(x != y)
                    continue;
                int len = 0;
                for(int k = j, l = i;l < a.length && k < b.length;++k,++l){
                    if(a[l] == b[k])
                        ++len;
                    else break;
                }
                if(len > maxLen)
                    maxLen = len;
            }
        }
        return maxLen;
    }
    public int findLengthByDp(int[] nums1, int[] nums2){
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        dp[0][0] =0;
        int res =0;
        for(int i=1;i<nums1.length+1;i++){
            for(int j=1;j<nums2.length+1;j++){
                if(nums1[i-1] ==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                if(dp[i][j] >res) res = dp[i][j];
            }

        }
        return res;
    }
    public static void main(String[] args){
        MfindLength q = new MfindLength();
        System.out.println(q.findLength(new int[]{
                0,1,1,1,0
        },new int[]{
                1,1,1,1,1
        }));
    }

}
