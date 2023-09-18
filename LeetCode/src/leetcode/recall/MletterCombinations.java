package leetcode.recall;

import java.util.LinkedList;
import java.util.List;

public class MletterCombinations {


    String[] phone = new String[]{
            null,
            null,
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> ans ;
    private void  dfs(String digits,StringBuilder temp){
        if(temp.length() == digits.length()){
            ans.add(new String(temp));
            return;
        }
        char c = digits.charAt(temp.length());
        String number = phone[ c - '0'];
        for(int i = 0; i < number.length();++i){
            dfs(digits,temp.append(number.charAt(i)));
            temp.deleteCharAt(temp.length() - 1);
        }

    }
    //17. 电话号码的字母组合 dfs 
    public List<String> letterCombinations(String digits) {
       ans = new LinkedList<>();
        if(null == digits || digits.length() == 0)
            return ans;
        dfs(digits,new StringBuilder());
        return ans;
    }
    public static void main(String[] args){  
        MletterCombinations q = new MletterCombinations();
        List<String> ans = q.letterCombinations("23");
        for(String s : ans){
            System.out.println(s);
        }
    }
}
