package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class McheckSubTree {
    //面试题 04.10. 检查子树
    //双层DFS
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return false;
        if(t2 == null)
            return true;
        return find(t1,t2) || checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
    }
    private boolean find(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        if(t1.val == t2.val ){
            return find(t1.left,t2.left) && find(t1.right,t2.right);
        }
        return false;
    }

    //kmp 实现
    List<Integer> sOrder = new ArrayList<Integer>();
    List<Integer> tOrder = new ArrayList<Integer>();
    int maxElement, lNull, rNull;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        maxElement = Integer.MIN_VALUE;
        getMaxElement(s);
        getMaxElement(t);
        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(s, sOrder);
        getDfsOrder(t, tOrder);

        return kmp();
        
    }

    private void getDfsOrder(TreeNode t, List<Integer> tar) {
        if (t == null) {
            return;
        }
        tar.add(t.val);
        if (t.left != null) {
            getDfsOrder(t.left, tar);
        } else {
            tar.add(lNull);
        }
        if (t.right != null) {
            getDfsOrder(t.right, tar);
        } else {
            tar.add(rNull);
        }
    }
    public boolean kmp(){
        int sLen = sOrder.size(), tLen = tOrder.size();
        int[] next = new int[tLen + 1];
        initNext(next);
        int i = 0;
        int j = 0;
        while (i < sLen){
            if(j == -1 || sOrder.get(i).equals(tOrder.get(j))){
                ++i;
                ++j;
            }else {
                j = next[j];
            }
            if(j == tLen){
                return true;
            }
        }
        return false;
    }

    private void initNext(int[] next) {
        next[0] = -1;
        int k = -1;
        int j = 0;
        int m = tOrder.size();
        while (j < m){
            if(k == -1 || tOrder.get(k).equals(tOrder.get(j))){
                ++k;
                ++j;
                next[j] = k;
            }else {
                k = next[k];
            }
        }

    }

    private void getMaxElement(TreeNode t) {
        if (t == null) {
            return;
        }
        maxElement = Math.max(maxElement, t.val);
        getMaxElement(t.left);
        getMaxElement(t.right);
    }

    public static void main(String[] args){
        McheckSubTree q = new McheckSubTree();
        TreeNode x = TreeNode.create(new Integer[]{
                1, 2, 3
        });
        System.out.println(q.isSubtree(x,x.left));
    }
}
