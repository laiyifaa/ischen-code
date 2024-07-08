package leetcode.greedy;

public class McanJump {

    //55. 跳跃游戏
  /*  public boolean canJump(int[] nums) {
        if(null == nums || nums.length == 0 || nums.length == 1)
            return true;
        for(int i = 0;i < nums.length;){
            int maxi = -1;
            if(nums[i] == 0)
                return false;
            for(int j = i + 1; j <= i+ nums[i];++j){
                if(maxi == -1  || j + nums[j] > maxi + nums[maxi]){
                    maxi = j;
                }
                if(maxi + nums[maxi] >= nums.length - 1)
                    return true;
            }
            i = maxi;
        }
        return true;
    }*/
    public boolean canJump(int[] nums) {
        if(null == nums || nums.length == 0 || nums.length == 1)
            return true;
       int ans = -1;
       for (int i = 0; i < nums.length; ++i){
           ans  = Math.max(ans,nums[i] + i);
           if(ans >= nums.length -1 )
               return true;
           if(ans == i)
               return false;
       }
       return true;
    }
    public static void main(String[] args){  
        McanJump q = new McanJump();
       System.out.println( q.canJump(new int[] {2,0}));
    }
}
