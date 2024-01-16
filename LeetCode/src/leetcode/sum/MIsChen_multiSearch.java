package leetcode.sum;

import java.util.*;

public class MIsChen_multiSearch {
    class Node{
        int id = -1;
        Node[] childrens = new Node[26];
    }
    Node root;
    List<Integer>[] temp;
    //面试题 17.17. 多次搜索
    public int[][] multiSearch(String big, String[] smalls) {
        if(null == smalls || smalls.length == 0)
            return new int[][]{};
        if(null == big || big.length() == 0)
            return new int[smalls.length][0];
        init(smalls);
        int[][] ans ;
        for(int i = 0;i < smalls.length;++i){
           addMap(smalls[i],big,i);
        }
        ans = new int[smalls.length][];
        for(int i = 0;i < smalls.length ;++i){
            List<Integer> list = temp[i];
            ans[i] = new int[list.size()];
            for(int j = 0; j < list.size();++j){
                ans[i][j] = list.get(j);
            }
        }
        return ans;
    }
    private void addMap(String s, String big,int id) {
        char[] chars = big.toCharArray();
        for(int i = 0;i < chars.length;++i){
            Node cur = root;
            for(int j = i;j <  chars.length && j < i + s.length();++j){
                char c = chars[j];
                int index = c - 'a';
                if(cur.childrens[index] == null){
                    break;
                }else cur = cur.childrens[index];
            }
            if(cur.id == id && s.length() > 0){
                temp[id].add(i);
            }
        }
    }
    private void init(String[] smalls) {
        root = new Node();
        temp = new List[smalls.length];
        for(int i = 0; i < smalls.length;++i){
            Node cur = root;
            String s = smalls[i];
            temp[i] = new ArrayList<>();
            for(char c : s.toCharArray()){
                int index = c - 'a';
                if(cur.childrens[index] == null)
                    cur.childrens[index] = new Node();
                cur = cur.childrens[ index];
            }
            cur.id = i;
        }
    }
    public static void main(String[] args){
        MIsChen_multiSearch q = new MIsChen_multiSearch();
        int[][] abcs = q.multiSearch("abc",
                new String[]{
                        ""
                });
        System.out.println(
                abcs
        );
    }
}
