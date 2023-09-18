package leetcode.slide_window;


import java.util.HashSet;
import java.util.Set;

public class MmaxVowels {
    Set<Character> set = new HashSet<>(5);
    //1456. 定长子串中元音的最大数目
    public int maxVowels(String s, int k) {
        if(null == s || s.length() == 0 ||k == 0)
            return 0;
        if(s.length() < k)
            return 0;
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        for(int i = 0;i<k;++i){
            if(set.contains(s.charAt(i))){
                ++ans;
            }
        }
        int temp = ans;
        for(int i = k;i<s.length() ;++i){
            if(set.contains(s.charAt(i - k))){
                --temp;
            }
            if(set.contains(s.charAt(i))){
                ++temp;
            }
            if(temp > ans){
                ans = temp;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        MmaxVowels q = new MmaxVowels();
        System.out.println(q.maxVowels(
                "tryhard",
                4
        ));
    }
}
