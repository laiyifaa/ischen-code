package leetcode.binaryTree;

import java.util.LinkedList;

public class Mconnect {
    //117. 填充每个节点的下一个右侧节点指针 II
    public Node connect(Node root) {
        if(null == root)
            return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(root);
        while (! queue.isEmpty()){
            int cnt = queue.size();
            Node cur = queue.pollFirst();
            if(cur.left != null)
                queue.addLast(cur.left);
            if(cur.right!= null)
                queue.addLast(cur.right);
            --cnt;
            while (cnt > 0){
                --cnt;
                Node temp = queue.pollFirst();
                cur.next = temp;
                cur = temp;
                if(cur.left != null)
                    queue.addLast(cur.left);
                if(cur.right!= null)
                    queue.addLast(cur.right);
            }
            cur.next = null;
        }
        return root;
    }
}
