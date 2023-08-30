package hot_100.skill;

public class MIsChen_nextPermutation {
    private void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums,int start){
        for(int i = start,j = nums.length -1; i < j;++i,--j){
            swap(nums,i,j);
        }
    }
    //31. 下一个排列
    public void nextPermutation(int[] nums) {
        if(null == nums || nums.length == 0 || nums.length == 1)
            return;
        int index = nums.length - 2;
        //从后往前找 第一个相邻升序
        while (index >= 0 && nums[index] >= nums[index + 1]){
            --index;
        }
        if(index >= 0 ){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[index])
                --j;
            swap(nums,index,j);
        }
        reverse(nums,index + 1);
    }
    public static void main(String[] args){
        MIsChen_nextPermutation q = new MIsChen_nextPermutation();
        q.nextPermutation(new int[]{1,2,3,4,6,5});
        q.nextPermutation(new int[]{1,7,9,2,4,5,6});
        System.out.println();
    }
}
