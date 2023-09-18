package leetcode.recall;

import java.util.LinkedList;
import java.util.List;

public class HsolveNQueens {

    List<List<String>> ans;
    char[][] map ;
    int len ;
    private void dfs(int step){
        if(step == len){
            List<String> list = new LinkedList<>();
            for(int i = 0;i < len;++i){
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < len; ++j){
                    temp.append(map[i][j]);
                }
                list.add(new String(temp));
            }
            ans.add(list);
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
    //51. N皇后
    public List<List<String>> solveNQueens(int n) {
        ans = new LinkedList<>();
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
    public static void main(String[] args){
        HsolveNQueens q = new HsolveNQueens();
        List<List<String>> lists = q.solveNQueens(1);
        for(List<String> list : lists){
            for(String x : list){
                System.out.print(x);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}
