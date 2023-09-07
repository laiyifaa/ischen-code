package hot_100.slide_window;

import java.util.*;

public class HfindSubstring {
    //30. 串联所有单词的子串
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans  = new LinkedList<>();
        if(null == s || s.length() == 0 || words == null || words.length == 0)
            return ans;
        int wordLen = words[0].length();
        int ansLen = wordLen * words.length;
        if(s.length() < ansLen)
            return ans;
        Map<String,Integer[]> targetMap = new HashMap<>(words.length);
        int l = 0;
        for(int i = 0;i<words.length;++i){
            String word = words[i];
            if(targetMap.containsKey(word)){
                Integer[] value = targetMap.get(word);
                ++value[0];
            }else {
                Integer[] temp = new Integer[]{1,l++};//次数,和字母index
                targetMap.put(word,temp);
            }
        }
        int[] target = new int[targetMap.size()];
        int[] used = new int[targetMap.size()];
        LinkedList<Integer> all = new LinkedList<>();
        for(Map.Entry<String,Integer[]> entry : targetMap.entrySet()){
            Integer[] value = entry.getValue();
            target[value[1]] = value[0];
            all.addLast(value[1]);
        }
        //init
        LinkedList<Integer> windows = new LinkedList<>();
        int cntLen = 0;
        for(int i = 0;i + wordLen <= s.length();){
            String temp = s.substring(i,i + wordLen );
            Integer[] value = targetMap.get(temp);
            if(null == value|| value[1] == null){
                i = 1 + i - windows.size() * wordLen;
                clear(used,windows);
                cntLen = 0;
                continue;
            }else {
                if(cntLen >= ansLen){
                    --used[windows.pollFirst()];
                    cntLen-=wordLen;
                }
                ++used[value[1]];
                windows.addLast(value[1]);
                cntLen+=wordLen;

            }
            if(cntLen >= ansLen  && check(used,target,all)){
                ans.add(i + wordLen - ansLen);
                i  = i + wordLen - ansLen + 1;
                cntLen = 0;
                clear(used,windows);
                continue;
            }
            i += wordLen;
        }
        return ans;
    }
    private boolean check(int[] used,int [] target,LinkedList<Integer> windows){
      for(Integer x : windows){
          if(used[x] != target[x])
              return false;
      }
      return true;
    }
    private void clear(int[] used,LinkedList<Integer> windows){
        for(Integer x : windows){
            used[x] = 0;
        }
        windows.clear();
    }
    public static void main(String[] args){
        HfindSubstring q = new HfindSubstring();
        List<Integer> f = q.findSubstring(
                "ababaab"
                , new String[]{
                        "ab",
                        "ba",
                        "ba"
                }
        );
        for(Integer x : f){
            System.out.println(x);
        }
    }
}
