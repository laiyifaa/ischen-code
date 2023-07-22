package hot_100.recall;

import java.util.ArrayList;
import java.util.List;

public class Mpermute {

    List<List<Integer>> ansList ;
    public List<List<Integer>> permute(int[] nums) {
        ansList = new ArrayList<>(getMult(nums.length));
        dfs(0,nums);
        return ansList;
    }
    private void dfs(int k,int [] nums){
        if(k == nums.length){
            List<Integer> tempList = new ArrayList<>(nums.length);
            for(int i = 0;i<nums.length;++i){
              /*  System.out.print(nums[i]);*/
                tempList.add(nums[i]);
            }
/*            System.out.println();*/
            ansList.add(tempList);
        }
        for(int i = k;i<nums.length;++i){
            swap(i,k,nums);
            dfs(k+1,nums);
            swap(i,k,nums);
        }
    }
    private void swap(int i,int j,int[] nums){
        if(i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int getMult(int x){
        int ans = 1;
        for(int i = 1;i<=x;i++){
            ans*=i;
        }
        return ans;
    }
    public static void main(String[] args){  
        Mpermute p = new Mpermute();
        p.permute(new int[]{1,2,3,4,5});
    }
}
