package leetcode.array;

public class MgameOfLife {

    int n = 0;
    int m = 0;
    //289. 生命游戏
    public void gameOfLife(int[][] board) {
        if(null == board || board.length == 0  || board[0].length == 0)
            return ;
        n = board.length;
        m = board[0].length;
        int[][] ans = new int[n][m]; //10  31
        if(n == 1){
            ans[0][0] = ans[0][m - 1] = 0;
            for(int i = 1;i < m - 1;++i){
                if(board[0][i] == 1)
                    ans[0][i] = board[0][i - 1] + board[0][i + 1] > 1?1:0;
            }

        }
        else if(m == 1){
            for(int i = 1;i < n - 1;++i){
                ans[0][0] = ans[n - 1][0] = 0;
                if(board[i][0] == 1)
                    ans[i][0] = board[i - 1][0] + board[i + 1][0] > 1 ?1:0;
            }
        }else{
            for(int i = 0;i < n;++i){
                for(int j = 0; j < m;++j){
                    ans[i][j] = check(board,i,j);
                }
            }
        }

        for(int i = 0;i < n;++i){
            for(int j = 0;j < m;++j){
                board[i][j] = ans[i][j];
            }
        }
    }

    private int check(int[][] board, int i, int j) {
        int curValue = board[i][j];
        int otherLiveCnt = getOtherLiveCnt(board,i,j);
        if(curValue == 1 ){
            if( otherLiveCnt < 2)
                return 0;
            if( otherLiveCnt > 3)
                return 0;
            return 1;
        }else if(curValue == 0){
            if(otherLiveCnt == 3)
                return 1;
        }
        return 0;
    }

    private int getOtherLiveCnt(int[][] board, int i, int j) {
        if(i == 0 ){
            if(j == 0)
                return board[i][j + 1] + board[i + 1][j] + board[i + 1][ j + 1];
            if(j == m - 1)
                return board[i + 1][j] + board[i ][j - 1] + board[i + 1][j - 1];
            return board[i][j + 1] + board[i + 1][j] + board[i][j - 1] + board[i + 1][ j + 1] + board[i + 1][j - 1];
        }
        if(i == n - 1){
            if(j == 0)
                return board[i][j + 1] + board[i - 1][j] + board[i - 1] [ j + 1 ];
            if(j == m - 1)
                return board[i - 1][j] + board[i][j - 1] + board[i - 1][j - 1];
            return board[i][j + 1] + board[i - 1][j] + board[i][j - 1] + board[i - 1] [ j + 1 ] + board[i - 1][j - 1];
        }
        if(j == 0)
            return board[i - 1][j] + board[i + 1][j] + board[i][j + 1] + board[i - 1][j + 1] + board[i + 1][j + 1];
        if(j == m - 1)
            return board[i - 1][j] + board[i + 1][j] + board[i][j - 1] + board[i - 1][j - 1] + board[i + 1][j - 1];
        return board[i + 1][j] + board[i - 1][j] + board[i][j + 1] + board[i][j - 1]
                + board[i + 1][j + 1] + board[i + 1][j - 1] + board[i - 1][j + 1] + board[i - 1][j - 1];
    }
    public static void main(String[] args){
        MgameOfLife q = new MgameOfLife();
        q.gameOfLife(new int[][]{
                {0}});
    }

}
