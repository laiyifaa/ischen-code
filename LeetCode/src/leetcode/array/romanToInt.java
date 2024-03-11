package leetcode.array;


import java.util.LinkedHashMap;
import java.util.Map;

public class romanToInt {

    //13. 罗马数字转整数
    Map<Character,Integer[]> numMap =  new LinkedHashMap<>(7);
    private void init(){
        numMap.put('I',new Integer[]{1,0});
        numMap.put('V',new Integer[]{5,1});
        numMap.put('X',new Integer[]{10,2});
        numMap.put('L',new Integer[]{50,3});
        numMap.put('C',new Integer[]{100,4});
        numMap.put('D',new Integer[]{500,5});
        numMap.put('M',new Integer[]{1000,6});
    }
    public int romanToInt(String s) {
        if(null == s || s.length() == 0)
            return 0;
        init();
        int sum = 0;
        int preNum = 1001;
        int cnt = 0;
        for(int i = 0 ; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c == 'I' ){
               cnt = 1;
               while (i + 1 < s.length() && s.charAt(i + 1)== 'I'){
                   ++cnt;
                   ++i;
               }
            }else {
                cnt = numMap.get(c)[0];
            }
            if(preNum >= cnt)
                sum+=cnt;
            else {
                sum = sum + cnt - preNum * 2;
            }
            preNum = cnt;
        }
        return sum;
    }
    public static void main(String[] args){
        romanToInt q = new romanToInt();
        System.out.println(q.romanToInt("MCMXCIV"));
    }
}
