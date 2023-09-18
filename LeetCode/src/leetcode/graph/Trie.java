package leetcode.graph;

public class Trie {
    class Node{
        boolean isword;
        Node[] childrens = new Node[26];
    }
    Node root;
    //208. 实现 Trie (前缀树)
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for(int i = 0;i < word.length();++i){
            int  c = word.charAt(i) - 'a';
            if(cur.childrens[c ] == null){
                cur.childrens[c ] = new Node();
            }
            cur = cur.childrens[c ];
        }
        cur.isword = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for(int i = 0;i < word.length();++i){
            int  c = word.charAt(i) - 'a';
            if(cur.childrens[c ] == null)
                return false;
            cur = cur.childrens[c];
        }
        return cur.isword;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i = 0;i < prefix.length();++i){
            int  c = prefix.charAt(i) - 'a';
            if(cur.childrens[c] == null)
                return false;
            cur = cur.childrens[c];
        }
        return true;
    }
}
