package leetcode.sum;

import java.util.HashMap;
import java.util.Map;

public class MlongestWord {
    class Node{
        boolean isWord = false;
        Node[] childrens = new Node[26];
    }
    //面试题 17.15. 最长单词
    Node root;
    int used[];
    Map<String,Integer> map;
    public String longestWord(String[] words) {
        if(null == words || words.length == 0)
            return "";
        used = new int[words.length];
       map = new HashMap<>(words.length);
        String ans = "";
        root = new Node();
        for(int i = 0; i < words.length;++i){
            insert(words[i]);
            map.put(words[i],i);
        }
        for(String word : words){
            if(word.length() > ans.length()  && check(word,word.length() )){
               ans = word;
            }else if(word.length() == ans.length() && ans.compareTo(word) > 0 && check(word,word.length())){
                ans = word;
            }
        }
        return ans;
    }

    private boolean check(String word,int index) {
        if(index == 0 && used[map.get(word)] == 0)
            return true;
        Node cur = root;
        boolean flag = false;
        for(int i = index - 1; i >= 0 && !flag; --i){
            char c = word.charAt(i);
            if(cur.childrens[c - 'a'] == null)
                return false;
            else cur = cur.childrens[c - 'a'];
            if(cur.isWord){
                String sub = word.substring(i,index);
                Integer temp = map.get(sub);
                ++used[temp];
                flag = check(word,i);
                --used[temp];
            }
        }
        return flag;
    }

    public void insert(String word) {
        Node cur = root;
        for(int i = word.length() - 1;i >= 0;--i){
            int c = word.charAt(i) - 'a';
            if(cur.childrens[c] == null)
                cur.childrens[c] = new Node();
            cur = cur.childrens[c];
        }
        cur.isWord = true;
    }
    public static void main(String[] args){
        MlongestWord q = new MlongestWord();
        System.out.println(
                q.longestWord(new String[]{
                        "llllcccl","clclll","ccc","llccllccl","lcclccclcl","c"
                })
        );
    }

}
