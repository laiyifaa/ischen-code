package leetcode.greedy;

public class Mjump {

    //45. 跳跃游戏 II
    public int jump(int[] nums) {
        if(null == nums || nums.length == 0 || nums.length == 1)
            return 0;
        int cnt = 1;
        int i = 0;
        while (true){
            int maxi = i;
            if(nums[i] == 0)
                return cnt;
            if(nums[i] + i >= nums.length - 1)
                break;
            for(int j = i + 1 ; j <= i + nums[i] && j < nums.length; ++j){
                if(nums[j] + j  > nums[maxi] + maxi){
                    maxi = j;
                }
            }
            ++cnt;
            i = maxi;
        }
        return cnt;
    }
    public static void main(String[] args){
        Mjump q = new Mjump();
        System.out.println(q.jump(new int[]{
       1,2
        }));
    }
}
