package leetcode.array;

import java.util.Arrays;

public class Hcandy {

    //135. 分发糖果
    public int candy(int[] ratings) {
        if(null == ratings )
            return 0;
        if(ratings.length <= 1)
            return ratings.length;

        int[] score = new int[ratings.length];
        Arrays.fill(score,1);
        int ans = 0;
        for(int i = 1;i < ratings.length ;++i){
            if(ratings[i] > ratings[i - 1])
                score[i] = score[i - 1] + 1;
        }
        for(int i = ratings.length - 1;i >= 1;--i){
            if(ratings[i - 1] > ratings[i ]){
                if(score[i - 1] > score[i] )
                    continue;
                score[i - 1] = score[i] + 1;
            }
        }
        for(int i = 0;i < score.length;++i)
            ans+=score[i];
        return ans;
    }
    public static void main(String[] args){
        Hcandy q = new Hcandy();
        System.out.println(
                q.candy(new int[]{
                        1,3,4,5,2
                })
        );
    }
}
