package leetcode.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mpermute {
    //46 全排列
    //47 全排列II
    List<List<Integer>> ansList ;
    //Map<String,Boolean> map;
    public List<List<Integer>> permute(int[] nums) {
        int mult = getMult(nums.length);
        ansList = new ArrayList<>(mult);
       // map = new HashMap<>(mult);
        dfs(0,nums);
        return ansList;
    }
    private void dfs(int k,int [] nums){
        if(k == nums.length){
            List<Integer> tempList = new ArrayList<>(nums.length);
            for(int i = 0;i<nums.length;++i){
                tempList.add(nums[i]);
            }
 /*           String temp = getTemp(tempList);
            if(!map.containsKey(temp)){
                ansList.add(tempList);
                map.put(temp,true);
            }*/
            ansList.add(tempList);

        }
        for(int i = k;i<nums.length;++i){
            swap(i,k,nums);
            dfs(k+1,nums);
            swap(i,k,nums);
        }
    }

    private String getTemp(List<Integer> tempList) {
        StringBuilder sb = new StringBuilder();
        for(Integer num : tempList){
            sb.append(num);
            sb.append(",");
        }
        return sb.toString();
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
        System.out.println(p.permute(new int[]{1,1,2}));
    }
}
