package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class MtrulyMostPopular {
    //面试题 17.07. 婴儿名字
    //并查集 + hash
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();     //并查集， key(子孙)->value(祖宗)
        for(String name : names){
            int indexL = name.indexOf('(');
            int indexR = name.indexOf(')');
            int count = Integer.valueOf(name.substring(indexL + 1,indexR));
            map.put(name.substring(0,indexL),count);
        }
        for(String synonym : synonyms){
            int index = synonym.indexOf(',');
            String name1 = synonym.substring(1,index);
            String name2 = synonym.substring(index + 1,synonym.length() - 1);
            while (unionMap.containsKey(name1)){//找祖宗
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)){//找祖宗
                name2 = unionMap.get(name2);
            }
            if(name1.equals(name2))
                continue;
            int count = map.getOrDefault(name1,0) + map.getOrDefault(name2,0);
            if(name1.compareTo(name2) < 0){
                unionMap.put(name2,name1);
                map.remove(name2);//删不删都没关系吧?
                map.put(name1,count);
            }else {
                unionMap.put(name1,name2);
                map.remove(name1);
                map.put(name2,count);
            }
        }
        String[] ans = new String[map.size()];
        int i = 0;
        for(String name : map.keySet()){
            StringBuilder temp = new StringBuilder(name);
            temp.append('(');
            temp.append(map.get(name));
            temp.append(')');
            ans[i++] = temp.toString();
        }
        return ans;
    }
    public static void main(String[] args){
        MtrulyMostPopular q = new MtrulyMostPopular();
        String[] strings = q.trulyMostPopular(new String[]{
                "John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"
        }, new String[]{
                "(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"
        });
        for(String s : strings)
            System.out.println(s);
    }
}
