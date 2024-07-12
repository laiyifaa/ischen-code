package leetcode.array;

public class MgenerateMatrix {

    //59.螺旋矩阵II
    public int[][] generateMatrix(int n) {
        if(n < 1)
            return new int[0][0];
        int[][] ans = new int[n][n];
        int[][] dir = new int[][]{
                {0,1},{1,0},{0,-1},{-1,0}
        };//顺时针
        int index = 0;
        int cnt = 1;
        int curX = 0;
        int curY = 0;
        while (cnt < n*n){
            ans[curX][curY] = cnt++;
            while (true){
                int nextX = curX + dir[index][0];
                int nextY = curY + dir[index][1];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || ans[nextX][nextY] != 0){
                    ++index;
                    index%=4;
                    continue;
                }
                curX = nextX;
                curY = nextY;
                break;
            }
        }
        ans[curX][curY] = cnt++;
        return ans;
    }
    public static void main(String[] args){  
        MgenerateMatrix q = new MgenerateMatrix();
        System.out.println(q.generateMatrix(5));
    }
}
