package leetcode.recall;

import java.util.*;

public class MfindLadders {

    //面试题 17.22. 单词转换
    int[] used ;
    Map<String,Integer> map ;
    class Node{
        String word ;
        Node preNode ;
        Node(String _word,Node _preId){
            word = _word;
            preNode = _preId;
        }
    }
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(null == beginWord || null == endWord)
            return new LinkedList<>();
        init(wordList);
        if(!map.containsKey(endWord))
            return new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(new Node(beginWord,null));
        if(map.containsKey(beginWord))
            used[map.get(beginWord)] = 1;
        int cnt = 0;
        while (!queue.isEmpty()){
            Node curNode = queue.pollFirst();
            String word = curNode.word;
            if(word.equals(endWord)){
                return  solve(beginWord,curNode);
            }
            if(cnt >= map.size())
                continue;
            for(int i = 0;i < word.length();++i){
                StringBuilder temp = new StringBuilder(word.substring(0,i));
                for(char j = 'a'; j <= 'z';++j){
                    temp.append(j);
                    temp.append(word.substring(i+1));
                    String tempWord = temp.toString();
                    Integer index = map.getOrDefault(tempWord,-1);
                    if(index > -1 && used[index] == 0){
                        used[index] = 1;
                        ++cnt;
                        queue.addFirst(new Node(tempWord,curNode));
                    }
                    temp.delete(i,temp.length());
                }
            }
        }
        return new LinkedList<>();
    }

    private List<String> solve(String beginWord, Node curNode) {
        LinkedList<String> ans = new LinkedList<>();
        while (curNode != null){
            ans.addFirst(curNode.word);
            curNode = curNode.preNode;
        }
        return ans;
    }

    private void init(List<String> wordList) {
        map = new HashMap<>(wordList.size());
        int cnt = 0;
        for(String s : wordList){
            map.put(s,cnt);
            ++cnt;
        }
        used = new int[map.size()];
    }

    public static void main(String[] args){
        MfindLadders q = new MfindLadders();
        String[] temp = new String[]{
                "hot","dot","dog","lot","log","cog"
        };
        List<String> list = Arrays.asList(temp);
        List<String> ans = q.findLadders(
                "hit",
                "cog",
                list
        );
        for(String s : ans)
            System.out.println(s);
    }
}
