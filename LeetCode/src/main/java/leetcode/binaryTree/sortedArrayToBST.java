package leetcode.binaryTree;

public class sortedArrayToBST {
    //108. 将有序数组转换为二叉搜索树
    //面试题 04.02. 最小高度树
    private TreeNode searchMidOrder(int l ,int r,int[] nums){
        if(l>r)
            return null;
        int mid = l +(r-l)/2;
        TreeNode x = new TreeNode(nums[mid]);
        x.left = searchMidOrder(l,mid-1,nums);
        x.right = searchMidOrder(mid+1,r,nums);
        return x;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return searchMidOrder(0,nums.length-1,nums);
    }
    public static void main(String[] args){
        sortedArrayToBST q = new sortedArrayToBST();
        TreeNode x = q.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(x);
    }
}
