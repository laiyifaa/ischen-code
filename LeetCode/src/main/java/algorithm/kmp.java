package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kmp {
    //最长公共前后缀长度 a = 0  aa = 1 ababa = 3 abcab = 2



     static char[] s1;
    static char[] s2;
    static int[] next;
    public   static void main(String[] args) {

        s1 = "ssdababafababadf".toCharArray();
        s2 = "abcabcabcabc".toCharArray();
        int m = s2.length;
        int n = s1.length;
        next = new int[m + 1];// 可重复匹配版本 需计算到next[m]  单次匹配可以 new int[m]
        getNext();
        System.out.println(Arrays.toString(next));
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < n){
            if(j == -1 || s1[i] == s2[j]){
                i++;
                j++;
            }else{
                j = next[j];
            }
            if(j == m){// 可重复匹配版本 单次匹配直接break
                res.add(i - j);
                j = next[j];
            }
        }
        for(int re: res)
            System.out.println(re);

    }

    static void getNext(){
        next[0] = -1;
        int m = s2.length;
        int k = -1;
        int j = 0;
        while(j < m){// next[m - 1] 由 next[m - 2] 推出 所以 j < m - 1 // 可重复匹配版本 需计算到next[m] 所以 j < m 单次匹配 j < m - 1
            if(k == -1 || s2[k] == s2[j]){
                ++k;
                ++j;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
    }

}
