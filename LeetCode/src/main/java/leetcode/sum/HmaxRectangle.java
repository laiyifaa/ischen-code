package leetcode.sum;

import java.util.*;


public class HmaxRectangle {
    //面试题 17.25. 单词矩阵
    class Node {
        boolean isWord = false;
        Node[] childrens = new Node[26];
    }
    private void  insert (String word){
        Node cur = root;
        for(int i = 0; i < word.length();++i){
            int  c = word.charAt(i) - 'a';
            if(cur.childrens[c ] == null){
                cur.childrens[c ] = new Node();
            }
            cur = cur.childrens[c ];
        }
        cur.isWord = true;
    }
    Node root;
    TreeMap<Integer, Set<String>> map ;
    List<String> ans;
    int maxArea = 0;
    public String[] maxRectangle(String[] words) {
        if(null == words || words.length == 0)
            return new String[0];
        root = new Node();
        map = new TreeMap<>(((o1, o2) -> o2 - o1));
        maxArea  = 0;
        //init
        for(String w : words){
            int len = w.length();
            Set<String> set = map.getOrDefault(len,new HashSet<>());
            set.add(w);
            map.put(len,set);
            insert(w);
        }
        for(int len : map.keySet()){//单词长度
            Node[] nodes = new Node[len];
            Arrays.fill(nodes,root);
            dfs(map.get(len),new ArrayList<>(),nodes);
        }
        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(Set<String> wordSet, ArrayList<String> curList, Node[] nodes) {
        int len = nodes.length;//单词长度
        if(len * len <= maxArea || curList.size() == len)
            return;
        for(String word : wordSet){
            boolean flag = true;
            int cnt = 0;
            Node[] next = new Node[len];
            for(int j = 0;j < len && cnt == j;++j){
                int c = word.charAt(j) - 'a';
                if(nodes[j].childrens[c] == null)
                    continue;
                ++cnt;
                flag = flag & nodes[j].childrens[c].isWord;
                next[j] = nodes[j].childrens[c];
            }
            if(cnt >= len){
                curList.add(word);
                if(flag && len * curList.size() > maxArea){
                    maxArea = len * curList.size();
                    ans = new ArrayList<>(curList);
                }
                dfs(wordSet,curList,next);
                curList.remove(curList.size() - 1);
            }

        }
    }


    public static void main(String[] args){
        HmaxRectangle q = new HmaxRectangle();
        String[] strings = q.maxRectangle(new String[]{
                "this", "real", "hard", "trh", "hea", "iar", "sld"
        });
        for(String s : strings)
            System.out.println(s);
    }
}
