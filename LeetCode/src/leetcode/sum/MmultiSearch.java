package leetcode.sum;

import java.util.*;

public class MmultiSearch {
    class Node{
        String value = "";
        Node[] childrens = new Node[26];
    }
    Node root;
    Map<String, ArrayList<Integer>> map;
    //面试题 17.17. 多次搜索
    public int[][] multiSearch(String big, String[] smalls) {
        if(null == smalls || smalls.length == 0)
            return new int[][]{};
        if(null == big || big.length() == 0)
            return new int[smalls.length][0];
        init(smalls);
        int[][] ans ;
        for(String s : smalls){
           addMap(s,big);
        }
        ans = new int[smalls.length][];
        for(int i = 0;i < smalls.length ;++i){
            String s = smalls[i];
            ArrayList<Integer> list = map.getOrDefault(s,new ArrayList<>());
            ans[i] = new int[list.size()];
            int cnt = 0;
            for(int j = 0; j < list.size();++j){
                ans[i][j] = list.get(j);
            }
        }
        return ans;
    }
    private void addMap(String s, String big) {
        char[] chars = big.toCharArray();
        if(s.length() <= 0)
            return;
        for(int i = 0;i < chars.length;++i){
            Node cur = root;
            for(int j = i;j <  chars.length && j < i + s.length();++j){
                char c = chars[j];
                int index = c - 'a';
                if(cur.childrens[index] == null){
                    break;
                }else cur = cur.childrens[index];
            }
            if(cur.value.equals(s)){
                map.get(s).add(i);
            }
        }
    }
    private void init(String[] smalls) {
        root = new Node();
        map = new HashMap<>();
        for(String s : smalls){
            Node cur = root;
            if(s.length() <= 0)
                continue;
            map.put(s,new ArrayList<>());
            for(char c : s.toCharArray()){
                int index = c - 'a';
                if(cur.childrens[index] == null)
                    cur.childrens[index] = new Node();
                cur = cur.childrens[ index];
            }
            cur.value = s;
        }
    }
    public static void main(String[] args){
        MmultiSearch q = new MmultiSearch();
        int[][] abcs = q.multiSearch("abc",
                new String[]{
                      ""
                });
        System.out.println(1);
    }
}
