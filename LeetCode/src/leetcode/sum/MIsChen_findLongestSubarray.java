package leetcode.sum;

import java.util.HashMap;

public class MIsChen_findLongestSubarray {
    //面试题 17.05. 字母与数字
    //要求字母和数字个数相同的最长
    //转换前缀和
    //暴力超时拉 那么加入hash减速吧
    public String[] findLongestSubarray(String[] array) {
        if(null == array || array.length == 0)
            return new String[]{};
        HashMap<Integer,Integer> map = new HashMap<>(array.length);
        int sign = 1;
        int oldTemp = check(array[0]);
        int sum = 1;
        int maxLen = 0;
        int maxL = 0;
        int maxR = 0;
        map.put(0,0);
        map.put(1,1);
        for(int i = 0; i < array.length;++i){
            String s = array[i];
            int temp = check(s);
            if(oldTemp != temp)
                sign = -1 * sign;
           sum = sum + sign;
           if(map.containsKey(sum)){
               Integer firstIndex = map.get(sum);
               if(i - firstIndex + 1 > maxLen){
                   maxLen = i - firstIndex + 1;
                   maxL = firstIndex;
                   maxR = i;
               }
           }else {
               map.put(sum,i + 1);
           }
            oldTemp = temp;
        }
        if(maxLen == 0)
            return new String[]{};
        String[] ans = new String[maxLen];
        for(int i = maxL,cnt = 0;i <= maxR;++i,++cnt){
            ans[cnt] = array[i];
        }
        return ans;
    }
    private int check(String s) {
        if(null == s || s.length() == 0)
            return 0;
        if(s.matches("[a-zA-Z]+"))
            return 1;
        if(s.matches("\\d+"))
            return 2;
        return 0;
    }
    public static void main(String[] args){
        MIsChen_findLongestSubarray q = new MIsChen_findLongestSubarray();
        String[] longestSubarray = q.findLongestSubarray(new String[]{
                "42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"
        });
        for(String s : longestSubarray)
            System.out.println(s);
    }
}
