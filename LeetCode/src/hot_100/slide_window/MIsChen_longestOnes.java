package hot_100.slide_window;



public class MIsChen_longestOnes {

    //1004. 最大连续1的个数 III
    public int longestOnes(int[] nums, int k) {
        if(null == nums || nums.length < k)
            return 0;
        int l = 0;
        int r = 0;
        int ans = -1;
        int c = k;
        while (r < nums.length){
            if(nums[r] == 0){
                --c;
            }
            while (c < 0){
                if(nums[l] == 0){
                    ++c;
                }
                ++l;
            }
            int temp = r - l + 1;
            if(temp > ans){
                ans = temp;
            }
            ++r;
        }
        return ans;
    }
    public static void main(String[] args){
        MIsChen_longestOnes q = new MIsChen_longestOnes();
        System.out.println(
                q.longestOnes(
                        new int[]{
                                1,1,1,0,0,0,1,1,1,1,0
                        },2
                )
        );
    }
}
