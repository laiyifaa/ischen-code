package leetcode.slide_window;

public class MminSubArrayLen {

    //209. 长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        if(null == nums || nums.length == 0 || target <= 0)
            return 0;
        int l = 0;
        int r = 0;
        int tempSum = 0;
        int ans = 2 * nums.length ;
        while (l <= r){
            if(r >= nums.length)
                break;
            if(tempSum < target){
                tempSum += nums[r++];
            }
            while(tempSum >= target){
                if(r - l < ans){
                    ans = r - l;
                }
                tempSum -= nums[l++];
            }
        }
        if(ans <= nums.length)
            return ans;
        return 0;
    }
    public static void main(String[] args){
        MminSubArrayLen q = new MminSubArrayLen();
        System.out.println(
                q.minSubArrayLen(7,new int[]{
                        2,3,1,2,4,3
                })
        );
    }
}
