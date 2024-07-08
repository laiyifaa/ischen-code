package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class MfindOrder {

    //210. 课程表 II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
          int[] ans = new int[numCourses];
          for(int i = 0;i < numCourses;++i){
              ans[i] = i;
          }
          return ans;
        }
        int[][] map = new int[numCourses][numCourses];
        int in[] = new int[numCourses];//入度
        for(int i = 0;i<prerequisites.length;++i){
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            if(start == end)
                return new int[0];
            map[start][end] = 1;
            ++in[end];
        }
        int[] used = new int[numCourses];
        List<Integer> ansList = new ArrayList<>(numCourses + 1);
        while (true){
            boolean flag = false;
            for(int i = 0;i<numCourses;++i){
                if(in[i] == 0 && used[i] == 0){
                    ansList.add(i);
                    flag = true;
                    used[i] = 1;
                    for(int j = 0  ;j < numCourses;++j){
                        if(map[i][j] == 1)
                            --in[j];
                    }
                }
            }
            if(!flag)
                break;
        }
        if(ansList.size() < numCourses)
            return new int[0];
        int[] ans = new int[ansList.size()];
        for(int i = 0;i < ans.length;++i){
            ans[i] = ansList.get(i);
        }
        return ans;
    }
    public static void main(String[] args){
        MfindOrder q = new MfindOrder();
        int[] order = q.findOrder(2, new int[][]{
                {0, 1}
        });
        for(int x : order){
            System.out.println(x);
        }
    }
}
