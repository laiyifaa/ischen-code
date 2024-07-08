package leetcode.array;

public class MremoveDuplicates {
    //80. 删除有序数组中的重复项 II
    public int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0)
            return 0;
        int cnt;
        int len = nums.length;
        for(int i = 0;i + 1 < len;){
           int l = i; 
           int j = i + 1;
           cnt = 1;
           while (j < len  && nums[l] == nums[j]){
               ++cnt;
               ++j;
           }
           if(cnt > 2){
               for(int k = l + 2,m = j;m < nums.length;++k,++m){
                   nums[k] = nums[m];
               }
               len = len - (cnt - 2);
               i+=2;
               continue;
           }
           i+=cnt;
        }
        return len;
    }
    public static void main(String[] args){  
        MremoveDuplicates q = new MremoveDuplicates();
        int[] a = new int[]{
                1,1
        };
        int k  = q.removeDuplicates(a);
        for(int i = 0; i < k;++i)
            System.out.println(a[i]);
    }
}
