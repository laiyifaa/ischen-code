package leetcode.hash;

import java.util.*;

public class HcomputeSimilarities {

    //面试题 17.26. 稀疏相似度
    //倒排索引 : 思维转变一下，不是把两个数组比较，看有没有重复的。而是每次的数字出现，都去检查一下是否出现过，在哪个数组里出现的
    //小数点保留4位处理
    public List<String> computeSimilarities(int[][] docs) {
        if(null == docs || docs[0].length == 0)
            return new LinkedList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[][] help = new int[docs.length][docs.length];
        List<String> ans = new ArrayList<>();
        for(int i = 0; i  < docs.length;++i){
            int[] temp = docs[i];
            for(int j = 0; j < temp.length;++j){
                int var = temp[j];
                List<Integer> list = map.get(var);
                if(null == list){
                    list = new ArrayList<>();
                    map.put(var,list);
                }else{
                    for(Integer k : list){
                        help[i][k]++;
                    }
                }
                list.add(i);
            }

        }
        for(int  i = 0;i < docs.length;++i){
            for(int j = 0; j <docs.length;++j){
                if(help[i][j] > 0)
                    ans.add(j + "," + i + ": " + String.format("%.4f",(double)help[i][j]/(docs[i].length + docs[j].length - help[i][j])));
            }
        }
        return  ans;
    }
}
