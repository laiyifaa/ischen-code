package leetcode.sum;

public class MWordsFrequency {
    //面试题 16.02. 单词频率 字典树/哈希表
    class node{
        node[] children = new node[26];
        int size = 0;
    }
    node root ;
    public MWordsFrequency(String[] book) {
        if(null == book || book.length == 0)
            return;
        root = new node();
        for(String word : book){
            insert(word);
        }
    }

    private void insert(String word) {
        node cur = root;
        for(int i = 0 ; i < word.length();++i){
            int c = word.charAt(i) - 'a';
            if(cur.children[c] == null){
                cur.children[c] = new node();
            }
            cur = cur.children[c];

        }
        ++cur.size;
    }

    public int get(String word) {
        node cur = root;
        for(int i = 0 ;i < word.length();++i){
            int c  = word.charAt(i) - 'a';
            if(cur.children[c] == null)
                return 0;
            cur = cur.children[c];
        }
        return cur.size;
    }
    public static void main(String[] args){  
        MWordsFrequency q = new MWordsFrequency(new String[]{
                "i","have","an","apple","he","have","a","pen"
        });
        System.out.println(q.get("you"));
        System.out.println(q.get("have"));
        System.out.println(q.get("an"));
        System.out.println(q.get("apple"));
        System.out.println(q.get("pen"));
    }
}
