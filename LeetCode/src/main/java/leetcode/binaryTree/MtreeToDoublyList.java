package leetcode.binaryTree;

public class MtreeToDoublyList {
    //leetcode 426将二叉搜索树转换为排序的双向链表
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre,next;
    public Node treeToDoublyList(Node root) {
        if(null == root )
            return null;
        if((root.left == null && root.right == null)){
            root.left = root;
            root.right = root;
            return root;
        }
        Node head = new Node();
        pre = head;
        dfs(root);
        head.right.left = pre;
        pre.right = head.right;
        return head.right;
    }

    private void dfs(Node root) {
        if(null != root){
            dfs(root.left);
            pre.right = root;
            root.left = pre;
            //root.right = next;
            pre = root;
            dfs(root.right);
        }
    }
  public static void main(String[] args){
      Node root = new Node(4);
      //root.left = new Node(2);
      //root.right = new Node(5);
      //root.left.left = new Node(1);
      //root.left.right = new Node(3);
      MtreeToDoublyList q = new MtreeToDoublyList();
      Node node = q.treeToDoublyList(root);
      System.out.println(node);
  }

}


