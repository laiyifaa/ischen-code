package hot_100.binaryTree;

import java.util.LinkedList;
import java.util.List;

public class inorderTraversal {
    private void inorderSearch(TreeNode root,List list){
        if(null != root){
            inorderSearch(root.left,list);
            list.add(root.val);
            inorderSearch(root.right,list);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List list = new LinkedList();
        inorderSearch(root,list);
        return list;
    }
}
