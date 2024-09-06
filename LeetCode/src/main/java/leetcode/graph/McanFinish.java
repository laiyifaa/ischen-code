package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class McanFinish {

    //207. 课程表
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0)
            return true;
        int[][] map = new int[numCourses][numCourses];
        int in[] = new int[numCourses];//入度
        for(int i = 0;i<prerequisites.length;++i){
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            if(start == end)
                return false;
            map[start][end] = 1;
            ++in[end];
        }
        int cnt = 0;
        int[] used = new int[numCourses];
        while (true){
            boolean flag = false;
            for(int i = 0;i<numCourses;++i){
                if(in[i] == 0 && used[i] == 0){
                    flag = true;
                    used[i] = 1;
                    ++cnt;
                    for(int j = 0  ;j < numCourses;++j){
                        if(map[i][j] == 1)
                            --in[j];
                    }
                }
            }
            if(!flag)
                break;
        }
        return cnt == numCourses?true:false;
    }

    //邻接表
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish_(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    public static void main(String[] args){
        McanFinish q = new McanFinish();
        System.out.println(
                q.canFinish(2,new int[][]{
                        {0,1}
                })
        );
    }
}
