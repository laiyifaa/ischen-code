package leetcode.binaryTree;

public class MIsChen_deleteNode {

    //如果目标节点大于当前节点值，则去右子树中删除；
    //如果目标节点小于当前节点值，则去左子树中删除；
    //如果目标节点就是当前节点，分为以下三种情况：
    //其无左子：其右子顶替其位置，删除了该节点；
    //其无右子：其左子顶替其位置，删除了该节点；
    //其左右子节点都有：其左子树转移到其右子树的最左节点的左子树上，然后右子树顶替其位置，由此删除了该节点。

    //450. 删除二叉搜索树中的节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if(null == root)
            return null;
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right,key);
        }else {
            if(root.left == null && root.right == null)
                return null;
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            TreeNode temp = root.right;
            while (true){
                if(temp.left  == null)
                    break;
                temp = temp.left;
            }
            temp.left = root.left;
            return root.right;
        }
        return root;
    }

}
