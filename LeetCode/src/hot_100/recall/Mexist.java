package hot_100.recall;

public class Mexist {

    int dir[][] = new int[][]{
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };

    private boolean dfs(char[][] board,int x,int y,int index ,String word){
        boolean ans = false;
        if(board[x][y] == word.charAt(index)){
            if(index == word.length() - 1)
                return true;
            char temp = board[x][y];
            board[x][y] = '#';
            for(int i = 0;i < 4; ++i){
                int xx = x + dir[i][0];
                int yy = y + dir[i][1];
                if((xx >= board.length || xx < 0) || (yy >= board[0].length || yy < 0))
                    continue;
                if(board[xx][yy] == '#')
                    continue;
                ans = dfs(board, xx, yy, index + 1, word);
                if(ans)
                    break;
            }
            board[x][y] = temp;
        }
        return ans;
    }
    //79. 单词搜索
    public boolean exist(char[][] board, String word) {
        if(null == board || null == board[0] || null == word || word.length() == 0)
            return true;
        int m = board.length; //几行
        int n = board[0].length; // 几列
        boolean ans = false;
        for(int i = 0;i < m; ++i){
            for(int j = 0 ; j < n ; ++j){
                if(board[i][j] == word.charAt(0)){
                    ans = dfs(board,i,j,0,word);
                    if(ans)
                       break;
                }
            }
            if(ans)
                break;
        }
        return ans;
    }
    public static void main(String[] args){
        Mexist q = new Mexist();
        System.out.println(q.exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        },"SEE"));
    }
}
