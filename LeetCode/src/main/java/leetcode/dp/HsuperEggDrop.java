package leetcode.dp;

public class HsuperEggDrop {


    //887.鸡蛋掉落

    //k个鸡蛋 n个楼层 确定f(满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。)
    // 碎与不碎 影响了 扔的次数 即 鸡蛋个数
    // dp[i][j] = i个鸡蛋，j层楼的f值
    //k个鸡蛋 第 x个楼层 在某一层扔鸡蛋时 碎了 则次数-1 且楼层只在下方进入子问题 dp[k-1][x-1],dp[k][x] = 1+ dp[k-1][x-1]
    //没碎 则进入子问题 dp[k][n-x] ,dp[k][x] = 1+ dp[k][n-x]
    //那么我们固定k 固定n 将x从1-n开始遍历 不难得出
    //dp[k][n] = 1 + min(1-n) [max(dp[k-1][x-1],dp[k][n-x])]
    //进一步发现 dp[k][n] 与n呈单调递增关系，如何确定dp[k-1][x-1],dp[k][n-x]最大值最小 即2者的取值x相近
    //最大值最小问题引入二分查找，即x0 时T1(x0) > T2(x0)

    public int superEggDrop(int k, int n) {
        //普通dp
        //init
        int[][]dp = new int[k + 1][n + 1];
        for(int i = 1;i<=n;++i){
            dp[1][i] = i;//only one egg
            dp[0][i] = 0;// no egg；
        }
        //run
        for(int i = 2;i <= k;++i){
            for(int j = 1;j<= n;++j){

                //非二分解法
                /*
                    int minDrop = j * j;
                    for(int x = 1;x<=j;++x){
                    // 碎了，就需要往低层继续扔：层数少 1 ，鸡蛋也少 1
                    // 不碎，就需要往高层继续扔：层数是当前层到最高层的距离差，鸡蛋数量不少
                    // 两种情况都做了一次尝试，所以加 1
                    //minDrop = Math.min(minDrop,1 + Math.max(dp[i - 1][ x- 1],dp[i][j -x]));

                }*/
                //二分解法
                int left = 1;
                int right = j;
                while (left <= right){
                    int mid = left + (right - left )/2;
                    int leftValue = dp[i - 1][ mid  - 1];
                    int rightValue = dp[i][j - mid];
                    if(leftValue > rightValue){
                        right = mid - 1;
                    }else left = mid + 1 ;
                }
                if(left > j )
                    left = j;
                if(right < 0)
                    right = 0;
                dp[i][j] = 1 + Math.min(Math.max(dp[i - 1][left -1],dp[i][j - left]),Math.max(dp[i - 1][right -1],dp[i][j - right]));
            }
        }
        return dp[k][n];
    }
    public static void main(String[] args){
        HsuperEggDrop q = new HsuperEggDrop();
        System.out.println(q.superEggDrop(3,14));
    }
}
