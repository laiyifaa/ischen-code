package hot_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(null == strs){
            return null;
        }
        List<List<String>> ans = new ArrayList<>(strs.length);
        Map<String,List<String>>  map = new HashMap<>(strs.length);
        for(int i = 0;i<strs.length;i++){
            String temp = strs[i];
            if(map.containsKey(temp)){

            }else {

            }
        }
        return null;
    }
}
