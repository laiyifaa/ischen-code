package leetcode.sum;

import java.util.ArrayList;
import java.util.List;

public class MsuggestedProducts {
     class Node {
        Node[] children = new Node[26];
        int pIndex = -1 ;
    }
    //1268. 搜索推荐系统
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for(int i = 0 ;i < products.length;++i){
            String word = products[i];
            insert(word,root,i);
        }
        List<List<String>> ans = new ArrayList<>(searchWord.length());
        for(int i = 0;i < searchWord.length();++i){
            String temp = searchWord.substring(0,i + 1);
            List<String> list = getList(temp, root, products);
            ans.add(list);
        }
        return ans;
    }
    private List<String> getList(String word,Node root,String[] products){
         int l = 0;
         List<String> list = new ArrayList<>(3);
         while (l  < word.length()){
             int index = word.charAt(l) - 'a';
             if(null == root.children[index])
                 return list;
             root = root.children[index];
             ++l;
         }
         dfs(root,list,products);
         return list;
    }
    private void dfs(Node root,List<String> list,String[] products){
         if(root.pIndex != -1)
             list.add(products[root.pIndex]);
         for(int i = 0;i < 26; ++i){
             if(list.size() < 3 && null != root.children[i]  ){
                 dfs(root.children[i],list,products);
             }
         }
    }
    private void insert(String word,Node root,int index){
         for(int i = 0;i < word.length();++i){
             int c = word.charAt(i) - 'a';
             if(null == root.children[c]){
                 root.children[c] = new Node();
             }
             root = root.children[c];
         }
         root.pIndex = index;
    }
    public static void main(String[] args){
        MsuggestedProducts  q = new MsuggestedProducts();
        q.suggestedProducts(new String[]{
                "havana"
        },"tatiana");
    }
}
