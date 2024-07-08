package leetcode.recall;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MIsChen_restoreIpAddresses {

    //93. 复原 IP 地址
    private HashSet<String> set ;
    int[] used = new int[4];
    public List<String> restoreIpAddresses(String s) {
        if(null == s || s.length() < 4)
            return new ArrayList<>();
        set = new HashSet<>(s.length() * s.length());
        dfs(s,0,0);
        return new ArrayList<>(set);
    }

    private void dfs(String s, int index, int step) {
        if(step > 4)
            return;
        if(index >= s.length() && step == 4){
            StringBuilder temp = new StringBuilder();
            for(int i = 0;i < used.length - 1;++i){
                temp.append(used[i]);
                temp.append('.');
            }
            temp.append(used[used.length - 1]);
            set.add(temp.toString());
            return ;
        }
        //剪枝
        if(s.length() - index < 4 - step)
            return;
        if(3 * (4 - step) < s.length() - index)
            return;
        for(int i = 0;i < 3;++i){
            if(index + i >= s.length())
                break;
            int nextValue = getValue(s,index,index + i);
            if(nextValue != -1){
                used[step] = nextValue;
                dfs(s,index + i + 1,step + 1);
            }
        }
    }

    private int getValue(String s, int begin,int end) {
        int ans = 0;
        int index = begin;
        if(end - begin > 0 && s.charAt(index) == '0')
            return -1;
        while (index <= end){
            ans = ans * 10 + s.charAt(index) - '0';
            ++index;
        }
        if(ans > 255)
            return -1;
        return ans;
    }

}
