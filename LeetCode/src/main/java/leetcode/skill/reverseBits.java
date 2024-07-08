package leetcode.skill;

import java.util.LinkedList;
import java.util.List;

public class reverseBits {
    //面试题 05.03. 翻转数位
    public int reverseBits(int num) {
        if(num == 0)
            return 1;
        int cnt = 0;
        int ans = 0;
        List<Integer> list = new LinkedList<>();

        while (num != 0){
            int temp = num & 1;
            num = num >>> 1;
            if(temp == 1){
                ++cnt;
            }else {
                list.add(cnt);
                cnt = 0;
            }
        }
        if(cnt != 0)
            list.add(cnt);
        int y = 0;
        for(Integer x : list){
            int temp = x + y + 1;
            if(temp > ans)
                ans = temp;
            y = x;
        }

        return Math.min(ans,32);
    }
    public static void main(String[] args){
        reverseBits q = new reverseBits();
        System.out.println(q.reverseBits(-1));
    }
}
