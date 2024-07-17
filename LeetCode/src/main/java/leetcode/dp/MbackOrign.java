package leetcode.dp;

public class MbackOrign {

/*    0-12共13个数构成一个环，从0出发，每次走1步，走n步回到0共有多少种走法（2020.09 字节跳动-广告-后端）[1]
    0-8组成一个圆环，从0出发，每次可以逆时针和顺时针走，走n步能回到0有多少种情况（2020.09 字节跳动-people-后端）[2]
    0~9的环，从0出发，N步后能否走回0。（2020.07 字节跳动-电商-后端）[3]
    圆环回原点问题 (2020.08 字节跳动-飞书-后端)[4]*/
    public int backOrign(int n){
        int len = 10;
        int[][] dp = new int[len + 1][len + 1];
        dp[0][0] = 1;
        for(int i = 1;i <= n;++i){
            for(int j = 0;j < len;++j){
                //dp[i][j]表示从0出发，走i步到j的方案数
                dp[i][j] = dp[i - 1][(j - 1 + len) % len] + dp[i - 1][(j + 1)%len];
            }
        }
        return dp[n][0];
    }
    public static void main(String[] args){  
        MbackOrign q = new MbackOrign();
        System.out.println(q.backOrign(2));
    }
}

