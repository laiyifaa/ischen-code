package leetcode.sum;

public class McarPooling {

    //1094. 拼车
    //差分
    //开一个数组记录变化，最后一次遍历计算变化
    public boolean carPooling(int[][] trips, int capacity) {
        if(capacity == 0 || null == trips || trips.length == 0)
            return true;
        int[]d = new int[1005];
        int end = 0;
        for(int i = 0;i < trips.length;++i){
            int[] trip = trips[i];
            d[trip[1]] += trip[0];
            d[trip[2]] -= trip[0];
            if(trip[2] > end){
                end = trip[2];
            }
        }
        int temp = 0;
        for(int i = 0;i <= end;++i){
            temp += d[i];
            if(temp > capacity)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        McarPooling q = new McarPooling();
        System.out.println(q.carPooling(new int[][]{
                {2,1,5},{3,3,7}
        },5));
    }
}
