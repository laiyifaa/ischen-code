package leetcode.binaryTree;

public class MIsChen_construct {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    //427. 建立四叉树
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length, grid.length);
    }

    private Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean flag = true;
        for(int i = r0;i < r1;++i){
            for(int j = c0; j < c1;++j){
                if(grid[i][j] != grid[r0][c0]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }
        if(flag)
            return new Node(grid[r0][c0] == 1,true);

        Node ans = new Node(true,false,
                            dfs (grid,r0,c0,(r1 + r0) / 2,(c0 + c1) /2 ),
                    dfs(grid,r0, (c0 + c1) / 2, (r1 + r0) /2 ,c1),
                    dfs(grid,(r1 + r0)/2,c0,r1,(c0 + c1)/2),
                    dfs(grid,(r1 + r0)/2,(c0 + c1)/2,r1,c1));
        return ans;
    }
}
