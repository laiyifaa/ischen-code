package leetcode.array;

import java.util.LinkedList;
import java.util.List;

public class summaryRanges {

    //228. 汇总区间
    public List<String> summaryRanges(int[] nums) {
        if(null == nums || nums.length == 0)
            return new LinkedList<>();
        List<String> ans = new LinkedList<>();
        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;
        boolean flag = false;
        for(int x : nums){
            if(!flag){
                l = x;
                r = x;
                flag = true;
                continue;
            }else {
                if(x == r + 1){
                    ++r;
                    continue;
                }else {
                    if(l == r){
                        ans.add(String.valueOf(l));
                    }else{
                        ans.add(l + "->" + r);
                    }
                    l = r = x;
                }
            }
        }
        if(l == r){
            ans.add(String.valueOf(l));
        }else{
            ans.add(l + "->" + r);
        }
        return ans;
    }
    public static void main(String[] args){
        summaryRanges q = new summaryRanges();
        System.out.println(q.summaryRanges(new int[]{
                -2147483648,-2147483647,2147483647
        }));
    }
}
