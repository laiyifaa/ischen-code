package leetcode.graph;

import java.util.LinkedList;

public class MIsChen_solve {

    int dir[][] = new int[][]{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };
    LinkedList<Integer[]> queue;
    int m;
    int n;
    //130. 被围绕的区域
    public void solve(char[][] board) {
        if(null == board || board.length == 0 || board[0].length == 0)
            return;
        m = board.length;
        n = board[0].length;
        queue = new LinkedList<>();
        for(int i = 0;i < n;++i){
            if(board[0][i] == 'O'){
                queue.addLast(new Integer[]{0,i});
                board[0][i] = 'A';
            }
            if(board[m - 1][i] == 'O'){
                queue.addLast(new Integer[]{m - 1,i});
                board[m - 1][i] = 'A';
            }
        }
        for(int i = 0;i < m;++i){
            if(board[i][0] == 'O'){
                queue.addLast(new Integer[]{i,0});
                board[i][0] = 'A';
            }
            if(board[i][n - 1] == 'O'){
                queue.addLast(new Integer[]{i,n - 1});
                board[i][n - 1] = 'A';
            }
        }
        bfs(board);
        for(int i = 0;i < m;++i){
            for(int j = 0; j < n;++j){
                if(board[i][j] == 'A')
                    board[i][j] = 'O';
                else
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
    private void bfs(char[][] board){
        while (!queue.isEmpty()){
            Integer[] cur = queue.pollFirst();
            board[cur[0]][cur[1]] = 'A';
            for(int k = 0;k < 4;++k){
                int newX = cur[0] + dir[k][0];
                int newY = cur[1] + dir[k][1];
                //没包住
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || board[newX][newY] != 'O'){
                    continue;
                }
                queue.addLast(new Integer[]{newX,newY});
            }
        }
    }
    public static void main(String[] args){
        MIsChen_solve q = new MIsChen_solve();
/*        char[][] a = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };*/

        char[][] a = new char[][]{
                {'X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','X','X'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','X'},{'O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},{'O','O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','X','O','O','X'},{'X','O','O','O','X','O','O','O','O','O','X','O','X','O','X','O','X','O','X','O'},{'O','O','O','O','X','O','O','X','O','O','O','O','O','X','O','O','X','O','O','O'},{'X','O','O','O','X','X','X','O','X','O','O','O','O','X','X','O','X','O','O','O'},{'O','O','O','O','O','X','X','X','X','O','O','O','O','X','O','O','X','O','O','O'},{'X','O','O','O','O','X','O','O','O','O','O','O','X','X','O','O','X','O','O','X'},{'O','O','O','O','O','O','O','O','O','O','X','O','O','X','O','O','O','X','O','X'},{'O','O','O','O','X','O','X','O','O','X','X','O','O','O','O','O','X','O','O','O'},{'X','X','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','X','O','X','O','O','O','X','O','X','O','O','O','X','O','X','O','X','O','O'},{'O','O','X','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','X','O'},{'X','X','O','O','O','O','O','O','O','O','X','O','X','X','O','O','O','X','O','O'},{'O','O','X','O','O','O','O','O','O','O','X','O','O','X','O','X','O','X','O','O'},{'O','O','O','X','O','O','O','O','O','X','X','X','O','O','X','O','O','O','X','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','O','O','X','O','O','O','X','X','O','O','X','O','X','O','X','O','O'}

        };
      /*  char[][] a = new char[][]{
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}

        };*/
        q.solve(a);
        for(int i = 0;i < a.length;++i){
            for(int j = 0;j < a[0].length;++j){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
