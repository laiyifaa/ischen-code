package leetcode.graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MpondSizes {
    //面试题 16.19. 水域大小
    int[][] dir = new int[][]{
        {1,0}, {-1,0}, {0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}
    };
    int size = 0;
    public int[] pondSizes(int[][] land) {
        if(null == land || land.length == 0 || land[0].length == 0)
            return new int[]{};
        List<Integer> ansList = new LinkedList<>();
        for(int sx = 0 ; sx < land.length;++sx){
            for(int sy = 0; sy < land[0].length; ++ sy){
                if(land[sx][sy] == 0){
                    dfs(sx,sy,land);
                    ansList.add(size);
                    size = 0;
                }
            }
        }
        int[]ans = new int[ansList.size()];
        int k = 0;
        for(Integer x : ansList){
            ans[k++] = x;
        }
        Arrays.sort(ans);
        return ans;
    }

    private void dfs(int sx, int sy, int[][] land) {
        land[sx][sy] = '#';
        ++size;
        for(int i = 0; i < dir.length;++i){
            int tempx = sx + dir[i][0];
            int tempy = sy + dir[i][1];
            if(check(tempx,tempy,land)){
                dfs(tempx,tempy,land );
            }
        }
    }

    private boolean check(int tempx, int tempy, int[][] land) {
        if(tempx < 0 || tempy < 0 || tempx >= land.length || tempy >= land[0].length)
            return false;
        if(land[tempx][tempy] != 0)
            return false;
        return true;
    }
    public static void main(String[] args){
        MpondSizes q = new MpondSizes();
        q.pondSizes(new int[][]{
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        });
    }
}
