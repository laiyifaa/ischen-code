package leetcode.binSearch;

public class MshipWithinDays {
    //1011. 在 D 天内送达包裹的能力
    public int shipWithinDays(int[] weights, int days) {
        int sumWeight = 0;
        int maxWeight = 0;
        for(int i = 0;i < weights.length;++i){
            sumWeight +=weights[i];
            if(weights[i] > maxWeight)
                maxWeight = weights[i];
        }
        int r = sumWeight;
        int l = maxWeight;
        while (l <= r){
            int mid = l + ( r - l) /2;
            int temp = getDays(weights,mid);
            if(temp > days){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
    private int getDays(int[]weights,int k){
        int cnt = k;
        int ans = 1;
        for(int i = 0;i<weights.length;++i){
            if(cnt >= weights[i])
                cnt-=weights[i];
            else {
                ++ans;
                cnt = k;
                --i;
            }
        }
        return ans;
    }
    public static void main(String[] args){  
        MshipWithinDays q  = new MshipWithinDays();
        System.out.println(q.shipWithinDays(new int[]{
                1,2,3,1,1
        },4));
    }
}
