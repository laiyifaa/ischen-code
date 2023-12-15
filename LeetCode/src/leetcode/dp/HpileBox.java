package leetcode.dp;

import java.util.Arrays;

public class HpileBox {

    //面试题 08.13. 堆箱子
    //将一维排序，然后最长上升子序列（LIS）
    public int pileBox(int[][] box) {
        if(null == box || box[0].length == 0)
            return 0;
        int res = 0;
        int[] dp = new int[box.length + 1];
        Arrays.sort(box, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0 ; i < box.length;++i){
            dp[i] = box[i][2];
        }
        for(int i = 0 ; i < box.length;++i){
            for(int j = i + 1 ;j < box.length;++j){
                if(box[j][0] > box[i][0] && box[j][1] > box[i][1] && box[j][2] > box[i][2]){
                    dp[j] = Math.max(dp[j],dp[i] + box[j][2]);
                }
            }
        }
        for(int i = 0; i < box.length;++i){
            if(res < dp[i])
                res = dp[i];
        }
        return res;
    }
    public static void main(String[] args){
        HpileBox q = new HpileBox();
        q.pileBox(new int[][]{
                {9, 9, 10}, {8, 10, 9}, {9, 8, 10}, {9, 8, 10}, {10, 8, 8}, {9, 8, 9}, {9, 8, 8}, {8, 9, 10}, {10, 9, 10}, {8, 8, 10}, {10, 9, 10}, {10, 9, 8}, {8, 9, 9}, {9, 10, 8}, {8, 9, 9}, {10, 10, 9}, {8, 9, 10}, {8, 10, 10}, {8, 9, 10}, {10, 10, 8}, {10, 10, 9}, {9, 10, 10}, {10, 8, 9}, {10, 10, 9}, {8, 9, 10}, {8, 8, 9}, {8, 10, 10}, {9, 9, 10}, {10, 8, 8}, {10, 10, 8}, {8, 9, 9}, {8, 9, 8}, {10, 10, 8}, {8, 10, 8}, {10, 9, 10}, {9, 9, 10}, {9, 9, 9}, {8, 9, 8}, {9, 8, 8}, {8, 9, 10}, {10, 10, 8}, {9, 9, 9}, {10, 10, 10}, {10, 9, 8}, {9, 8, 9}, {8, 8, 10}, {8, 8, 8}, {8, 8, 8}, {8, 9, 10}, {10, 9, 8}, {8, 10, 8}, {8, 10, 10}, {9, 10, 10}, {8, 8, 9}, {9, 9, 9}, {10, 8, 8}, {8, 10, 10}, {9, 10, 9}, {9, 9, 8}, {8, 10, 9}, {9, 8, 8}, {9, 9, 10}, {9, 10, 10}, {8, 8, 10}
        });
    }
}
