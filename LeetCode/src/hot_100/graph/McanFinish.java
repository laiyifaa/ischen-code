package hot_100.graph;

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
    public static void main(String[] args){
        McanFinish q = new McanFinish();
        System.out.println(
                q.canFinish(2,new int[][]{
                        {0,1}
                })
        );
    }
}
