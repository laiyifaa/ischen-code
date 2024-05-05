package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HladderLength {

    class ladder {
        String word;
        Integer step;

        public ladder(String word, Integer step) {
            this.word = word;
            this.step = step;
        }
    }

    //127. 单词接龙
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String,Integer> map = new HashMap<>(wordList.size());
        for(String word : wordList){
            map.put(word,1);
        }
        if(!map.containsKey(endWord))
            return 0;
        LinkedList<ladder> queue = new LinkedList<>();
        queue.addLast(new ladder(beginWord,0));
        if(map.containsKey(beginWord)){
            map.put(beginWord,0);
        }
        int ans = 0;
        boolean flag = false;
        while (!queue.isEmpty()){
            ladder cur = queue.pollFirst();
            if(cur.word.equals(endWord)){
                ans = cur.step;
                flag = true;
                break;
            }
            int newStep = cur.step + 1;
            char[] temp = cur.word.toCharArray();
            for(int i = 0;i < temp.length; ++i ){
                for(int j = 0;j < 26; ++j){
                    char oldChar = temp[i];
                    temp[i] = (char)('a' + j);
                    String newWord = new String(temp);
                    if(map.getOrDefault(newWord,0) > 0){
                        queue.addLast(new ladder(newWord,newStep));
                        map.put(newWord,0);
                    }
                    temp[i] = oldChar;
                }
            }
        }
        return flag ? ans + 1:0 ;
    }
    public static void main(String[] args){  
        HladderLength q = new HladderLength();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");

        wordList.add("dog");

        System.out.println(q.ladderLength("hot","dog",wordList));
    }
}
