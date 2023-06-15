package hot_100.array;

import java.util.ArrayList;
import java.util.List;

public class MspiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m*n);
        int up = 0;
        int left = 0;
        int right = n-1;
        int down = m-1;
        while (true){
            for(int i = left ;i <=right;i++){
                list.add(matrix[up][i]);
            }
            if(++up > down)
                break;
            for(int i = up;i<=down;i++){
                list.add(matrix[i][right]);
            }
            if(--right<left)
                break;
            for(int i = right;i>=left;i--){
                list.add(matrix[down][i]);
            }
            if(--down<up)
                break;
            for(int i = down;i>=up;i--){
                list.add(matrix[i][left]);
            }
            if(++left>right)
                break;
        }
        return list;
    }
    public static void main(String[] args){
        MspiralOrder q = new MspiralOrder();
        q.spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        });
    }
}
