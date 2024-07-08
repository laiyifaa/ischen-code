package leetcode.martix;

public class Mtictactoe {
    //面试题 16.04. 井字游戏
    char[][] boardChars ;
    public String tictactoe(String[] board) {
        if(null == board || board.length == 0)
            return "Draw";
        //init
        boardChars = new char[board.length][board.length];
        for(int i = 0; i < board.length;++i){
            String row = board[i];
            boardChars[i] = row.toCharArray();
        }
        String ans = checkWin();
        if(ans.length() == 0){
            ans = checkBlank();
            if(ans.length()  > 0)
                return ans;
            return "Draw";
        }
        return ans;
    }
    private String checkBlank(){
        for(int i = 0; i < boardChars.length;++i){
            for(int j = 0;j < boardChars.length;++j){
                if(boardChars[i][j] == ' ')
                    return "Pending";
            }
        }
        return "";
    }
    private String checkWin(){
        String ans = checkCol();
        if(ans.length() > 0)
            return ans;
        ans = checkRow();
        if(ans.length() > 0)
            return ans;
        ans  = checkDiag();
        if(ans.length() > 0)
            return ans;
        return "";
    }

    private String checkDiag() {
        int sum = 0;
        for(int i = 0;i < boardChars.length;++i){
            if(boardChars[i][i] == 'X')
                ++sum;
            else if(boardChars[i][i] == 'O')
                --sum;
            if(sum == boardChars[i].length )
                return "X";
            if(sum == boardChars[i].length * -1)
                return "O";
        }
        sum = 0;
        for(int i = 0,j = boardChars.length - 1;i < boardChars.length && j >= 0;++i,--j){
            if(boardChars[i][j] == 'X')
                ++sum;
            else if(boardChars[i][j] == 'O')
                --sum;
            if(sum == boardChars[i].length )
                return "X";
            if(sum == boardChars[i].length * -1)
                return "O";
        }
        return "";
    }

    private String checkRow() {
        for(int i = 0; i < boardChars.length;++i){
            int sum = 0;
            for(int j = 0; j < boardChars[i].length;++j){
                if(boardChars[i][j] == 'X')
                    ++sum;
                else if(boardChars[i][j] == 'O')
                    --sum;
            }
            if(sum == boardChars[i].length )
                return "X";
            if(sum == boardChars[i].length * -1)
                return "O";
        }
        return "";
    }
    private String checkCol(){
        for(int i = 0; i < boardChars.length;++i){
            int sum = 0;
            for(int j = 0; j < boardChars[i].length;++j){
                if(boardChars[j][i] == 'O')
                    --sum;
                else if(boardChars[j][i] == 'X')
                    ++sum;
            }
            if(sum == boardChars[i].length )
                return "X";
            if(sum == boardChars[i].length * -1)
                return "O";
        }
        return "";
    }


}
