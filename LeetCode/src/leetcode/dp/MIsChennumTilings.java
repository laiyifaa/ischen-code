package leetcode.dp;

public class MIsChennumTilings {
    //790. 多米诺和托米诺平铺
    //f(n) = f(n-1) + f(n-2) + 2*(f(n-3)+....+1) -------- 【1】
    //f(n-1) = f(n-2) + f(n-3) + 2 *( f(n-4)+....+1) -------【2】
    //[1] - [2]
    //f(n) = 2*f(n-1) + f(n-3)
    private static final long MOD = (long) 1e9 + 7;
    public int numTilings(int n) {
        if (n == 1) return 1;
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; ++i)
            f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
        return (int) f[n];
    }
}
