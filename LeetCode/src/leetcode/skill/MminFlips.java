package leetcode.skill;

import java.util.LinkedList;
import java.util.List;

public class MminFlips {
    //1318. 或运算的最小翻转次数
    public int minFlips(int a, int b, int c) {
        LinkedList<Integer> aList = getList(a);
        LinkedList<Integer> bList = getList(b);
        LinkedList<Integer> cList = getList(c);
        int maxLen = Math.max(aList.size(),Math.max(bList.size(),cList.size()));
        while (aList.size() < maxLen)
            aList.addFirst(0);
        while (bList.size() < maxLen)
            bList.addFirst(0);
        while (cList.size() < maxLen)
            cList.addFirst(0);
        int ans = 0;
        for(int i = 0 ; i < maxLen ;++i){
            int _a = aList.pollFirst();
            int _b = bList.pollFirst();
            int _c = cList.pollFirst();
            int temp = _a + _b;
            if(_c == 0){
                ans += (temp);
            }else if(temp == 0){
                ++ans;
            }
        }
        return ans;
    }
    private LinkedList<Integer> getList(int x){
        LinkedList<Integer> list = new LinkedList<>();
        while (x > 0){
            list.addFirst(x%2);
            x/=2;
        }
        return list;
    }
}
