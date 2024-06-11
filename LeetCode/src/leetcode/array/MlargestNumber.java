package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class MlargestNumber {

    //179. 最大数
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0;i < nums.length;++i){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String x = o1 + o2;
                String y = o2 + o1;
                return Integer.valueOf(x).compareTo(Integer.valueOf(y));
            }
        });
        if(strs[0] .equals("0") )
            return "0";
        StringBuilder res = new StringBuilder();
        for(String str :strs){
            res.append(str);
        }
        return res.toString();
    }
}
