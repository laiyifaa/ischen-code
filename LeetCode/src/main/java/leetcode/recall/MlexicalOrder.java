package leetcode.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MlexicalOrder {

    //386. 字典序排数
    public List<Integer> lexicalOrder(int n) {
        if(n < 1 )
            return new LinkedList<>();
        List<Integer> ansList = new ArrayList<>(n);
        dfs(1,n,ansList,10);
        return ansList;
    }

    private void dfs(int index, int n, List<Integer> ansList,int top) {
        if(index > n)
            return;
        for(int i = index ;  i < top && i <= n;++i){
            ansList.add(i);
            dfs(i * 10,n,ansList,(i + 1) * 10);
        }
    }
    public static void main(String[] args){
        MlexicalOrder  q = new MlexicalOrder();
        System.out.println(q.lexicalOrder(34));
    }
}
