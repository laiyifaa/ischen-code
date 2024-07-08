package leetcode.array;

public class MIsChen_maxAliveYear {

    //面试题 16.10. 生存人数
    //差分数组
    //1900 -2000
    //初始化都是0，year数组就是1900-2000的存活人数的差分数组
    int[] year = new int[102];/*
    public int maxAliveYear(int[] birth, int[] death) {
        for(int i = 0;i < birth.length; ++i){
            ++year[birth[i] - 1900];
            --year[death[i] - 1900 + 1];
        }
        int x = year[0];
        int ansAlive = x;
        int ansYear = 1900;
        for(int i = 1; i < year.length;++i){
            int y  =  x + year[i];
            if(y > ansAlive){
                ansAlive = y;
                ansYear = i;
            }

            x = y;
        }
        return ansYear + 1900 ;
    }*/
    //可用前缀和
    public int maxAliveYear(int[] birth, int[] death) {
        for(int i = 0;i < birth.length; ++i){
            ++year[birth[i] - 1900];
            --year[death[i] - 1900 + 1];
        }
        //构造前缀和数组
        int[] preSum = new int[102];
        preSum[0] = year[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = year[i] + preSum[i-1];
        }

        int maxLives = -1;
        int minyear = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (preSum[i] > maxLives) {
                minyear = i + 1900;
                maxLives = preSum[i];
            }
        }
        return minyear;
    }
    public static void main(String[] args){
        MIsChen_maxAliveYear q = new MIsChen_maxAliveYear();
        System.out.println(q.maxAliveYear(new int[]{
                1900,1901,1950
        },new int[]{
                1948,1951,2000
        }));
    }
}
