package hot_100.recall;

import java.util.LinkedList;
import java.util.List;

public class Msubsets {

    List<List<Integer>> ans = new LinkedList<>();
    boolean[] used;
    private void dfs(int []nums,int step){
        if(step == nums.length){
            List<Integer> temp = new LinkedList<>();
            for(int i = 0 ; i < nums.length; ++i){
                if(used[i])
                    temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }
        used[step] = true;
        dfs(nums,step + 1);
        used[step] = false;
        dfs(nums,step + 1);
    }
    //78. 子集
    public List<List<Integer>> subsets(int[] nums) {
        if(null == nums || nums.length == 0)
            return ans;
        used = new boolean[nums.length];
        dfs(nums,0);
        return ans;
    }
    public static void main(String[] args){  
        Msubsets q = new Msubsets();
        System.out.println(q.subsets(
                new int[]{
                       0
                }
        ).size());
    }
}
