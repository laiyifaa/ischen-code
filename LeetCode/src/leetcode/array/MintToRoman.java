package leetcode.array;

import java.util.*;

public class MintToRoman {

    //12. 整数转罗马数字
    Map<Integer,String> map = new LinkedHashMap<>();
    List<Integer> keys;
    private void init(){
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        keys = new ArrayList<>(map.keySet());
    }
    public String intToRoman(int num) {
        if(num <= 0)
            return "";
        init();
        StringBuilder ans = new StringBuilder();
        while (num > 0){
            num  = solve(num,ans);
        }
        return ans.toString();
    }

    private int solve(int num, StringBuilder ans) {
        if(map.containsKey(num)){
            ans.append(map.get(num));
            return 0;
        }else {
            int temp = 1;
            for(int i = keys.size() - 1;i >= 0; --i){
                Integer key = keys.get(i);
                if(num >= key){
                    temp = key;
                    break;
                }
            }
            ans.append(map.get(temp));
            return num - temp;
        }
    }
    public static void main(String[] args){
        MintToRoman q = new MintToRoman();
        System.out.println(
          q.intToRoman(1994)
        );
    }
}
