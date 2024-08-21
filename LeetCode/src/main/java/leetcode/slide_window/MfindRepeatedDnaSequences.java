package leetcode.slide_window;
import java.util.*;
public class MfindRepeatedDnaSequences {

    //187.重复的DNA序列
    public List<String> findRepeatedDnaSequences(String s) {
        if(null == s ||s.length() <= 10)
            return new LinkedList<>();
        LinkedList<String> ansList = new LinkedList<>();
        int l = 0;
        int r = 0;
        StringBuilder cur = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>(s.length() / 3);
        while (r < s.length()){
            while (r - l + 1 <= 10){
                cur.append(s.charAt(r));
                ++r;
            }
            if(r > s.length() || cur.length() != 10)
                break;
            map.put(cur.toString(),map.getOrDefault(cur.toString(),0) + 1);
            cur.deleteCharAt(0);
            ++l;
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1)
                ansList.add(entry.getKey());
        }
        return ansList;
    }
    public static void main(String[] args){
        MfindRepeatedDnaSequences q  = new MfindRepeatedDnaSequences();
        System.out.println(q.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
