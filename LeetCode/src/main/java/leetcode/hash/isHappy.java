package leetcode.hash;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class isHappy {

    //202. 快乐数
    Set<Integer> set;
    public boolean isHappy(int n) {
        if(n < 1)
            return false;
        set = new HashSet<>();
        return check(n);
    }

    private boolean check(int n) {
        if(set.contains(n))
            return false;
        set.add(n);
        int sum = 0;
        while (n > 0){
            int x = n % 10;
            sum += x*x;
            n/=10;
        }
        if(sum == 1)
            return true;
        return check(sum);
    }
}
