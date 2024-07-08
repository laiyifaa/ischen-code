package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class McanVisitAllRooms {
    boolean[] used;
    //841. 钥匙和房间
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0)
            return false;
        int n = rooms.size();
        used = new boolean[n ];
        used[0] = true;
        dfs(rooms,0);
        for(int i = 1; i < used.length;++i){
            if(used[i] == false)
                return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms,int index){
        if( index >= rooms.size() )
            return;
        List<Integer> keyList = rooms.get(index);
        if(null != keyList && keyList.size()>0){
            for(int i = 0;i < keyList.size();++i){
                Integer key = keyList.get(i);
                if(used[key])
                    continue;
                used[key] = true;
                dfs(rooms,key);
            }
        }
    }
    public static void main(String[] args){
        McanVisitAllRooms q = new McanVisitAllRooms();
        List<List<Integer>> lists  = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(q.canVisitAllRooms(lists));
    }
}
