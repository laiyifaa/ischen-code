package leetcode.array;

import java.util.Arrays;

public class MisValidSudoku {

    //36. 有效的数独
    public boolean isValidSudoku(char[][] board) {
        if(null == board || board.length == 0)
            return false;
        if(board.length != 9 || board[0].length != 9)
            return false;
        int [] usedRow = new int[10];
        int [] usedCol = new int[10];
        int [] used = new int[10];
        boolean ans = true;
        //checkRow && checkCol
        for(int i = 0;i < 9;++i){
            Arrays.fill(usedRow,0);
            Arrays.fill(usedCol,0);
            for(int j = 0;j < 9;++j){
                if(board[i][j] == '.')
                    continue;
                ++usedRow[board[i][j] - '0'];
                if(usedRow[board[i][j] - '0']  > 1){
                    return false;
                }
            }
            for(int j = 0;j < 9;++j){
                if(board[j][i] == '.')
                    continue;
                ++usedCol[board[j][i] - '0'];
                if(usedCol[board[j][i] - '0'] > 1){
                    return false;
                }
            }
        }
        //
        for(int i = 0;i < 9;i+=3){
            for(int j = 0;j < 9;j+=3){
                Arrays.fill(used,0);
                for(int k = 0;k < 3;++k){
                    for(int l = 0;l < 3;++l){
                        if(board[i + k][j + l] == '.' )
                            continue;
                        ++used[board[i + k][j + l] - '0'];
                        if(used[board[i + k][j + l] - '0'] > 1)
                            return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){  
        MisValidSudoku q = new MisValidSudoku();
        System.out.println(q.isValidSudoku(new char[][]{

                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));
    }
}
