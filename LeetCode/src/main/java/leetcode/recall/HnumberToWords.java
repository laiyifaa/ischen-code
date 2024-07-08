package leetcode.recall;

import java.util.LinkedList;

public class HnumberToWords {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    // 面试题 16.08. 整数的英语表示
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        StringBuilder ans = new StringBuilder();
        LinkedList<StringBuilder> ansList = new LinkedList<>();
        int tindex = 0;
        while (num > 0){
            int value = num % 1000;
            if(value > 0){
                StringBuilder temp = new StringBuilder();
                solve(temp,value);
                temp.append(thousands[tindex]).append(" ");
                ansList.addFirst(temp);
            }
            num /= 1000;
            ++tindex;
        }
        for(StringBuilder s : ansList){
            ans.append(s);
        }
        return ans.toString().trim();
    }

    private void solve(StringBuilder cur,int value) {
        int temp = value;
        if(0 < temp && temp <= 9)
             cur.append(singles[temp]).append(" ");
        if(9 < temp && temp < 20){
            cur.append(teens[temp - 10]).append(" ");
        }
        if(20 <= temp && temp < 100){
            cur.append(tens[temp / 10]).append(" ");
            solve(cur,value % 10);
        }else if ( temp >= 100) {
            cur.append(singles[temp / 100]).append(" Hundred ");
            solve(cur,temp % 100);
        }
    }
    public static void main(String[] args){  
        HnumberToWords q = new HnumberToWords();
        System.out.println(q.numberToWords(100));
    }
}
