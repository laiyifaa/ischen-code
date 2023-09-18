package leetcode.martix;

import java.util.HashMap;
import java.util.Map;

public class MIsChen_equalPairs {

    public int equalPairs(int[][] grid) {
        //前缀字典树
        int n=grid.length;
        int ans=0;
        Node root=new Node();
        for(int j=0;j<n;j++){
            Node node=root;
            for(int i=0;i<n;i++){
                int num=grid[i][j];
                Node next=node.map.get(num);
                if(next==null)node.map.put(num,new Node());
                node=node.map.get(num);
            }
            node.count++;
        }
        for(int i=0;i<n;i++){
            Node node=root;
            for(int j=0;j<n;j++){
                int num=grid[i][j];
                if(node.map.get(num)==null)break;
                node=node.map.get(num);
            }
            ans+=node.count;
        }
        return ans;
    }
    class Node{
        Map<Integer,Node> map=new HashMap<>();
        int count;

    }
    //2352. 相等行列对 转置
   /* public int equalPairs(int[][] grid) {
        if(null == grid || grid.length == 0)
            return 0;
        int n = grid.length;
        int[][]temp = new int[n][n];
        for(int i = 0;i < n;++i){
            for(int j = 0;j < n;++j ){
                temp[i][j] = grid[j][i];
            }
        }
        int ans = 0;
        for(int i = 0;i<n;++i){
            for(int j = 0;j<n;++j){
                if(check(temp[i],grid[j]))
                    ++ans;
            }
        }
        return ans;
    }
    private boolean check(int[] a,int[] b){
        for(int i = 0;i<a.length;++i){
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }*/
    public static void main(String[] args){
        MIsChen_equalPairs q = new MIsChen_equalPairs();
        System.out.println(
                q.equalPairs(new int[][]{
                        {3,2,1},
                        {1,7,6},
                        {2,7,7}
                })
        );
    }
}
