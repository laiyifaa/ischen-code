package leetcode.sum;

public class MWordDictionary {
    class Node{
        boolean isword = false;
        Node[] childrens = new Node[26];
    }
    Node root;
    //211. 添加与搜索单词 - 数据结构设计
    public MWordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return find(cur,0,word);
    }

    private boolean find(Node cur, int i, String word) {
        if(i == word.length() )
            return cur.isword;
        char c = word.charAt(i);
        if(c == '.'){
            boolean flag = false;
            for(int j = 0;j < 26 && !flag;++j){
                if(cur.childrens[ j] == null)
                    continue;
                flag = find(cur.childrens[ j], i + 1,word);
            }
            return flag;
        }else {
            int temp = c - 'a';
            if(cur.childrens[temp] == null)
                return false;
            return find(cur.childrens[temp],i + 1,word);
        }
    }
    public static void main(String[] args){
        MWordDictionary q = new MWordDictionary();
        q.addWord("at");
        q.addWord("and");
        q.addWord("an");
        q.addWord("add");
        System.out.println( q.search("a"));
        System.out.println( q.search(".at"));
        q.addWord("bat");
        System.out.println( q.search(".at"));
        System.out.println( q.search("an."));
        System.out.println( q.search("a.d."));
        System.out.println( q.search("b."));
        System.out.println( q.search("a.d"));
        System.out.println( q.search("."));
    }

}
