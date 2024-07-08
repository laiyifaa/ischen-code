package leetcode.graph;

public class MfindCircleNum {
    //547. 省份数量
    boolean[] used;
    public int findCircleNum(int[][] isConnected) {

        if (null == isConnected || isConnected.length == 0 || isConnected[0].length == 0)
            return 0;
        int n = isConnected.length;
        used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < isConnected.length; ++i) {
            if (!used[i]) {
                ++ans;
                used[i] = true;
                dfs(isConnected,i);
            }
        }
        return ans;
    }
    private void dfs(int[][] isConnected,int index){
        for(int i = 0;i < isConnected[index].length;++i){
            if(i == index || isConnected[index][i] == 0)
                continue;
            if(used[i] == false && isConnected[index][i] == 1){
                used[i] = true;
                dfs(isConnected,i);
            }
        }
    }
    public static void main(String[] args){
        MfindCircleNum q = new MfindCircleNum();
        System.out.println(
                q.findCircleNum(new int[][]{
                        {1,1,0},
                        {1,1,0},
                        {0,0,1}
                })
        );
    }
}

