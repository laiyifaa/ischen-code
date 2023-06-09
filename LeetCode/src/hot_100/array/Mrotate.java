package hot_100.array;

public class Mrotate {

    /**
     *
     *  swap
     * a = a + b;
       b = a - b;
       a = a - b;
        (仅限整数）
        a = a ^ b;//^异或运算
        b = a ^ b;//
        a = a ^ b;
     */
    //开数组 和 不开数组
    //o(k) 和 o(n)
    public void rotate(int[] nums, int k) {
        if(null == nums || k == 0|| nums.length == 0 )
            return;
        k %= nums.length;
        if(nums.length == k )
            return;
        int[] c = new int[k];
        for(int i = nums.length - k,l = 0;i<nums.length;i++){
            c[l++] = nums[i];
        }
        for(int i = nums.length - k-1;i>=0;i--){
            nums[i+k] = nums[i];
        }
        for(int i = 0;i<k;i++){
            nums[i] = c[i];
        }
        /*reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);*/
    }
    private void reverse(int[] nums,int l ,int r){
        while(l<r){
            nums[l] = nums[l] ^ nums[r];
            nums[r] = nums[l] ^ nums[r];
            nums[l] = nums[l] ^ nums[r];
            l++;
            r--;
        }
    }
    public static void main(String[] args){
        Mrotate q = new Mrotate();
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        //int[] a = new int[]{1,2,3,4,5,6,7};
       // int[] a = new int[]{-1,-100,3,9};
        q.rotate(a,3);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}
