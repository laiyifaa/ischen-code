package algorithm;

public class EulerService {
    //欧拉素数筛
    int[] prime = new int[20000];
    int c = 0;
    boolean[] isVisit = new boolean[20000];
    public void EulerSevie(int n)
    {
        for(int i = 2;i <= n; ++i)//老规矩，遍历区间
        {
            if(isVisit[i] == false) //如果这个数未被访问，则是素数
                prime[++c] = i;     //将素数保存在素数数组里面，计数+1
            //下面for循环及里面的语句才是这个算法的精髓，我们下面细讲
            for(int j = 1;j <= c && i * prime[j] <= n; ++j)
            {
                isVisit[i * prime[j] ] = true;
                if (i % prime[j] == 0)
                    break;
            }
        }
    }
    boolean[] isPrime = new boolean[20000];

    void getPrime(int n)
    {
        for(int i=2;i<=n;++i)
            isPrime[i] = true;  //假设2-n都是素数
        for(int i=2;i<=n;++i)   //遍历2-n里面所有数
            if(isPrime[i])      //如果i是素数
                //i是素数的话，那么i的倍数肯定就不是合适
                //即 i*2，i*3 .....i*j肯定不是素数，注意边界i*j<=n
                for(int j=i;i*j<=n;++j)
                    //n以内，且是i的倍数的数肯定不是素数，设为false
                    isPrime[i*j] = false;
    }




}
