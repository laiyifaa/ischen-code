package leetcode.sum;

import java.util.LinkedList;

public class HfindKthNumber {


    class  Node{
        Node[] children = new Node[10];
        int num = -1;
    }

    Node root;
    int K = 0;
    //440. 字典序的第K小数字
    // n = 13 k = 2
    //1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9
    public int findKthNumber(int n, int k) {
        if(n < k)
            return 0;
        long cnt = 1;
        long prefix = 1;
        while (cnt < k){
            int total = getCount(prefix,n);
            if(cnt + total > k ){
                prefix *= 10;
                ++cnt;
            }else if(cnt + total <= k){
                ++prefix;
                cnt += total;
            }
        }
        return (int)prefix;
        /*     字典树 tle
        if(k > n)
            return 0;
        root = new Node();
        for(int i = 1;i <= n; ++i){
            add(i);
        }
        K = k;
        return search(root);*/
    }
    //采用非递归处理
    private int getCount(long prefix, int n) {
        int ans = 0;
        for(long cur = prefix, next = prefix + 1; cur <= n; cur *= 10, next *= 10)
            ans += Math.min(next, n+1) - cur;
        return ans;
    }


    private int search(Node cur) {
        if(cur.num != -1)
            --K;
        if(K == 0)
            return cur.num;
        for(int i = 0;i < 10;++i){
            if(null != cur.children[i]){
                int ans = search(cur.children[i]);
                if(K == 0)
                    return ans;
            }
        }
        return 0;
    }

    private void add(int val) {
        LinkedList<Integer> stack = new LinkedList<>();
        int temp = val;
        while (val > 0){
            stack.addFirst(val % 10);
            val /= 10;
        }
        Node cur = root;
        for(Integer x : stack){
            if(cur.children[x] == null){
                cur.children[x] = new Node();
            }
            cur = cur.children[x];
        }
        cur.num = temp;
    }

    public static void main(String[] args){
        HfindKthNumber q = new HfindKthNumber();
        System.out.println(q.findKthNumber(681692778    ,351251360));
    }
}
