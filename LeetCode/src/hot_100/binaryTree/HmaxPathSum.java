package hot_100.binaryTree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HmaxPathSum {
    Queue<Integer> queue ;
    public int maxPathSum(TreeNode root) {
        if(null == root)
            return 0;
        queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.add(dfs(root));
        return queue.peek();
    }
    private int dfs(TreeNode root){
        if(null == root)
            return -1001;
        int lMax = dfs(root.left);
        int rMax = dfs(root.right);
        int MLMax = root.val + lMax;
        int MRMax = root.val + rMax;
        int LMRMax  = MLMax + rMax;
        queue.add(lMax);
        queue.add(rMax);
        queue.add(MLMax);
        queue.add(MRMax);
        queue.add(LMRMax);
        return Math.max(root.val,Math.max(MLMax,MRMax));
    }
    public static void main(String[] args){
        TreeNode root = TreeNode.create(new Integer[]{1,2,3});
        HmaxPathSum q = new HmaxPathSum();
        System.out.println(q.maxPathSum(root));
        root = TreeNode.create(new Integer[]{-10,9,20,null,null,15,7});
        System.out.println(q.maxPathSum(root));
    }
}
