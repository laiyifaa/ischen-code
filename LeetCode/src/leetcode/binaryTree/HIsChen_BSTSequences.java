package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HIsChen_BSTSequences {
    //面试题 04.09. 二叉搜索树序列
    //BFS回溯 queue的temp缓存，然后晦朔
    List<List<Integer>> ans ;
    Integer[] path;
    int nodeCnt ;
    int step;
  ;
    //getLen
    private Integer getLen(TreeNode root){
        if(null == root)
            return 0;
        int l = getLen(root.left);
        int r = getLen(root.right);
        return  l + r + 1;
    }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        ans = new LinkedList<>();
        if(null == root){
            ans.add(new LinkedList<>());
            return ans;
        }
        nodeCnt = getLen(root);
        path = new Integer[nodeCnt];
        step = 0;
        LinkedList<TreeNode>  queue = new LinkedList<>();
        queue.addLast(root);
        bfs(queue);
        return ans;
    }

    private void bfs(List<TreeNode>  queue) {
        if(step == nodeCnt){
            ArrayList<Integer> list  = new ArrayList<>(nodeCnt);
            for(int i = 0;i <  nodeCnt;++i){
                list.add(path[i]);
            }
            ans.add(list);
            return;
        }
        List<TreeNode> tempQueue = new ArrayList<>(queue);
            for(int i = 0; i < queue.size();++i){
                TreeNode curNode = queue.get(i);
                path[step++] = curNode.val;
                queue.remove(i);
                if(null != curNode.left)
                    queue.add(curNode.left);
                if(null != curNode.right)
                    queue.add(curNode.right);
                bfs(queue);
                step--;
                queue = new ArrayList<>(tempQueue);
            }
    }
    public static void main(String[] args){
        HIsChen_BSTSequences q = new HIsChen_BSTSequences();
        TreeNode treeNode = TreeNode.create(new Integer[]{
              2,1,3
        });
        q.BSTSequences(treeNode);
    }
}
