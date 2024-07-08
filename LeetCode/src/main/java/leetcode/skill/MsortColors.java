package leetcode.skill;

public class MsortColors {
    private void  swap(int i,int j,int[] nums){
       int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
    //75. 颜色分类 滑动窗口
    public void sortColors(int[] nums) {
        if(null == nums || 0 == nums.length)
            return;
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while (i<=r){
            if(nums[i] == 2){
                swap(i,r,nums);
                --r;
                continue;
            }
            if(nums[i] == 0){
                swap(i,l,nums);
                ++l;
                ++i;
                continue;
            }
            ++i;
        }
    }
    public static void main(String[] args){
        MsortColors q = new MsortColors();
        int[] a = new int[]{2,2};
        q.sortColors(a);
        System.out.println(a);
    }
}
