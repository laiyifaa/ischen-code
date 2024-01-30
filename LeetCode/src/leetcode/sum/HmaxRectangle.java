package leetcode.sum;

import java.util.*;
import java.util.stream.Stream;

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
            Node[] nodes = new Node[len];//列
            for(int i = 0;i < len;++i){
                nodes[i] = root;
            }
            List<String> list = new ArrayList<>(map.get(len));//这个长度下的单词集合
            dfs(list,new ArrayList<>(len),nodes);
        }
        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(List<String> list, ArrayList<String> curList, Node[] nodes) {
        int len = nodes.length;//即单词的长度
        if(len * len <= maxArea || curList.size() == len)
            return;
        for(int i = 0;i < list.size(); ++i){//单词列表
            boolean flag = true;
            Node[] next = new Node[nodes.length];
            int cnt = 0;
            for(int j = 0;j < len && cnt == j;++j){//长度
                int c = list.get(i).charAt(j) - 'a';
                if(nodes[j].childrens[c] == null)
                   continue;
                ++cnt;
                if(!nodes[j].childrens[c].isWord)
                    flag = false;
                next[j] = nodes[j].childrens[c];
            }
            if(cnt >= len){
                curList.add(list.get(i));
                if(flag && maxArea < len * curList.size()){
                    maxArea = len * curList.size();
                    ans = new ArrayList<>(curList);
                }
                dfs(list,curList,next);
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
