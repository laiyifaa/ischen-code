package leetcode.array;

public class HmissingTwo {

    //面试题 17.19. 消失的两个数字
    public int[] missingTwo(int[] nums) {
        if(null == nums || nums.length == 0)
            return new int[]{};
        int n = nums.length + 2;
        int[] used = new int[n + 1];
        for(int i = 0;i < nums.length;++i){
            used[nums[i]] = 1;
        }
        int[] ans = new int[2];
        int k = 0;
        for(int i = 1;i <= n && k<2;++i){
            if(used[i] == 0)
                ans[k++] = i;
        }
        return ans;
    }
    public static void main(String[] args){  

    }
}
