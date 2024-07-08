package leetcode.sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class HfindWords {


    class Node {
        boolean isWord = false;
        Node[] childrens = new Node[26];
        int index = -1;
    }
    Node root;
    int dir[][] = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };
    HashSet<String> set;
    //212.单词搜索 II
    public List<String> findWords(char[][] board, String[] words) {
        if(null == board || board.length == 0 || board[0].length == 0)
            return new LinkedList<>();
        if(null == words || words.length == 0)
            return new LinkedList<>();
        init(words);
        for(int i = 0;i < board.length;++i){
            for(int j = 0;j < board[0].length;++j){
                Node cur = root.childrens[board[i][j] - 'a' ];
                if(cur == null)
                    continue;
                dfs(i,j,board,cur,words);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(int x, int y, char[][] board, Node root,String[] words) {
        if(root.isWord == true){
            set.add(words[root.index]);
        }
        char temp = board[x][y];
        board[x][y] = '#';
        for(int i = 0;i < dir.length;++i){
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            if((xx >= board.length || xx < 0) || (yy >= board[0].length || yy < 0))
                continue;
            if(board[xx][yy] == '#')
                continue;
            Node next = root.childrens[board[xx][yy] - 'a'];
            if(next == null)
                continue;
            dfs(xx,yy,board,next,words);
        }
        board[x][y] = temp;
    }

    private void init(String[] words) {
        root = new Node();
        set = new HashSet<>(words.length);
        for(int i = 0;i < words.length;++i){
            String word = words[i];
            Node cur = root;
            for(int j = 0;j < word.length();++j){
                int c = word.charAt(j) - 'a';
                if(cur.childrens[c] == null){
                    cur.childrens[c] = new Node();
                }
                cur = cur.childrens[c];
            }
            cur.index = i;
            cur.isWord = true;
        }
    }
    public static void main(String[] args){
        HfindWords q = new HfindWords();

        List<String> words = q.findWords(new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}

        },new String[]{"oath","pea","eat","rain"});
    }
}
