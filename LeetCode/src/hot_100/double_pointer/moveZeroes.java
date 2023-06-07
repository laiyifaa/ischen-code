package hot_100.double_pointer;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int k = 0;//几个0
        int i = 0;
        while(true){
            if(i+k>=nums.length){
                break;
            }
            while (i+k<nums.length && nums[i+k] == 0 ){
                k++;
            }
            if(i+k>=nums.length){
                break;
            }
            nums[i] = nums[i+k];
            i++;
        }
        for(int j = k;j>0;j--){
            nums[nums.length-j] = 0;
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{0};
        moveZeroes q = new moveZeroes();
        q.moveZeroes(nums);
        for(int i= 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
