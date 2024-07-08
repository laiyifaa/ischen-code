package leetcode.slide_window;

import java.util.LinkedList;

public class MlongestSubarray {
    //1493. 删掉一个元素以后全为 1 的最长子数组
    public int longestSubarray(int[] nums) {
        if(null == nums || nums.length <= 1)
            return 0;
        boolean zeroFlag = false;
        LinkedList<Integer> queue = new LinkedList<>();
        int cnt = 0;
        int ans = 0;
        for(int i = 0;i < nums.length;++i){
            if(nums[i] == 1){
                ++cnt;
            }else {
                zeroFlag = true;
                queue.addLast(cnt);
                cnt = 0;
                if(queue.size() > 1){
                    int p = queue.peekFirst();
                    int q = queue.peekLast();
                    if( p + q > ans){
                        ans = p + q;
                    }
                    queue.pollFirst();
                }
            }
        }
        if(cnt != 0 && queue.size() > 0){
            ans = Math.max(ans,queue.pollFirst() + cnt);
        }
        if(!zeroFlag)
            return nums.length - 1;
        return ans;
    }
    public static void main(String[] args){  
        MlongestSubarray q = new MlongestSubarray();
        System.out.println(q.longestSubarray(new int[]{
                1,1,1
        }));
    }
}
