package hot_100.recall;

import java.util.LinkedList;
import java.util.List;

public class HsolveNQueens_II {

    char[][] map ;
    int len ;
    int ans = 0;
    private void dfs(int step){
        if(step == len){
            ++ans;
            return;
        }
        for(int i = 0;i < len ; ++i){
            if(check(step,i)){
                map[step][i] = 'Q';
                dfs(step + 1);
                map[step][i] = '.';
            }
        }
    }
    private boolean check(int x,int y){
        boolean ans = true;
        // up
        for(int i = x - 1;i >= 0; --i){
            if(map[i][y] == 'Q')
                return false;
        }

        //left
        for(int i = y - 1;i >= 0; --i){
            if(map[x][i] == 'Q')
                return false;
        }
        //left up
        for(int i = x - 1,j = y - 1;i >= 0 && j >= 0;--i,--j){
            if(map[i][j] == 'Q')
                return false;
        }
        //right up
        for(int i = x  - 1,j = y + 1;i >= 0 && j<len;--i,++j){
            if(map[i][j] == 'Q')
                return false;
        }
        return true;
    }
    //52. N皇后II

    public int totalNQueens(int n) {
        ans = 0;
        if( n > 9 || n <= 0){
            return ans;
        }
        len = n;
        map = new char[n][n];
        for(int i = 0 ; i < n; ++i){
            for(int j = 0; j < n; ++j)
                map[i][j] = '.';
        }
        dfs(0);
        return ans;
    }


}
