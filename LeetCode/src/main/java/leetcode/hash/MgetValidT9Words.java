package leetcode.hash;


import java.util.LinkedList;
import java.util.List;

public class MgetValidT9Words {

    int[] used;
    //面试题 16.20. T9键盘
    public List<String> getValidT9Words(String num, String[] words) {
        if(null == num || num.length() == 0)
            return new LinkedList<>();
        if(null == words || words.length == 0)
            return new LinkedList<>();
        init();
        List<String> ans = new LinkedList<>();
        for(String word : words){
            if(check(num,word)){
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean check(String num,String word) {
        if(num.length() == word.length()){
            for(int i = 0 ; i < word.length();++i){
                char numi = num.charAt(i) ;
                if(numi <= '1' || numi >'9')
                    return false;
                char wordi = word.charAt(i);
                if(  used[wordi] != numi - '0')
                    return false;
            }
            return true;
        }
        return false;
    }

    private void init() {
      used = new int[128];
      used['a'] = 2;
      used['b'] = 2;
      used['c'] = 2;
      used['d'] = 3;
      used['e'] = 3;
      used['f'] = 3;
      used['g'] = 4;
      used['h'] = 4;
      used['i'] = 4;
      used['j'] = 5;
      used['k'] = 5;
      used['l'] = 5;
      used['m'] = 6;
      used['n'] = 6;
      used['o'] = 6;
      used['p'] = 7;
      used['q'] = 7;
      used['r'] = 7;
      used['s'] = 7;
      used['t'] = 8;
      used['u'] = 8;
      used['v'] = 8;
      used['w'] = 9;
      used['x'] = 9;
      used['y'] = 9;
      used['z'] = 9;
    }
    public static void main(String[] args){  
        MgetValidT9Words q = new MgetValidT9Words();
        q.getValidT9Words("9675973753",
                new String[]{
                        "alasvnpzur", "znwdgoiwso", "wduzrpnqrv", "ymrkxqdrlf", "epsqjclyqe", "zopjysdqke", "zhfxsdeimz", "eitgrsdnvt"
                });
    }
}
