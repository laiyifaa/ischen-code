package hot_100.double_pointer;

import java.util.*;

public class MthreeSum {

    private List<Integer> newList(int a,int b,int c){
        List<Integer> list = new ArrayList<>(3);
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(nums.length-2);
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(i<j && j <k ){
                if (nums[i] + nums[j] + nums[k] == 0){
                    ans.add(newList(nums[i],nums[j],nums[k])) ;
                    while(i+1<nums.length && nums[i] == nums[i+1] )
                        i++;

                    while ( j+1<nums.length  && nums[j]  == nums[j+1] )
                        j++;
                    j++;
                    while( k>0 &&nums[k] == nums[k-1]   )
                        k--;
                    k--;
                  /*  if(nums[j] == nums[k] &&i!=j &&k!=j&& nums[i] + nums[j] + nums[k] == 0){
                        ans.add(newList(nums[i],nums[j],nums[k])) ;
                    }*/
                }
                else if(nums[i] + nums[j] + nums[k] < 0 ){
                    j++;
                }else k--;


            }
        }
        return ans;
    }
    public static void main(String[] args){
        MthreeSum q = new MthreeSum();
        int[] nums = new int[]{
                //0,0,1
           //  0,0,0
                //-1,0,1,2,-1,-4
                //-2,0,0,2,2
                -2,0,1,1,2
        };
        System.out.println(q.threeSum(nums));
    }
}
