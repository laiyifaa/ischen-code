package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MshuffleArray {


    int[] nums;
    int[] original;

    //384. 打乱数组
    public MshuffleArray(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        for(int i = 0;i < nums.length;++i){
            original[i] = nums[i];
        }
    }

    public int[] reset() {
        for(int i = 0;i < nums.length;++i){
            nums[i] = original[i];
        }
        return nums;
    }

    public int[] shuffle() {
        Random r = new Random();
        List<Integer> list = new ArrayList<>(nums.length);
        for(int i = 0;i < nums.length;++i){
            list.add(nums[i]);
        }
        for(int i = 0;i < nums.length;++i){
            nums[i] = list.remove(r.nextInt(list.size()));
        }
        return nums;
    }

}
