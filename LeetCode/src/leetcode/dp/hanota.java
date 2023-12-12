package leetcode.dp;

import java.util.List;

public class hanota {
    //面试题 08.06. 汉诺塔问题
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlant(A.size(),A,B,C);
    }
    public void movePlant(int size,List<Integer> start,List<Integer> auxiliary,List<Integer> target){
        //当只剩一个盘子时，直接将它从第一个柱子移动到第三个柱子
        if(size == 1){
            target.add(start.remove(start.size()-1));
            return;
        }
        //首先将 n-1 个盘子，从第一个柱子移动到第二个柱子
        movePlant(size - 1,start,target,auxiliary);
        //然后将最后一个盘子移动到第三个柱子上
        target.add(start.remove(start.size()-1));
        //最后将第二个柱子上的 n-1 个盘子，移动到第三个柱子上
        movePlant(size - 1,auxiliary,start,target);

    }
}
