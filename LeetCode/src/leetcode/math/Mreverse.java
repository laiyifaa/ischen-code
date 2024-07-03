package leetcode.math;

public class Mreverse {

    //7. 整数反转
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE || x == 0)
            return 0;
        boolean s = false;
        if(x < 0){
            s = true;
            x = -1 * x;
        }
        int temp = x;
        int ans = 0;
        while (temp > 0){
            if(ans * 10  != ans * 10l)
                return 0;
            ans *= 10;
            ans += (temp%10);
            temp /= 10;
        }
        return s?-1*ans :ans;
    }
    public static void main(String[] args){
        Mreverse q = new Mreverse();
        System.out.println(q.reverse(1534236469));
    }
}
