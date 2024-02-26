package leetcode.hash;

import java.util.*;

public class HcomputeSimilarities {

    //面试题 17.26. 稀疏相似度
    //倒排索引
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
            for(int k = 0; k < docs.length;++k){
                if(help[i][k] > 0){
                    ans.add(k + "," + i + ": " + String.format("%.4f",(double)help[i][k]/(docs[i].length + docs[k].length - help[i][k])));
                }
            }
        }
        return  ans;
    }
}
