package leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class generate {

    //118. 杨辉三角
    public List<List<Integer>> generate(int numRows) {
        if(numRows > 30 || numRows < 1)
            return new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for(int i = 1;i <= numRows; ++i){
            List<Integer> temp = new ArrayList<>(i);
            List<Integer> upList = null;
            if(i > 1){
              upList = ans.get(i - 2);
            }
            for(int j = 0; j < i; ++j){
                if(j == 0 || j == i - 1)
                    temp.add(1);
                else {
                    temp.add(upList.get(j) + upList.get(j - 1));
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args){  
        generate q = new generate();
        List<List<Integer>> generate = q.generate(5);
    }
}
