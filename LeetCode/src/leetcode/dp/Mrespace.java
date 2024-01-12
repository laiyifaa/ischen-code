package leetcode.dp;

import java.util.Arrays;

public class Mrespace {
    class Node{
        boolean isWord = false;
        Node[] childrens = new Node[26];
    }
    Node root = new Node();
    //面试题 17.13. 恢复空格
    //dp + trie
    public int respace(String[] dictionary, String sentence) {
        if(null == sentence || sentence.length() == 0)
            return 0;
        if(null == dictionary || dictionary.length == 0)
            return 0;
        int[] dp = new int[sentence.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(String s : dictionary){
            insert(s);
        }
        for (int i = 1; i <= sentence.length(); ++i) {
            dp[i] = dp[i - 1] + 1;

            Node curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.childrens[t] == null) {
                    break;
                } else if (curPos.childrens[t].isWord) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.childrens[t];
            }
        }
        return dp[sentence.length()];

    }

    private void insert(String word) {
        Node cur = root;

        for (int i = word.length() - 1; i >= 0; --i) {
            int t = word.charAt(i) - 'a';
            if (cur.childrens[t] == null) {
                cur.childrens[t] = new Node();
            }
            cur = cur.childrens[t];
        }
        cur.isWord = true;
    }
    public static void main(String[] args){  
        String sentence = "bqqffbqbbfqrfrrrbbrrbfrfqqbbbrbfqfffffrfqfqfffffrrfqfrrqbqfrbfrqqrfrbrbbqbqbqqfqrfbfrfr";
        //sssjjssfshscfjjshsjjsjchffffs
        String[] dictionary = new String[]{
                "frrrbbrrbfrfqqbbbrb","qr","b","rf","qqbbbbfrqbrrqrffbrqqqbqqfqfrr","r","ffqq","bffbqfqqbrrrf","fq","qfr","fr","rqrrbfbfq","r","f","qbqbrbrbqfqbbbfbbbfbq","bqqbbbqrbbrf","f"
        };
        Mrespace q = new Mrespace();
        System.out.println(q.respace(dictionary,sentence));
    }
}
