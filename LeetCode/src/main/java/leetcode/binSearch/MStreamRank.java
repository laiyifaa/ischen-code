package leetcode.binSearch;


public class MStreamRank {

    int[] tree = new int[50002];

    //面试题 10.10. 数字流的秩
    //树状数组
    public MStreamRank() {

    }

    public void track(int x) {
        for(int i = x + 1; i <= 50001; i += lowbit(i)){
            tree[i]++;
        }
    }
    private int lowbit(int x){
        return x & (-x);
    }
    public int getRankOfNumber(int x) {
        int sum = 0;
        for(int i = x + 1;i >= 1;i-=lowbit(i)){
            sum += tree[i];
        }
        return sum;
    }
    public static void main(String[] args){
        MStreamRank q = new MStreamRank();
        System.out.println(q.getRankOfNumber(1));
        q.track(0);
        System.out.println(q.getRankOfNumber(0));
    }
}
